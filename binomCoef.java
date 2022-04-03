//9
class binomCoeff {

    static int binomCoeff(int n, int k)
    {
        if (k > n)
            return 0;
        if (k == 0 || k == n)
            return 1;

        return binomCoeff(n - 1, k - 1)
                + binomCoeff(n - 1, k);
    }


    public static void main(String[] args)
    {
        int n = 7, k = 3;
        System.out.printf(" %d ", n, k,
                binomCoeff(n, k));
    }
}