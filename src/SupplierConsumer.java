import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierConsumer {

    public static void main(String[] args) {

        List<String> sample = Arrays.asList("aa","bb","cc","ddd");

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
        //Stream.generate(supplier).forEach(consumer);

        Predicate<String> maxLengthPredicate = (inputStr) -> {
           return (inputStr.length() < 10);
        };
        Predicate<String> minLengthPredicate = (inputStr) -> {
            return (inputStr.length() > 2);
        };
        sample.stream().filter(maxLengthPredicate.and(minLengthPredicate)).forEach(consumer);

        sample.stream().filter(maxLengthPredicate.or(minLengthPredicate)).forEach(consumer);

        sample.stream().filter(x -> x.length() < 3).map(func).forEach(consumer);

    }



}
