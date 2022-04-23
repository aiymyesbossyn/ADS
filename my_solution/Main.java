package my_solution;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
//        MyArrayList<BigDecimal> arr = new MyArrayList<BigDecimal>();
        MyLinkedList<BigDecimal> arr = new MyLinkedList<BigDecimal>();

        arr.add(BigDecimal.ONE);
        arr.add(BigDecimal.ONE);
        arr.add(BigDecimal.ONE);
        System.out.println(arr);

        arr.add(BigDecimal.TEN, 1);
        System.out.println(arr);

        arr.remove(BigDecimal.TEN);
        System.out.println(arr);

        System.out.println(arr.contains(BigDecimal.ONE));
        System.out.println(arr.contains(BigDecimal.TEN));

        arr.remove(0);
        System.out.println(arr);

        arr.clear();
        System.out.println(arr);

        arr.add(BigDecimal.TEN);
        arr.add(BigDecimal.ONE);
        arr.add(BigDecimal.ONE);
        arr.add(BigDecimal.TEN);
        arr.add(BigDecimal.ONE);
        System.out.println(arr.indexOf(BigDecimal.TEN));
        System.out.println(arr.lastIndexOf(BigDecimal.TEN));
        System.out.println(arr.get(3));

        arr.sort();
        System.out.println(arr);
    }
}
