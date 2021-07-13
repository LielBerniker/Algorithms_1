public class x_power_n {
    public static int x_p_n(int x, int n)
    {
        int result = 1;
        while(n>0) {
            if (n % 2 == 1) {
                result = result * x;
            }
            x = x * x;
            n = n / 2;
        }
        return result;
    }

}
