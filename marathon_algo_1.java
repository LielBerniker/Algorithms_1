import java.lang.reflect.Array;
import java.util.Arrays;

public class marathon_algo_1 {
    class node_p
    {
        double x , y ,l_price;
    }
    public static boolean both_point_in_path(int p1_i, int p1_j, int p2_i, int p2_j,node_p[][] mat)
    {
        int row = mat.length, col = mat[0].length;
        int p1i,p1j,p2i,p2j;
        if(p1_i<p2_i && p1_j<p2_j)
        {
            p1i = p1_i; p1j=p1_j; p2i = p2_i; p2j = p2_j;
        }
        else if(p1_i>p2_i && p1_j>p2_j)
        {
            p1i = p2_i; p1j=p2_j; p2i = p1_i; p2j = p1_j;
        }
        else
            return false;
        double path1,path2,path3, min_val = airplane_problem_min_val(mat);
        path1 = mat[p1i][p1j].l_price;
        if(path1>min_val)
            return false;
        path2 = airplane_problem_in_range(mat,p1i,p1j,p2i,p2j);
        if (path1+path2>min_val)
            return false;
        path3 = airplane_problem_in_range(mat,p2i,p2j,row-1,col-1);
        if (path1+path2+path3 == min_val)
            return true;
        else
            return false;


    }
    public static double airplane_problem_in_range(node_p [][] way,int p1i, int p1j, int p2i, int p2j)
    {
        way[p1i][p1j].l_price =0;
        for (int i = p1i+1; i <=p2i; i++) {
            way[i][p1j].l_price = way[i-1][p1j].l_price + way[i-1][p1j].y;
        }
        for (int i = p1j+1; i <= p2j; i++) {
            way[p1i][i].l_price = way[p1i][i-1].l_price + way[p1i][i-1].x;
        }
        for (int i = p1i+1; i <=p2i ; i++) {
            for (int j = p1j; j <=p2j ; j++) {
                if(way[i-1][j].l_price + way[i-1][j].y < way[i][j-1].l_price + way[i][j-1].x)
                    way[i][j].l_price = way[i-1][j].l_price + way[i-1][j].y;
                else
                    way[i][j].l_price = way[i][j-1].l_price + way[i][j-1].x;
            }
        }
        return way[p2i][p2j].l_price;
    }
    public static double airplane_problem_min_path(node_p [][] way)
    {
        int row = way.length, col = way[0].length;
        way[0][0].l_price =0;
        for (int i = 1; i < row; i++) {
            way[i][0].l_price = way[i-1][0].l_price + way[i-1][0].y;
        }
        for (int i = 1; i < col; i++) {
            way[0][i].l_price = way[0][i-1].l_price + way[0][i-1].x;
        }
        for (int i = 1; i <row ; i++) {
            for (int j = 1; j <col ; j++) {
                if(way[i-1][j].l_price + way[i-1][j].y < way[i][j-1].l_price + way[i][j-1].x)
                    way[i][j].l_price = way[i-1][j].l_price + way[i-1][j].y;
                else
                    way[i][j].l_price = way[i][j-1].l_price + way[i][j-1].x;
            }
        }
        return way[row-1][col-1].l_price;
    }
    public static String short_path(node_p[][] mat)
    {
        String path = "";
        int i = mat.length-1, j = mat[0].length-1;
        while(i>0 && j>0)
        {
          if(mat[i-1][j].l_price + mat[i-1][j].y  == mat[i][j].l_price)
          {
              path = "1" + path;
              i--;
          }
          else {
              path = "0" + path;
              j--;
          }
        }
        while (i>0)
        {
            path = "1" + path;
            i--;
        }
        while (i>0)
        {
            path = "0" + path;
            j--;
        }
return path;
    }
    public static double airplane_problem_min_val(node_p [][] way)
    {
        int row = way.length, col = way[0].length;
        way[0][0].l_price =0;
        for (int i = 1; i < row; i++) {
            way[i][0].l_price = way[i-1][0].l_price + way[i-1][0].y;
        }
        for (int i = 1; i < col; i++) {
            way[0][i].l_price = way[0][i-1].l_price + way[0][i-1].x;
        }
        for (int i = 1; i <row ; i++) {
            for (int j = 1; j <col ; j++) {
                   if(way[i-1][j].l_price + way[i-1][j].y < way[i][j-1].l_price + way[i][j-1].x)
                       way[i][j].l_price = way[i-1][j].l_price + way[i-1][j].y;
                   else
                       way[i][j].l_price = way[i][j-1].l_price + way[i][j-1].x;
            }
        }
        return way[row-1][col-1].l_price;
    }
    public static String longest_contain_x_y(String str1,String str2)
    {
        String lcs = lcs_one_str(str1,str2), contain_all="";
        int i=0,j = 0,k=0;
        while (i<str1.length() && j<str2.length() && k<lcs.length())
        {
            if(str1.charAt(i) == lcs.charAt(k) && str2.charAt(j) == lcs.charAt(k))
            {
                contain_all = contain_all + lcs.charAt(k);
                k++; i++; j++;
            }
            else if(str1.charAt(i) == lcs.charAt(k))
            {
                contain_all = contain_all + str2.charAt(j);
                j++;
            }
            else if(str2.charAt(j) == lcs.charAt(k))
            {
                contain_all = contain_all + str1.charAt(i);
                i++;
            }
            else {
                contain_all = contain_all + str2.charAt(j) + str1.charAt(i);
                j++;
                i++;
            }
        }
        if(k==lcs.length())
        {
            for (int l = i; l <str1.length() ; l++) {
                contain_all = contain_all + str1.charAt(l);
            }
            for (int l = j; l <str2.length() ; l++) {
                contain_all = contain_all + str2.charAt(l);
            }
        }
     return contain_all;
    }
    public static String lcs_for_3(String str1,String str2, String str3)
    {
        int row = str1.length(), col = str2.length() , col2 = str3.length();
        int [][][] mat = new int[row+1][col+1][col2+1];
        for (int i = 0; i <= row ; i++) {
            mat[i][0][0] = 0;
        }
        for (int i = 1; i <=col; i++) {
            mat[0][i][0] = 0;
        }
        for (int i = 1; i <=col2; i++) {
            mat[0][0][i] = 0;
        }
        for (int i = 1; i <=row; i++) {
            for (int j = 1; j <=col ; j++) {
                for (int k = 1; k <= col2; k++) {

                    if (str1.charAt(i - 1) == str2.charAt(j - 1) && str1.charAt(i-1) == str3.charAt(k-1))
                        mat[i][j][k] = mat[i - 1][j - 1][k-1] + 1;
                    else
                    {
                        mat[i][j][k] = max_from_3(mat[i-1][j][k],mat[i][j-1][k],mat[i][j][k-1]);
                    }
                }
            }
        }
        int i = row,j = col, k = col2 ;
        String long_str = "";
        while(mat[i][j][k] != 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1) && str1.charAt(i - 1) == str3.charAt(k - 1)) {
                long_str = str1.charAt(i - 1) + long_str;
                i--;
                j--;
                k--;
            } else {
                if (mat[i][j - 1][k] > mat[i - 1][j][k]) {
                    if (mat[i][j - 1][k] > mat[i][j][k - 1])
                        j--;
                    else
                        k--;
                } else {
                    if (mat[i - 1][j - 1][k] > mat[i][j][k - 1])
                        i--;
                    else
                        k--;
                }
            }
        }
        return long_str;
    }
    public static int max_from_3(int num1, int num2, int num3)
    {
         int max = 0;
        if(num1>num2)
        {
            if(num1>num3)
                max = num1;
            else
            {
               max = num3;
            }
        }
        else
        {
            if(num2>num3)
                max = num2;
            else
            {
                max = num3;
            }
        }
        return max;
    }
    public static int lcs_size(String str1,String str2)
    {
        int row = str1.length(), col = str2.length();
        int [][] mat = new int[row+1][col+1];
        for (int i = 0; i <= row ; i++) {
            mat[i][0] = 0;
        }
        for (int i = 1; i <=col; i++) {
            mat[0][i] = 0;
        }
        for (int i = 1; i <=row; i++) {
            for (int j = 1; j <=col ; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    mat[i][j] = mat[i-1][j-1] +1;
                else
                {
                    if(mat[i-1][j]>mat[i][j-1])
                        mat[i][j] = mat[i-1][j];
                    else
                        mat[i][j] = mat[i][j-1];
                }
            }
        }
        return mat[row][col];
    }
    public static String lcs_one_str(String str1,String str2)
    {
        int row = str1.length(), col = str2.length();
        int [][] mat = new int[row+1][col+1];
        for (int i = 0; i <= row ; i++) {
            mat[i][0] = 0;
        }
        for (int i = 1; i <=col; i++) {
            mat[0][i] = 0;
        }
        for (int i = 1; i <=row; i++) {
            for (int j = 1; j <=col ; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    mat[i][j] = mat[i-1][j-1] +1;
                else
                {
                    if(mat[i-1][j]>mat[i][j-1])
                        mat[i][j] = mat[i-1][j];
                    else
                        mat[i][j] = mat[i][j-1];
                }
            }
        }
        int i = row,j = col ;
        String long_str = "";
        while(mat[i][j] != 0)
        {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                long_str = str1.charAt(i-1) + long_str;
                i--;
                j--;
            }
            else
            {
                if(mat[i][j-1]>mat[i-1][j])
                    j--;
                else
                    i--;
            }
        }
        return long_str;
    }
    public static int lis_size(int[] arr)
    {
        int [] lis = new int[arr.length];
        int index=0,size=1;
        lis[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            index = Arrays.binarySearch(lis,0,size,arr[i]);
            if(index <0)
                index = -index -1;
            lis[index] = arr[i];
            if(index==size)
                size++;
            }
        return size;
    }
    public static int [] lis_longest(int[] arr)
    {
        int [] [] mat = new int[arr.length][arr.length];
        int index=0,size=1;
        mat[0][0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            index = binary_search(arr[i],size,mat);
            mat[index][index] = arr[i];
            if(index==size)
                size++;
            for (int j = 0; j <index ; j++) {
                mat[index][j] = mat[index-1][j];
            }
        }
        int [] longest = new int[size];
        for (int i = 0; i <size ; i++) {
            longest[i] = mat[index][i];
        }
        return longest;
    }
    public static int binary_search(int num, int size, int[][] mat)
    {
        if (num>mat[size-1][size-1])
            return size;
        if(num<mat[0][0])
            return 0;
        int i = 0, j = size,mid;
        while(i<=j) {
            if(i==j)
                return i;
            mid = (int) ((j + i) / 2);
            if(num == mat[mid][mid])
                return mid;
            else if(num<mat[mid][mid])
                j=mid;
            else
                i = mid+1;
        }
        return -1;
    }
    public static void main (String [] args)
    {
        String str1 = "abfd", str2 = "abhhjhfra", str3 = "afd";
        System.out.println(longest_contain_x_y(str1,str2));
    }
}
