package lambdaFunction_and_interface;

import java.util.Comparator;

public class LambdaFunction {
    public static void main(String[] args) {

        Comparator<Integer> integerComparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
    }
}
