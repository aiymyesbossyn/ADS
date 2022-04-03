//1
public class laboratory1 {
    private laboratory1() {}

    public static int findMin (int [] a){
        return findMin(a, 1, a[0]);
    }
    private static int findMin(int[] a, int i, int min) {
        if (i>= a.length) return min;

        if (min> a[i]) min = a[i];

        return findMin(a, i+1, min);
    }
}
