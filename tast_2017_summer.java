public class tast_2017_summer {
    public static String longest_a_not_in_b(String a, String b)
    {
        String c = "";
        int k =0;
        if(a.length()>b.length())
             c=a;
        else {
            for (int i = 0; i <b.length() && k<a.length() ; i++) {
               if(a.charAt(k)==b.charAt(i))
                   k++;
                if(k==a.length())
                    c="";
                }
            if(k<a.length())
                c=a;

            }
        return c;
    }
    public static String longest_a_or_b(String a, String b)
    {
        String c = "";
        int k =0;
        if(a.length()>b.length())
            return a;
        else if(a.length()<b.length())
            return b;
        else {
            for (int i = 0; i <b.length() && k<a.length() ; i++) {
                if(a.charAt(k)==b.charAt(i))
                    k++;
            }
            if(k==a.length())
                c="";
            else
                c= a;
        }
        return c;
    }

    public static int fibo(int n)
    {
        if(n == 0)
            return 0;
        if(n== 1 || n==2)
            return 1;
        int[][] mat = {{1,1},{1,0}};
        int [][] ans = {{1,1},{1,0}};
        while (n != 0) {
            if(n%2 == 1)
            {
               ans = mult_mat(mat,ans);
            }
            mat = mult_mat(mat,mat);
            n = n/2;
        }
     return ans[1][1];
    }
    public static int[][] mult_mat(int[][] mat, int[][] ans)
    {
        int [] [] final_ans = new int[2][2];
        final_ans[0][0]= mat[0][0]*ans[0][0] + mat[0][1]*ans[1][0];
        final_ans[0][1]= mat[0][0]*ans[0][1] + mat[0][1]*ans[1][1];
        final_ans[1][0]= mat[1][0]*ans[0][0] + mat[1][1]*ans[1][0];
        final_ans[1][1]= mat[1][0]*ans[0][1] + mat[1][1]*ans[1][1];
        return final_ans;
    }
    public static int[] big_up_combo(int [] a)
    {
        int [][] mat = new int[a.length][a.length];
        int index,count=1,max=0,i_i;
        mat[0][0] = a[0];
        for (int i = 0; i <a.length ; i++) {
            mat[0][0] = a[i];
            count = 1;
            if(i+1==a.length)
            i_i = 0;
            else
                i_i = i+1;
            for (int j = 1; j < a.length; j++) {

                index = binary_index(a[i_i], count, mat);
                mat[index][index] = a[i_i];
                if (count == index)
                    count++;
                copyall(mat, index);
                i_i++;
                if (i_i == a.length )
                    i_i = 0;
            }
            if (count>max)
                max = count;
        }
        int [] arr = new int[max];
        for (int j = 0; j < max; j++) {
            arr[j] = mat[max-1][j];
        }
        return arr;
    }
    public static void copyall(int [][] mat,int size)
    {
        for (int i = 0; i < size; i++) {
            mat[size][i] = mat[size-1][i];
        }
    }
    public static int binary_index(int num,int size,int[][] mat)
    {
        int low,high,mid;
        if(num<mat[0][0])
            return 0;
        if(num>mat[size-1][size-1])
            return size;
        low = 0;
        high = size;
        while(low<=high)
        {
            if(low == high)
                return low;
            mid = (high+low)/2;
            if(mat[mid][mid]>num)
            {
                high = mid;
            }
            else if(mat[mid][mid] < num)
                low = mid+1;
            else
                return mid;
        }
        return -1;
    }
     public static int big_ones_mat(int[][] mat)
    {
        int max =0;
      int [][] mat_fix = create_mat(mat);
        for (int i = 0; i <mat_fix.length ; i++) {
            for (int j = 0; j <mat_fix[0].length ; j++) {
                if(mat_fix[i][j] > max)
                    max = mat_fix [i][j];
            }
        }
        return max;
    }
    public static int number_of_2x2(int[][]mat)
    {
        int count =0;
        int [][] mat_fix = create_mat(mat);
        for (int i = 0; i <mat_fix.length ; i++) {
            for (int j = 0; j <mat_fix[0].length ; j++) {
                if(mat_fix[i][j] >=2)
                    count++;
            }
        }
        return count;
    }
    public static int [][] create_mat(int[][]mat)
    {
        int[][] new_mat = new int[mat.length][mat[0].length];
        for (int i = 0; i <new_mat.length ; i++) {
            new_mat[i][0] = mat[i][0];
        }
        for (int i = 1; i <new_mat[0].length ; i++) {
            new_mat[0][i] = mat[0][i];
        }
        for (int i = 1; i <new_mat.length ; i++) {
            for (int j = 1; j <new_mat[0].length ; j++) {
                   if(mat[i][j] == 0)
                       new_mat[i][j] = 0;
                   else
                   {
                       if(new_mat[i-1][j-1]<new_mat[i-1][j])
                       {
                           if(new_mat[i-1][j-1]<new_mat[i][j-1])
                               new_mat[i][j] = new_mat[i-1][j-1]+1;
                           else
                               new_mat[i][j] = new_mat[i][j-1]+1;
                       }
                       else
                       {
                           if(new_mat[i-1][j]<new_mat[i][j-1])
                               new_mat[i][j] = new_mat[i-1][j] +1;
                           else
                               new_mat[i][j] = new_mat[i][j-1] +1;
                       }
                   }

            }
        }
        return new_mat;
    }
    public static void main(String[] args)
    {
        int[]arr = {9,10,8,0,1,4,3,7};
        System.out.println(print_arr(big_up_combo(arr)));
        System.out.println(fibo(10));



    }
    public static String print_arr(int[] arr) {
        String str1 = "";
        for (int i = 0; i < arr.length; i++) {
         str1 = str1 + arr[i];
        }
        return str1;
    }
}
