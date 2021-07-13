import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test_2015_a_a {
    class node
    {
        double x,y,best_price;
        int path_count;

    }
    public static int airplane_problem_best_way(node [][] way,int teta)
    {
        int path_num , i = way.length-1,j = way[0].length, min ,count ,num_of_min =1 ;
        List<String> all_path = new ArrayList<>();
       path_num =  reset_way(way);
       if(path_num>teta)
           return -1;
       add_opt_path(way,i,j,"",all_path);
       min = path_num;
        for (String path: all_path) {
            count = 0;
            for (int k = 1; k <path.length() ; k++) {
                 if(path.charAt(i) != path.charAt(i-1))
                     count++;
            }
            if(count<min)
            { min = count; num_of_min = 1;}
            else if (count == min)
                num_of_min++;
        }
      return num_of_min;
    }
    public static void add_opt_path(node [][] way, int i, int j,String path,List<String> all_path)
    {
        if(i==0)
        {
            while (j!=0)
            {path = "0" +path; j--;}
            all_path.add(path);
        }
        else if(j==0)
        {
            while (i!=0)
            {path = "1" +path; i--;}
            all_path.add(path);
        }
        else
        {
            if(way[i-1][j].best_price+way[i-1][j].y < way[i][j-1].best_price+way[i][j-1].x) {
              path = "1" + path;
              i--;
              add_opt_path(way,i,j,path,all_path);
            }
            else if(way[i-1][j].best_price+way[i-1][j].y > way[i][j-1].best_price+way[i][j-1].x)
            {
                path = "0" + path;
                j--;
                add_opt_path(way,i,j,path,all_path);
            }
            else
            {
                add_opt_path(way,i-1,j,"1" + path,all_path);
                add_opt_path(way,i,j-1,"0" + path,all_path);
            }
        }
    }
    public static int reset_way(node[][]way)
    {
        way[0][0].best_price = 0;
        way[0][0].path_count = 1;
        int row = way.length, col = way[0].length;
        for (int i = 1; i <row ; i++) {
            way[i][0].best_price = way[i-1][0].best_price + way[i-1][0].y;
            way[i][0].path_count = way[i-1][0].path_count;
        }
        for (int i = 1; i <col ; i++) {
            way[0][i].best_price = way[0][i-1].best_price + way[0][i-1].x;
            way[0][i].path_count = way[0][i-1].path_count;
        }
        for (int i = 1; i <row ; i++) {
            for (int j = 1; j <col ; j++) {
                if(way[i-1][j].best_price+way[i-1][j].y < way[i][j-1].best_price+way[i][j-1].x) {
                    way[i][j].best_price = way[i-1][j].best_price+way[i-1][j].y;
                    way[i][j].path_count = way[i-1][j].path_count;
                }
                else if(way[i-1][j].best_price+way[i-1][j].y > way[i][j-1].best_price+way[i][j-1].x)
                {
                    way[i][j].best_price = way[i][j-1].best_price+way[i][j-1].x;
                    way[i][j].path_count = way[i][j-1].path_count;
                }
                else
                {
                    way[i][j].best_price = way[i][j-1].best_price+way[i][j-1].x;
                    way[i][j].path_count = way[i][j-1].path_count + way[i-1][j].path_count;
                }
            }
        }
        return way[row-1][col-1].path_count;
    }
    public static int glass_ball_3(int[] a, int ball)
    {
        int step = 1,floor,floor_f=-1;
        boolean flag= true;
        while((step*(step+1)/2 <a.length))
        {step++;}
        floor = step;

        while (flag)
        {
            if(ball<a[floor])
            {
                int higher = floor;
                floor = floor-step;
                int size = step;
                step = 1;
                while((step*(step+1)/2 <size))
                {step++;}
                floor = floor +step;
                while (flag)
                {
                    if(ball<a[floor])
                    {
                        floor = floor-step+1;
                        while (flag)
                        {
                            if(a[floor]>ball)
                            { floor_f = floor; flag = false;}
                            else
                                floor++;
                        }
                    }
                    else
                    {
                       step--;
                       floor = floor + step;
                    }

                    if(floor>higher)
                        floor = higher-1;
                }
            }
            else
            {
                step--;
                floor = floor + step;
            }
            if(floor>a.length)
                floor = a.length-1;
        }
        return floor_f;
    }
    public static int size_of_up_down(int[]a)
    {
        int [] arr = new int[a.length];
        int [] up = new int[a.length];
        int [] down = new int[a.length];
        int count = 1, index;
        up[0] = 1;
        arr[0] = a[0];
        for (int i = 1; i <arr.length ; i++) {
            index = binary_in_arr_up(arr,a[i],count);
            if(count == index)
                count++;
            arr[index] = a[i];
            up[i] = index +1;
        }
        int [] arr2 = new int[a.length];
        int i = 0, j = a.length-1;
        while (i<j)
        {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++; j--;
        }
         count = 1;
        arr2[0] = a[0];
        for (int k = 1; k <arr.length ; k++) {
            index = binary_in_arr_up(arr2,a[k],count);
            if(count == index)
                count++;
            arr2[index] = a[k];
            down[i] = index +1;
        }
         i = 0; j = down.length-1;
        while (i<j)
        {
            int temp = down[i];
            down[i] = down[j];
            down[j] = temp;
            i++; j--;
        }
        int max=0;
        for (int k = 0; k <up.length ; k++) {
            up[k] = up[k] + down[k];
            if(up[k]-1>max)
                max = up[k] -1;
        }
        return max;
    }
    public static int length_of_arr_up(int[]a)
    {
        int[] arr = new int[a.length];
        int count = 1, index;
        arr[0] = a[0];
        for (int i = 1; i <arr.length ; i++) {
            index = binary_in_arr_up(arr,a[i],count);
            if(count == index)
                count++;
            arr[index] = a[i];
        }
        return count;
    }
    public static int binary_in_arr_up(int[] arr, int num,int size)
    {
       if(num<arr[0])
           return 0;
       if(num>arr[size-1])
           return size;
       int i = 0,j = size-1;
       while (i<=j)
       {
           if(i==j)
               return i;
           int mid = (int)(i+j)/2;
           if(arr[mid] == num)
               return mid;
           else if(arr[mid]>num)
               j=mid;
           else
               i=mid+1;
       }
       return -1;
    }
 public static void main(String [] args)
 {
     int [] a = {3,6,7,9,12,34,56,778,1000,2424,42222};
     int ball = 40;
     System.out.println(glass_ball_3(a,ball));
 }
}
