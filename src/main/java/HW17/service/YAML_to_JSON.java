package HW17.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class YAML_to_JSON {
    private static TXT_FileCreator fileCreator = new TXT_FileCreator();
    public void convertFile (String path, String fileName, StringBuilder stringBuilder) throws IOException {
        Instant start = Instant.now();
        ObjectMapper objectMapper = new ObjectMapper();
        Yaml yaml = new Yaml();
        String yamlStr = fileCreator.readFileToString(path);
        Object objectYAML = yaml.load(yamlStr);
        File fileYaml = new File(path);
        File file = fileCreator.createFile(fileName+".json");
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, objectYAML);
        Instant finish = Instant.now();
        double runningTime = Duration.between(start, finish).toMillis();
        stringBuilder.append("Converting YAML to JSON: ").append(fileName).append(".yaml ").append("-> ")
                .append(fileName).append(".json").append("Running time: "+ runningTime)
                .append(fileYaml.length()).append(" input size.").append(file.length()).append(" output file  size.");
    }
}
