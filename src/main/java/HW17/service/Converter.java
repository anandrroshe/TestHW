package HW17.service;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Converter {

    private static StringBuilder stringBuilder = new StringBuilder();
    public static void convertion(String path) throws IOException {
        FileCreatorTXT fileCreator = new FileCreatorTXT();
        Json2Yaml json_to_yaml = new Json2Yaml();
        Yaml2Json yaml_to_json = new Yaml2Json();

        File file = new File(path);
        fileCreator.createDirFile(path);

        Arrays.stream(file.listFiles())
                .filter(File::isFile)
                .filter(file1 -> file1.getName().contains(".json")||file1.getName().contains(".yaml"))
                .map(File::getPath)
                .forEach(f -> {
                            String fileName = new File(f).getName().split("[.]", 0)[0];
                            try {
                                if (f.contains(".json")) {
                                    json_to_yaml.convertFile(f, fileName, stringBuilder);
                                } else if (f.contains(".yaml")) {
                                    yaml_to_json.convertFile(f, fileName, stringBuilder);


                                } else {
                                    System.err.println("Error.Wrong format.");
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    );
        fileCreator.writeFile(stringBuilder);

    }




}
