import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArMeanTest {

    @Test

    public void testArMean (){
        List <Integer> test =  Arrays.asList(2,4,6,8);
        Double average = test.stream().mapToInt(value -> value).average().orElse(0.0);
        Assertions.assertEquals(5.0, average );
    }


    @Test
    public void testToUpper(){
        List <String> temp = Arrays.asList("is", "it", "to", "upper", "case");
        List<String> tempUp = Arrays.asList("IS", "IT","TO", "UPPER", "CASE");
        List<String> toUpTemp = temp.stream().map(String::toUpperCase).collect(Collectors.toList());
        Assertions.assertEquals(tempUp, toUpTemp);
    }

    @Test
    public void testFilter(){
        List <String> temp = Arrays.asList("is", "it", "to", "upper", "case","IS", "IT","TO", "UPPER", "CASE");
        List<String> tempFiltered = temp.stream().filter(e -> e.equals(e.toLowerCase()) && e.length() == 4).collect(Collectors.toList());
        List<String> tempEqual = Arrays.asList("case");
        Assertions.assertEquals(tempFiltered, tempEqual);

    }
}
