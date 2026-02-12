package generics.wildcards;
import java.util.*;

public class WildCardSum {
    public static double sumList(List<? extends Number> list) {

        double sum = 0.0;

        for (Number num : list) {
            sum += num.doubleValue();
        }

        return sum;
    }

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(10, 20, 30);
        List<Double> doubleList = Arrays.asList(2.5, 3.5, 4.0);

        System.out.println("Integer sum: " + sumList(intList));
        System.out.println("Double sum: " + sumList(doubleList));
    }
}
