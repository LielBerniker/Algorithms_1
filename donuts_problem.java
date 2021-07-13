public class donuts_problem {
    public static int time_to_make(int capacity, int num_donuts )
    {
        int time = 2;
        if(capacity>num_donuts)
            return time;
        if(num_donuts%capacity == 0)
            return (time*num_donuts)/capacity;
        return time*num_donuts/capacity +1;
    }
}
