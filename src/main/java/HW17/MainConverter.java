package HW17;

import HW17.service.Converter;

import java.io.IOException;
import java.nio.file.FileSystems;

public class MainConverter {
    public static void main(String[] args) {
        String path;
        if (args.length == 0){
            path = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        }else {
            path = args[0];
        }
        try {
            Converter.convertion(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
