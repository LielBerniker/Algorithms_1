import java.lang.reflect.Array;

public class test_2018_summer_a {
    public static int number_game_dyna(int [] a)
    {
        int player1 =0,player2 = 0,i=0,j=a.length-1;
        boolean go_on = true;
        int [][]mat = new int[a.length][a.length];
        update_mat_num_game(mat,a);
        while(i<=j)
        {
            if(i==j)
            { player1 = player1 + a[i]; i++;}
            else
            {
                if(a[i]- mat[i+1][j] > a[j] - mat[i][j-1])
                {player1 = player1 +a[i]; i++;}
                else
                {player1 = player1 + a[j]; j--;}
            }
            if(i<=j)
            {
                if(i==j)
                {player2 = player2 + a[i]; i++;}
                else
                {
                    if(a[i]- mat[i+1][j] > a[j] - mat[i][j-1])
                    {player2 = player2 +a[i]; i++;}
                    else
                    {player2 = player2 + a[j]; j--;}
                }
            }

        }
       return Math.abs(player1-player2);
    }
    public static void update_mat_num_game(int [][] mat,int []a)
    {
        for (int i = 0; i <a.length ; i++) {
            mat[i][i] = a[i];
        }
        for (int i = 0; i <mat.length ; i++) {
            for (int j = i+1; j <mat[0].length ; j++) {
                mat[i][j]= Math.max(a[i]-mat[i+1][j],a[j]-mat[i][j-1]);
            }
        }
    }
    public static int binary_in_mat(int [][] mat, int num , int size)
    {
        if(num<mat[0][0])
            return 0;
        if(num>mat[size-1][size-1])
            return size;
        int i = 0, j = size=-1;
        while (i<=j)
        {
            if (i==j)
                return i;
            int mid = (int)(i+j)/2;
            if(num== mat[mid][mid])
                return mid;
            else if(num<mat[mid][mid])
                j=mid;
            else
                i= mid+1;
        }
        return -1;
    }
    public static int number_game_aft(int[] a)
    {
        int player1 =0, player2 =0 , i = 0, j = a.length-1, index =-1;
        while(i<=j)
        {
            if (i==j)
            {  player1 = player1 + a[i];
            break;}
            else
            {
                index = find_index_adfetivi(a,i,j);
                if(index == i)
                {
                    player1 = player1 + a[i]; i++;
                }
                else
                { player1 = player1 + a[j]; j--;}
            }
            if(i>j)
                break;
            if(i==j)
            { player2 = player2 + a[i];
            break;}
            else
            {
                index = find_index_adfetivi(a,i,j);
                if(index == i)
                {
                    player2 = player2 + a[i]; i++;
                }
                else
                { player2 = player2 + a[j]; j--;}
            }
        }
    return Math.abs(player1-player2);
    }
    public static int find_index_adfetivi(int[]a,int start, int end)
    {
        if((start%2==0 & end%2==0) || (start%2==1 && end%2==1)) {
            if(a[start]>a[end])
                return start;
            else
                return end;
        }
        int sum1=0, sum2=0,index = -1,sum_s =0, sum_e=0;
        for (int i = start; i <=end ; i++) {
            if(i%2==0)
                sum1 =sum1 +  a[i];
            else
                sum2 = sum2 + a[i];
        }
        if(start%2==0)
        {  sum_s = sum1; sum_e = sum2;}
        else {
            sum_e = sum1; sum_s = sum2;}

            if (sum_e==sum_s) {
                {if(a[start]>a[end])
                   return start;
               else
                   return end;}
            }
            else if(sum_s>sum_e)
                index = start;
            else
                index = end;
        return index;
    }
    public static int number_of_mat(int[][]mat, int k)
    {
        int row = mat.length , col = mat[0].length,counter = 0;
        int [][] temp_m = new int[row][col];
        for (int i = 0; i < row; i++) {
            temp_m[i][0] =mat[i][0];
        }
        for (int i = 1; i <col ; i++) {
            temp_m[0][i] = mat[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j <col ; j++) {
                if(mat[i][j] == 0)
                temp_m[i][j] = 0;
                else
                {
                    temp_m[i][j] = Math.min(Math.min(mat[i-1][j-1],mat[i-1][j]),Math.min(mat[i-1][j-1],mat[i][j-1])) +1;
                }
                if(temp_m[i][j] == k)
                    counter++;
            }
        }
        return counter;
    }
    public static int prisoner_problem_unknown(boolean [] a)
    {
        int checker = 0,counter = 0, prisoner = 0;
        boolean go_on = true;
        int light = (int)(Math.random()*2);
        while(go_on)
        {
            prisoner = (int)(Math.random()*a.length);
            if(prisoner == checker)
            {
                if(a[checker] == false)
                {
                    a[checker] = true; counter++;
                if (light == 0)
                   light = 1;
                }
                else {
                    if (light == 0) {
                        light = 1;
                        counter++;
                    }
                }
            }
            else
            {
                if(a[checker] == false)
                    a[checker] = true;
                if(light == 1)
                    light = 0;
            }
            if(counter == a.length)
                go_on = false;
        }
        int counter_check = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] == true)
                counter_check++;
        }
        if(counter == counter_check)
            return counter;
        else
            return -1;
    }
    public static int prisoner_problem_light_on(boolean [] a)
    {
        int checker = 0,counter = 0, prisoner = 0;
        boolean light = true, go_on = true;
        while(go_on)
        {
           prisoner = (int)(Math.random()*a.length);
           if(prisoner == checker)
           {
               if(a[checker] == false)
               {a[checker] = true; counter++;}
               if(!light)
               {
                   light = true; counter++;
               }
           }
           else
           {
               if(a[checker] == false)
                   a[checker] = true;
               if(light)
                   light = false;
           }
           if(counter == a.length)
               go_on = false;
        }
        int counter_check = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] == true)
                counter_check++;
        }
        if(counter == counter_check)
            return counter;
        else
            return -1;
    }
    public static int glass_balls(int[] a, int ball)
    {
       int step = 1,index;
       while((step*(step+1)/2) <a.length)
        {
            step++;
        }
       index = step;
       boolean flag = false;
       while (!flag)
       {
           if(a[index]>ball)
           {
               index = index - step;
               while(!flag)
               {
                   if(a[index]>ball)
                   {
                      flag = true;
                   }
                   else
                   {
                       index++;
                   }
               }
           }
           else
           {
               if(index == a.length-1)
                   return a.length;
               step--;
               index = index +step;
               if(index>=a.length)
                   index = a.length-1;
           }
       }
       return index;

    }
    public static int longest_abs_in_arr(int[] a, int k)
    {
        int max_size = 0,temp_size,temp_num;
        for (int i = 0; i < a.length; i++) {
            temp_num = a[i];
            temp_size =1;
            for (int j = 0; j <a.length ; j++) {
                if(j!=i)
                {
                    if(Math.abs(temp_num-a[j]) <= k && Math.abs(a[j] - temp_num) <= k)
                        temp_size++;
                }
            }
            if(temp_size>max_size)
                max_size = temp_size;
        }
        return max_size;
    }
    public static int longest_arr_up(int [] a)
    {
        int [][] arr = new int[a.length][a.length];
        return size_of_longest(arr,a);

    }
    public static int size_of_longest(int[][] arr, int [] a)
    {
        arr[0][0] = a[0];
        int count = 1,index;
        for (int i = 1; i < a.length; i++) {
            index = index_for_val(a[i],arr,count);
            if (count == index)
                count++;
            if(index>0) {
                for (int j = 0; j < index ;j++) {
                   arr[index][j]= arr[index-1][j];
                }
            }
        }
        return count;
    }
    public static int index_for_val(int num, int[][]arr,int size)
    {
        if(num<arr[0][0])
            return 0;
        if (num>arr[size-1][size-1])
            return size;
        int i=0,j=size-1;
        while (i<=j)
        {
            if(i==j)
                return i;
            int mid = (int)((i+j)/2);
            if(arr[mid][mid]<num)
                i = mid;
            else if (arr[mid][mid]>num)
                j = mid;
            else
                return mid;

        }
        return -1;
    }

}
