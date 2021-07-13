public class glass_balls_p_go_down {
    public static int glass_ball_3_numbers(int ball, int[] a)
    {
        int step = 1, n = a.length,floor;
        while (step*(step+1)/2 < n)
        {
            step++;
        }
        floor = step;
        boolean is_break = false;
        while (!is_break)
        {
            if(ball<a[floor])
            {
                floor = floor -step+1;
                while (!is_break)
                {
                    if(a[floor]>ball)
                        return floor;
                    floor++;
                }
            }
            if(floor == n-1)
                return n;
            step--;
            floor = floor + step ;
            if(floor>=n)
                floor = n-1;
        }
        return n;
    }
}
