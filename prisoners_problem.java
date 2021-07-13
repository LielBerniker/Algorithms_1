public class prisoners_problem {
    public static void all_prisoners(int n)
    {
        int counter = 0, count = 0, rand;
        boolean lamp = true;
        boolean []prisoners = new boolean[n] ;
        for (int i = 0; i <n ; i++) {
            prisoners[i] = false;
        }
        while(count<n)
        {
            rand = (int)(Math.random()*n);
            if(rand == counter)
            {
                if(prisoners[counter] == false)
                    prisoners[counter] = true;
                if(!lamp)
                {
                    lamp = true;
                    count++;
                }
            }
            else
            {
                if (prisoners[rand] == false && lamp == true) {
                    prisoners[rand] = true;
                    lamp = false;
                }
            }
        }

    }
}
