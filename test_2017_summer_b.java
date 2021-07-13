import java.util.Stack;

public class test_2017_summer_b {
    class node {
        double up, right, lower_path, higher_path;

        public node(double up, double right) {
            this.up = up;
            this.right = right;
            this.higher_path = 0;
            this.lower_path = Double.MAX_VALUE;
        }
    }
    class node_max
    {
        int num;
        Stack<Integer> lowers;
        public node_max(int num)
        {
            this.num = num;
            lowers = new Stack<>();
        }
    }
    public static void change_x_to_y(String x,String y)
    {
        String common_str = longest_comm_str(x,y);
        int del_count = 0, add_count = 0,com_index = 0;
        for (int i = 0; i < x.length(); i++) {
            if(com_index==common_str.length())
            {
                del_count++;
            }
            else {
                if (x.charAt(i) == common_str.charAt(com_index)) {
                    com_index++;
                } else {
                    del_count++;
                }
            }
        }
        com_index = 0;
        for (int i = 0; i < y.length() ; i++) {
            if(com_index==common_str.length())
                add_count++;
            else {
                if (y.charAt(i) == common_str.charAt(com_index)) {
                    com_index++;
                } else {
                    add_count++;
                }
            }
        }
        System.out.println("number of add: " + add_count + " number of delete: " + del_count);

    }
    public static String longest_comm_str(String str1,String str2)
    {
        int [][] mat =create_str_mat(str1,str2);
        int i = str1.length(), j = str2.length();
         String longest = "";
         while(mat[i][j]!=0)
         {
             if(str1.charAt(i-1) == str2.charAt(j-1)) {
                 longest = str1.charAt(i - 1)+  longest;
                 i--;
                 j--;
             }
             else
             {
                 if(mat[i-1][j] > mat[i][j-1])
                     i--;
                 else
                     j--;
             }
         }
        System.out.println(longest);
         return longest;


    }
    public static int[][] create_str_mat(String s1, String s2)
    {
        int row = s1.length(), col = s2.length();
        int [][] mat = new int[row+1][col+1];
        for (int i = 0; i <= row ; i++) {
            mat[i][0]= 0;
        }
        for (int i = 1; i <=col ; i++) {
            mat[0][i]= 0;
        }
        for (int i = 1; i <= row ; i++) {
            if(s1.charAt(i-1)==s2.charAt(0))
                mat[i][1] = 1;
            else
                mat[i][1] = 0;
        }
        for (int i = 2; i <= col ; i++) {
            if(s2.charAt(i-1)==s1.charAt(0))
                mat[1][i] = 1;
            else
                mat[1][i] = 0;
        }
        for (int i = 2; i <=row; i++) {
            for (int j = 2; j <=col ; j++) {
                if(s2.charAt(j-1) == s1.charAt(i-1))
                {
                    mat[i][j] = mat[i-1][j-1]+1;
                }
                else
                {
                    if(mat[i-1][j]>mat[i][j-1])
                        mat[i][j]= mat[i-1][j];
                    else
                        mat[i][j]= mat[i][j-1];
                }
            }
        }
        return mat;
    }
    public static String two_max_reg(node_max[] a)
    {
        int max = 0;
        for (int i = 1; i <a.length ; i++) {
            if(a[i].num > a[max].num)
            {
                max = i;
                a[i].lowers.add(a[max].num);
            }
        }
        int max2= a[max].lowers.pop(), temp;
        while (a[max].lowers.empty() == false)
        {
            temp = a[max].lowers.pop();
            if(temp>max2)
                max2 = temp;
        }
        return ""+ a[max].num + "," + max2;
    }
    public static String two_max_rec(node_max[] a)
    {
        int max = two_max_in_rec(a,0,a.length-1);
        int max2= a[max].lowers.pop(), temp;
        while (a[max].lowers.empty() == false)
        {
            temp = a[max].lowers.pop();
            if(temp>max2)
                max2 = temp;
        }
        return ""+ a[max].num + "," + max2;
    }
    public static int two_max_in_rec(node_max[] max_arr,int low,int high)
    {
        if(low<high)
        {
            int mid = (high-low)/2;
            int i = two_max_in_rec(max_arr,low,mid);
            int j = two_max_in_rec(max_arr,mid+1,high);
            if(max_arr[i].num>max_arr[j].num)
            {
                max_arr[i].lowers.add(max_arr[j].num);
                return i;
            }
            else
            {
                max_arr[j].lowers.add(max_arr[i].num);
                return j;
            }

        }
        return low;
    }

    public static double high_path_min_low_path(node[][] full_path) {
        int row = full_path.length;
        int col = full_path[0].length;
        for (int i = row - 1; i >= 0; i--) {
            if (i == full_path.length - 1) {
                full_path[i][0].higher_path = 0;
                full_path[i][0].lower_path = 0;
            } else {
                full_path[i][0].higher_path = full_path[i - 1][0].higher_path + full_path[i - 1][0].up;
                full_path[i][0].lower_path = full_path[i - 1][0].lower_path + full_path[i - 1][0].up;
            }
        }
        for (int i = 1; i < col; i++) {
            {
                full_path[row - 1][i].higher_path = full_path[row - 1][i - 1].higher_path + full_path[row - 1][i - 1].right;
                full_path[row - 1][i].lower_path = full_path[row - 1][i - 1].lower_path + full_path[row - 1][i - 1].right;
            }
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 1; j < col; j++) {
                if ((full_path[i + 1][j].lower_path + full_path[i + 1][j].up) < (full_path[i][j - 1].lower_path + full_path[i][j - 1].right))
                    full_path[i][j].lower_path = full_path[i + 1][j].lower_path + full_path[i + 1][j].up;
                else
                    full_path[i][j].lower_path = full_path[i][j - 1].lower_path + full_path[i][j - 1].right;

                if ((full_path[i + 1][j].higher_path + full_path[i + 1][j].up) > (full_path[i][j - 1].higher_path + full_path[i][j - 1].right))
                    full_path[i][j].higher_path = full_path[i + 1][j].higher_path + full_path[i + 1][j].up;
                else
                    full_path[i][j].higher_path = full_path[i][j - 1].higher_path + full_path[i][j - 1].right;
            }
        }
        double difference = full_path[row - 1][col - 1].higher_path - full_path[row - 1][col - 1].lower_path;
        return difference;
    }

    public static boolean high_path_min_low_path(node[][] full_path,int row_1, int col_1,int row_2, int col_2) {
        init_full_path(full_path,full_path.length-1,0,0,full_path[0].length-1);
       double short_path = full_path[0][full_path[0].length-1].lower_path;
       init_full_path(full_path,full_path.length-1,0,row_1,col_1);
       double short_1 = full_path[row_1][col_1].lower_path;
       if(short_1>short_path)
           return false;
       init_full_path(full_path,row_1,col_1,0,full_path[0].length-1);
        double short_2 = full_path[0][full_path[0].length-1].lower_path;
        if(short_1+short_2>short_path)
            return false;

        init_full_path(full_path,full_path.length-1,0,row_2,col_2);
        short_1 = full_path[row_2][col_2].lower_path;
        if(short_1>short_path)
            return false;
        init_full_path(full_path,row_2,col_2,0,full_path[0].length-1);
        short_2 = full_path[0][full_path[0].length-1].lower_path;
        if(short_1+short_2>short_path)
            return false;
        return true;

    }
    public static void init_full_path(node[][] full_path, int start_r, int start_c, int finish_r,int finish_c) {
        int row = full_path.length;
        int col = full_path[0].length;
        for (int i = start_r; i >= finish_r; i--) {
            if (i == full_path.length - 1) {
                full_path[i][start_c].lower_path = 0;
            } else {
                full_path[i][start_c].lower_path = full_path[i - 1][start_c].lower_path + full_path[i - 1][start_c].up;
            }
        }
        for (int i = start_c+1; i <= finish_c; i++) {
                full_path[start_r-1][i].lower_path = full_path[start_r-1][i - 1].lower_path + full_path[start_r-1][i - 1].right;
        }
        for (int i = start_r -1; i >= finish_r; i--) {
            for (int j = start_c+1; j <= finish_c; j++) {
                if ((full_path[i + 1][j].lower_path + full_path[i + 1][j].up) < (full_path[i][j - 1].lower_path + full_path[i][j - 1].right))
                    full_path[i][j].lower_path = full_path[i + 1][j].lower_path + full_path[i + 1][j].up;
                else
                    full_path[i][j].lower_path = full_path[i][j - 1].lower_path + full_path[i][j - 1].right;
            }
        }
    }
    public static void main(String [] args)
    {
        String x ="abcdefh";
        String y = "bcefg";
        change_x_to_y(x,y);
    }
}
