public class max_half {
    public int max_half_of_arr(int [] a)
    {
         int max = a[0];
        for (int i = 1; i < a.length && i<64 ; i++) {
            if(a[i]>max)
                max = a[i];
        }
        return max;
    }
}
