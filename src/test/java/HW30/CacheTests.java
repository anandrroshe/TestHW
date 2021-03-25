package HW30;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CacheTests {
    static CacheHelper cacheHelper;

    @BeforeAll
    static void initCache() {
        cacheHelper = new CacheHelper(4);
        cacheHelper.createCache("cache_one"); // test 4 delete this cache
        cacheHelper.createCache("cache_two");
        cacheHelper.createCache("cache_three"); // test 8 delete this cache

    }

    @Order(1)
    @Test
    public void checkThrowCachePutWithNullArguments() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> cacheHelper.put(null, "test_key", "test_value"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> cacheHelper.put("cache_one", null, "test_value"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> cacheHelper.put("cache_one", "test_key", null));

    }

    @Order(2)
    @Test
    public void checkCacheNotExists() {
        Assertions.assertThrows(NullPointerException.class,
                () -> cacheHelper.put("test", "test", "test"));

    }

    @Order(3)
    @Test
    public void checkCachePut() {
        Assertions.assertTrue(cacheHelper.put("cache_two", "test_key", "test_value"));
    }

    @Order(4)
    @Test
    public void checkCacheGetThrowsAfterRemove() {
        cacheHelper.put("cache_one", "test_key", "test_value");

        cacheHelper.clear("cache_one");

        Assertions.assertThrows(NullPointerException.class,
                () -> cacheHelper.get("cache_one", "test_key"));

        cacheHelper.put("cache_three", "test3", "test3");

        Assertions.assertThrows(NullPointerException.class,
                () -> cacheHelper.get("cache_three", "test3"));
    }

    @Order(5)
    @Test
    public void checkCacheGetNotThrow() {
        cacheHelper.put("cache_three", "test3", "test3");

        Assertions.assertDoesNotThrow(() -> cacheHelper.get("cache_three", "test3"));

    }

    @Order(6)
    @Test
    public void checkCacheGetThrows() {

        Assertions.assertThrows(NullPointerException.class,
                () -> cacheHelper.get("test_name_test", "test_key"));

        Assertions.assertThrows(NullPointerException.class,
                () -> cacheHelper.get("test_name1", "test_key"));
    }

    @Order(7)
    @Test
    public void checkDeleteNotExistsCacheThrow() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> cacheHelper.clear("test"));
    }

    @Order(8)
    @Test
    public void checkDeleteExistingCache() {
        Assertions.assertDoesNotThrow(() -> cacheHelper.clear("cache_three"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> cacheHelper.clear("cache_three"));
    }

    @AfterAll
    static void clearCache() {
        cacheHelper.clearAll();
    }
}