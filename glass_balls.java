public class glass_balls {
    public static int blass_ball_sqr_n(int [] a, int ball)
    {
        int step = (int)(Math.sqrt(a.length));
        int count = step;
        boolean ball_break = false;
        while(!ball_break)
        {
            if(count>=a.length)
                count = a.length-1;
            if(a[count] > ball)
            {
                count = count-step+1;
                while (count<a.length)
                {
                    if(ball<a[count])
                    {return count;
                    }
                    count++;
                }
            }
            else
            {
                if(count == a.length)
                {
                    return Integer.MAX_VALUE;
                }
                count = count+step;
            }
        }
        return Integer.MAX_VALUE;
    }
    public static int blass_ball_3_num(int [] a, int ball)
    {
        int step = 1;
        while ((step*(step+1))/2<=a.length)
        {
            step++;
        }
        int count = step;
        boolean ball_break = false;
        while(!ball_break)
        {
            if(count>=a.length)
                count = a.length-1;
            if(a[count] > ball)
            {
                int high = count;
                count = count-step+1;
                while (count<high)
                {
                    if(ball<a[count])
                    {return count;
                    }
                    count++;
                }
            }
            else
            {
                if(count == a.length-1)
                {
                    return a.length;
                }
                step--;
                count = count+step;
            }
        }
        return a.length;
    }
}
