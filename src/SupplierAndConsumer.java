import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierAndConsumer {

    public static void main(String[] args) {
        List<String> aa = new ArrayList<String>();
        aa.add("aaditya");
        aa.add("Raj");

        Supplier<String> supplier = () -> {
            return aa.get(1);
        };

        System.out.println(supplier.get());

        Consumer<String> consumer1 = (x) -> {
            System.out.println("Consumer 1 "+x);
        };

        Consumer<String> consumer2 = (x) -> {
            System.out.println("Consumer 2 "+x);
        };

        consumer1.accept("I am first !!!");

        consumer1.andThen(consumer2).andThen(consumer1);

        //aa.forEach(() -> aa.get(1));


       /* Supplier<Date> dateSupplier= SupplierFunctionExample::getSystemDate;
        Date systemDate = dateSupplier.get();
        System.out.println("systemDate->" + systemDate);
*/


    }

}
