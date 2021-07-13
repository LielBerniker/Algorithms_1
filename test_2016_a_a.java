public class test_2016_a_a {
    class Q1 {
        int [] floors;
        int ball;
        int breaks;
        int eql;
        public Q1(int[] x, int a) {
           this.floors = x;
           this.ball = a;
           this.breaks = 0;
           this.eql = 0;
        }
        public int numberOfBreaks()
        {
            return this.breaks;
        }
        public int numberOfChecking()
        {
            return this.eql;
        }
        public int floorIndex()
        {
            int step = 1, current_f, final_floor=-1 ;
            while ((step*(step+1)) <this.floors.length)
            {step++;}
            current_f = step;
            while (numberOfBreaks()<2)
            {
                this.eql++;
                if(this.ball<floors[current_f])
                { this.breaks++;
                    current_f = current_f-step+1;
                    while (breaks<=1)
                    {
                        this.eql++;
                        if(this.ball<floors[current_f])
                        {
                            this.breaks++;
                            final_floor = current_f;
                        }
                        else
                            current_f++;
                    }
                }
                else
                {
                    if(current_f == floors.length-1&&numberOfBreaks()==0)
                        return -1;
                    step--;
                    current_f = current_f + step;
                    if(current_f>=floors.length)
                        current_f = floors.length-1;
                }
            }
            return final_floor;
        }
    }
   static class Q2
    {
        public static int lis_down(int[] arr)
        {
            int [] temp = new int[arr.length];
            int count = 1,index;
            temp[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                index = binary_search_down(temp,arr[i],count);
                temp[index] = arr[i];
                if(count == index)
                    count++;
            }
            return count;
        }
        public static int binary_search_down(int [] temp, int num, int size)
        {
            if(num>temp[0])
                return 0;
            if(num<temp[size-1])
                return size;
            int i = 0, j= size-1;
            while (i<=j)
            {
                if(i==j)
                    return i;
                int mid =(int)(i+j)/2;
                if(num == temp[mid])
                    return mid;
                if(num<temp[mid])
                    j=mid;
                else
                    i=mid+1;
            }
            return -1;
        }
        public static int lis_up(int[] arr)
        {
            int [] temp = new int[arr.length];
            int count = 1,index;
            temp[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                index = binary_search_up(temp,arr[i],count);
                temp[index] = arr[i];
                if(count == index)
                    count++;
            }
            return count;
        }
        public static int binary_search_up(int [] temp, int num, int size)
        {
            if(num<temp[0])
                return 0;
            if(num>temp[size-1])
                return size;
            int i = 0, j= size-1;
            while (i<=j)
            {
                if(i==j)
                    return i;
                int mid =(int)(i+j)/2;
                if(num == temp[mid])
                    return mid;
                if(num<temp[mid])
                    j=mid;
                else
                    i=mid+1;
            }
            return -1;
        }
    }
}
