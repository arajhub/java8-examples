import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierConsumer {

    public static void main(String[] args) {

        List<String> sample = Arrays.asList("aa","bb","cc","dd");

        Consumer<String> consumer = toBeConsumed -> {
            System.out.println("In Consumer =>" + toBeConsumed);
        };

        Supplier<String> supplier = () -> {
            return "Supplied 1";
        };

        Function<String,String> func = toBetransformed -> {
          return "XX"+toBetransformed+"XX";
        };

        sample.stream().forEach(consumer);
        sample.stream().map(func).forEach(consumer);
        Stream.generate(supplier).forEach(consumer);




    }



}
