//10
class gcd  {
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        if (a == b)
            return a;

        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }

    public static void main(String[] args)
    {
        int a = 32, b = 48;
        System.out.println( gcd(a, b));
    }
}