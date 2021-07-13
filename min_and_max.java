public class min_and_max {
    public void min_and_max(int [] arr)
    {
        int min, max;
        if (arr.length == 0)
        {min = 0;
        max = 0;}
        if((arr.length == 1))
        {
            min = arr[0];
           max = arr[0];
        }
        if (arr[0] < arr[1])
        {
            min = arr[0];
            max = arr[1];
        }
        else
        {
            max = arr[0];
            min = arr[1];
        }
        for (int i = 2; i < arr.length-1; i= i+2) {
            if(arr[i]<arr[i+1])
            {
                if(arr[i+1]>max)
                    max = arr[i+1];
                if (arr[i]<min)
                    min = arr[i];
            }
            else
            {
                if(arr[i]>max)
                    max = arr[i];
                if (arr[i+1]<min)
                    min = arr[i+1];
            }
        }
        if(arr.length%2 !=0)
        {
            if (arr[arr.length-1] > max)
                max = arr[arr.length-1];
            else
            {
                if (arr[arr.length-1] < min)
                    min = arr[arr.length-1] ;
            }
        }

    }
}
