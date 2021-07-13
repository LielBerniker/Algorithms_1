public class compayler_problem {
    public class com
    {
        int len,freq;
        String name;

        public com(int len, int freq,String name)
        {
            this.len = len;
            this.freq = freq;
            this.name = name;
        }
    }
    public static double shot_time_com(com [] prog)
    {
        int total_len = 0;
        double total_time = 0;
        merge_sort(prog);
        for (int i = 0; i <prog.length ; i++) {
            total_len = total_len + prog[i].len;
            total_time = total_time + (total_len)*prog[i].freq;
        }
       return total_time/prog.length;
    }
    public static void merge_sort(com [] programs)
    {
      merge_sort_full(0, programs.length, programs);
    }
    public static void merge_sort_full(int low, int high, com [] programs)
    {
        if(low<high)
        {
            int i,j,mid,k;
            mid =(int)(low + high)/2;
            merge_sort_full(low,mid,programs);
            merge_sort_full(mid+1,high,programs);
            i = low;
            j = mid;
            k=0;
            com [] temp = new com[programs.length];
            while(i<mid && j<high)
            {
                if (programs[i].len/programs[i].freq >programs[j].len/programs[j].freq )
                {temp[k] = programs[j];
                j++;}
                else {
                    temp[k] = programs[i];
                    i++;
                }
                k++;
            }
            for (int l = i; l < mid; l++) {
                temp[k] = programs[l];
                k++;
            }
            for (int w = j; w < high; w++) {
                temp[k] = programs[w];
                k++;
            }
            k = 0;
            for (int l = low; l < high; l++) {
                programs[l] = temp[k];
            }
        }
        return;
    }
}
