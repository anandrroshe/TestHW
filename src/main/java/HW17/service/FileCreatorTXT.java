package HW17.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileCreatorTXT {
    private static File dirConverted;

    private static BufferedWriter writer;

    private static File fileResult;

    public void createDirFile (String path) throws IOException {
        dirConverted = new File(path,"converted");
        if (!dirConverted.exists())dirConverted.mkdir();
    }

    public File createFile(String fileName){
        File file = new File(dirConverted, fileName);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return file;
    }

    public String readFileToString (String path){
        StringBuilder stringBuilder = new StringBuilder();
        try(Stream<String> stream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
            stream.forEach(s -> stringBuilder.append(s).append("\n"));

        }catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    public void createTXTResult(){
        String result ="result.txt";
        fileResult = new File(dirConverted, result);
        if (!fileResult.exists()){
            try {
                fileResult.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeFile (StringBuilder stringBuilder){
        try {
            createTXTResult();
            writer = new BufferedWriter(new FileWriter(fileResult));
            writer.write(stringBuilder.toString());
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
