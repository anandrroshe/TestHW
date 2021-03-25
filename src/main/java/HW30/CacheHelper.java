package HW30;


import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;

import java.util.concurrent.TimeUnit;


public class CacheHelper {
    private static CacheManager cacheManager;
    private static Cache<String, Cache> mainCache;
    private static Integer cacheCycle;
//    private static final String NAME_MAIN_CACHE = "main-cache";


    public CacheHelper(final Integer cacheLifeCycle) {
        this.cacheCycle = cacheLifeCycle;
        buildCacheManager();
        buildMainCache();
    }

    private static void buildMainCache() {
        mainCache = cacheManager.createCache(" Cache ", CacheConfigurationBuilder
                .newCacheConfigurationBuilder(String.class, Cache.class, ResourcePoolsBuilder.heap(10))
                .withExpiry(Expirations.timeToLiveExpiration(Duration.of(cacheCycle, TimeUnit.MINUTES))));
        CacheLogger.logDebug(String.format("Cache create in EhcacheManager."));
    }


    public void createCache(final String cache) {
        if (checkIfInnerCacheExistsInMainCache(cache)) {
            CacheLogger.logError(String.format("Cache with this name: "+ cache +" exists. "));
            throw new IllegalArgumentException(String.format("Cache with this name: "+ cache +" exists. "));
        }
        Cache<String, Object> innerCache = cacheManager
                .createCache(cache, CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, Object.class,
                        ResourcePoolsBuilder.heap(10)).withExpiry(Expirations.timeToLiveExpiration(Duration.of(cacheCycle, TimeUnit.MINUTES))));

        mainCache.put(cache, innerCache);

        CacheLogger.logDebug(String.format("Creating Cache: " + cache));
    }


    public boolean put(final String cache, final String key, final Object value) {
        if (cache == null || key == null || value == null) {
            CacheLogger.logError("Arguments shouldn't be null.");
            throw new IllegalArgumentException("Arguments shouldn't be null.");
        }

        Cache tempCache = getCache(cache);

        if (tempCache == null) {
            CacheLogger.logError(String.format("No cache with this name: "+ cache));
            throw new NullPointerException(String.format("No cache with this name: "+ cache));
        }

        CacheLogger.logDebug(String.format("You added cache. Key: "+ key+". Name: "+cache));
        tempCache.put(key, value);

        return tempCache.containsKey(key);
    }



    public Object get(final String cache, final String key) {
        if (!checkIfInnerCacheExistsInMainCache(cache)) {
            CacheLogger.logError(String.format("No cache with this name: "+ cache));
            throw new NullPointerException(String.format("No cache with this name: "+ cache));
        }
        if (!checkIsKeyExistsInInnerCache(cache, key)) {
            CacheLogger.logError(String.format("No cache with this name: "+ cache + "or key: " + key));
            throw new NullPointerException(String.format("No cache with this name: "+ cache + "or key: "+ key));
        }

        CacheLogger.logDebug(String.format("Get value from Cache with name : " + key));
        return mainCache.get(cache).get(key);
    }



    public void clearAll() {
        mainCache.forEach(f -> cacheManager.removeCache(f.getKey()));
        CacheLogger.logDebug(String.format("Removing all cache"));
        CacheLogger.logDebug(String.format("Removing all cache"));
        buildMainCache();
    }



    public void clear(final String cache) {
        if (!checkIfInnerCacheExistsInMainCache(cache)) {
            CacheLogger.logError(String.format("No cache with this name: "+ cache));
            throw new IllegalArgumentException(String.format("No cache with this name: "+ cache));
        }
        mainCache.remove(cache);
        cacheManager.removeCache(cache);
        CacheLogger.logDebug(String.format("Removing Cache with name: "+ cache));
    }


    private static Cache<String, Object> getCache(final String cache) {
        return cacheManager.getCache(cache, String.class, Object.class);
    }


    private static void buildCacheManager() {
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        cacheManager.init();
        CacheLogger.logDebug("CacheManager initialized");
    }



    public boolean checkIsKeyExistsInInnerCache(final String cache, final String key) {
        return mainCache.get(cache).containsKey(key);
    }



    public boolean checkIfInnerCacheExistsInMainCache(final String cache) {
        return mainCache.containsKey(cache);
    }
}


