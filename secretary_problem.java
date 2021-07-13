public class secretary_problem {
    public static double short_time_wait(int [] times)
    {
        sort_arr(times);
        int avg = 0;
        for (int i = 0; i <times.length ; i++) {
            avg = avg + avg + times[i];
        }
        return avg/times.length;
    }
    public static void sort_arr(int[] a)
    {
        int temp;
        for (int i = 0; i <a.length-1 ; i++) {
            for (int j = i; j <a.length-1 ; j++) {
                if(a[j]>a[j+1])
                {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
