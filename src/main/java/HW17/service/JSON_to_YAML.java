package HW17.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class JSON_to_YAML {
    private static TXT_FileCreator fileCreator = new TXT_FileCreator();

    public void convertFile (String path, String fileName, StringBuilder stringBuilder) throws IOException {
        Instant start = Instant.now();
        YAMLMapper yamlMapper = new YAMLMapper();
        String json = fileCreator.readFileToString(path);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        File file = fileCreator.createFile(fileName+".yaml");
        File jsonFile = new File(path);
        yamlMapper.writeValue(file, jsonNode);
        Instant finish = Instant.now();
        double runningTime = Duration.between(start, finish).toMillis();

        stringBuilder.append("Converting JSON to YAML:").append(fileName).append(".json ").append("-> ")
                .append(fileName).append(".yaml").append("Running time: "+ runningTime)
                .append(jsonFile.length()).append(" input size.").append(file.length()).append(" output file  size.");


    }

}
