import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArMean {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6,8,10,4);
        System.out.println("List contains: "+list.toString());
        Double average = list.stream().mapToInt(value -> value).average().orElse(0.0);
        System.out.println("Arithmetic mean is "+average);

        List<String> listStr = Arrays.asList( "one", "two", "three");
        List<String> listStrUp = listStr.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Initial list: "+ listStr.toString() + "\4 List witn upper letters: " + listStrUp.toString());

        Collection<String> direction = Arrays.asList("left", "Left", "right", "DOWN", "down", "up");
        Stream<String> filter =direction.stream().filter(e ->e.equals(e.toLowerCase()) && e.length() == 4);
        System.out.println("Initial list: " + direction.toString());
        System.out.print("Elements left after filter: ");
        System.out.print(Arrays.toString(filter.toArray()));

    }



}
