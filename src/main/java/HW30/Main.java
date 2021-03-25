package HW30;

import spark.Spark;

import java.util.Scanner;


public class Main {

    static Scanner scanner;
    private static Integer cacheCycle;

    public static void main(String[] args) {
        CacheLogger.logInfo("If you need help type - 1 ");
        CacheLogger.logInfo("If you want to start type - 2");
        CacheLogger.logInfo("If you want to exit type anything");
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        if (answer == 1){
            help("-h");
        }else if (answer == 2){
            CacheLogger.logDebug("Program start");
            selectCacheLifeCycle();
            initSpark();
            CacheLogger.logDebug("Program end");
        }else {
            CacheLogger.logDebug("Program end");
        }

    }

    private static void initSpark() {
        CacheHelper cacheHelper = new CacheHelper(cacheCycle);
        Spark.post("/create-cache/:cache-name", ((request, response) -> {
            String cacheName = request.params(":cache-name");
            if (!cacheHelper.checkIfInnerCacheExistsInMainCache(cacheName)) {
                cacheHelper.createCache(cacheName);
                return "Created new cache";
            } else {
                return String.format("Cache with name '%s' already exists", cacheName);
            }
        }));


        Spark.get("/get-value/:cache-name/:cache-key", (request, response) -> {
            response.type("application/json");
            String cacheName = request.params(":cache-name");
            String cacheKey = request.params(":cache-key");
            if (!cacheHelper.checkIfInnerCacheExistsInMainCache(cacheName)) {
                return String.format("Cache not found with name : '%s'", cacheName);
            }
            if (!cacheHelper.checkIsKeyExistsInInnerCache(cacheName, cacheKey)) {
                return String.format("Cache with name '%s' don't have key : '%s'", cacheName, cacheKey);
            }
            return cacheHelper.get(cacheName, cacheKey);
        });

        Spark.put("/put-value/:cache-name/:key-input/:inner-value", (request, response) -> {
            String cacheName = request.params(":cache-name");
            String cacheKey = request.params(":key-input");
            String cacheValue = request.params(":inner-value");

            if (!cacheHelper.checkIfInnerCacheExistsInMainCache(cacheName)) {
                return String.format("No cache with this name: " + cacheName);
            }
            cacheHelper.put(cacheName, cacheKey, cacheValue);

            return "Value is added.";

        });

        Spark.delete("/delete-cache/:cache-name", ((request, response) -> {

            String cacheName = request.params(":cache-name");

            if (!cacheHelper.checkIfInnerCacheExistsInMainCache(cacheName)) {
                return String.format("No cache with this name: " + cacheName);
            }

            cacheHelper.clear(cacheName);
            return String.format(cacheName+ " - is deleted. ");
        }));

        Spark.delete("/clear-all", ((request, response) -> {
            cacheHelper.clearAll();
            return "Cache is deleted. ";
        }));
    }


    private static void selectCacheLifeCycle() {
        CacheLogger.logInfo("Choose lifecycle of cache in minuets(1-100): ");
        Scanner sc = new Scanner(System.in);
        boolean result;
        do {
            String str = sc.next();

            try {
                cacheCycle = Integer.valueOf(str);

                if (cacheCycle <= 0 || cacheCycle > 100) {
                    CacheLogger.logInfo("Time is out of range.");
                    result = true;

                } else {
                    result = false;
                }

            } catch (NumberFormatException e) {
                CacheLogger.logInfo("Incorrect number");
                result = true;
            }

        } while (result);

        sc.close();
    }

    private static void help(final String str) {
        CacheLogger.logDebug("Program started with command 'help' to output help message.");
        if (str == null) {
            CacheLogger.logError("IllegalArgumentException: Incorrect argument message");
            throw new IllegalArgumentException("Incorrect argument message");
        }

        if (str.equalsIgnoreCase("-h")) {
            StringBuilder output = new StringBuilder();
            output.append("Help commands to interact with SPARK methods:").append(System.lineSeparator());
            output.append(">>>POST<<< request:").append(System.lineSeparator());
            output.append("http://localhost:4567/create-cache/{cache-name} - POST inner cache with name {cache-name}").append(System.lineSeparator()).append(System.lineSeparator());

            output.append(">>>GET<<< request:").append(System.lineSeparator());
            output.append("http://localhost:4567/get-value/{cache-name}/{cache-key} - GET key value (type Object) from inner cache which stored in outer main cache").append(System.lineSeparator());
            output.append("{cache-name} - cache name").append(System.lineSeparator());
            output.append("{cache-key} - inner key of cache").append(System.lineSeparator()).append(System.lineSeparator());

            output.append(">>>PUT<<< request:").append(System.lineSeparator());
            output.append("http://localhost:4567/put-value/{cache-name}/{cache-key}/{cache-value} - PUT inside inner cache new key with his value (type Object)").append(System.lineSeparator());
            output.append("{cache-name} - cache name").append(System.lineSeparator());
            output.append("{cache-key} - inner key of cache").append(System.lineSeparator());
            output.append("{cache-value} - value of inner key (type Object)").append(System.lineSeparator()).append(System.lineSeparator());

            output.append(">>>DELETE<<< requests:").append(System.lineSeparator());
            output.append("http://localhost:4567/delete-cache/{cache-name} - DELETE inner cache with this name if he exists").append(System.lineSeparator()).append(System.lineSeparator());
            output.append("http://localhost:4567/clear-all - DELETE all inner caches and recreate main cache").append(System.lineSeparator());

            CacheLogger.logInfo(output.toString());
        }
    }
}
