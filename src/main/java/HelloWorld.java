import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author hekai
 * @create 2018-03-22 上午11:26
 */

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("hello java8!");


        List<Integer> collect = IntStream.rangeClosed(2, 100).boxed().collect(Collectors.toList());
        System.out.println(collect);
    }

}
