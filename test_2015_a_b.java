import java.util.HashMap;

public class test_2015_a_b {
    class node
    {
        double x,y,low_price;
    }
    static class point
    {
        int i,j;
        public point()
        {
            this.j = -1;
            this.i = -1;
        }
    }

    public static boolean all_pints_in_way(point[]p , node[][]way)
    { point small = new point(),big = new point();
    small.i = 0; small.j = 0; big.i = way.length-1; big.j = way[0].length-1;
    small.i=0;small.j = 0;
    double min_all = airplane_problem_bound(way,small,big),temp,all_way;
    if(sort_points(p) == false)
        return false;
    temp = airplane_problem_bound(way,small,p[0]);
    if(temp>min_all)
        return false;
    all_way = temp;
    for (int i = 1; i <p.length ; i++) {
            temp = airplane_problem_bound(way,p[i-1],p[i]);
            all_way = all_way +temp;
            if(all_way>min_all)
                return false;
        }
    temp = airplane_problem_bound(way,p[p.length-1],big);
    all_way = all_way + temp;
    if(min_all == all_way)
        return true;
    else
        return false;
    }
    public static boolean sort_points(point[] p)
    {
        point temp_p;
        for (int i = 0; i < p.length-1; i++) {
            for (int j = i; j <p.length-1 ; j++) {
                if(((p[j].i<p[j+1].i) && (p[j].j>p[j+1].j) )||((p[j].i>p[j+1].i) && (p[j].j<p[j+1].j) ))
                    return false;
                else if(p[j].i>p[j+1].i) {
                    temp_p = p[j];
                    p[j] = p[j+1];
                    p[j+1] = temp_p;
                }
            }
        }
        return true;
    }
    public static double airplane_problem_bound(node[][] air,point p1, point p2)
    {
        int i_s = p1.i, i_e = p2.i, j_s = p1.j, j_e = p2.j;
        air[i_s][j_s].low_price = 0;
        for (int i = i_s+1; i <= i_e; i++) {
            air[i][j_s].low_price =  air[i-1][j_s].low_price +  air[i-1][j_s].y;
        }
        for (int i = j_s+1; i <= j_e; i++) {
            air[i_s][i].low_price =  air[i_s][i-1].low_price +  air[i_s][i-1].x;
        }
        for (int i = i_s+1; i <+i_e ; i++) {
            for (int j = j_s+1; j <+j_e ; j++) {
                if(air[i-1][j].low_price +air[i-1][j].y < air[i][j-1].low_price +air[i][j-1].x)
                {
                    air[i][j].low_price = air[i-1][j].low_price +air[i-1][j].y;
                }
                else
                    air[i][j].low_price =air[i][j-1].low_price +air[i][j-1].x;
            }
        }
        return air[i_e][j_e].low_price;
    }
    public static int more_then_half(int[]a)
    {
        HashMap<Integer,Integer> all_num= new HashMap<>();
        for (int i = 0; i <a.length ; i++) {
            if(all_num.get(a[i]) == null)
                all_num.put(a[i],1);
            else all_num.put(a[i],all_num.get(a[i])+1);
        }
        for (int key: all_num.keySet()) {
            if(all_num.get(key) > a.length/2)
                return key;
        }
        return Integer.MAX_VALUE;
    }
    public static int lcs_size(String str1,String str2)
    {
        int row= str1.length(),col = str2.length();
        int [][] lcs_mat = new int[row+1][col+1];
        for (int i = 0; i <=row; i++) {
            lcs_mat[i][0] = 0;
        }
        for (int i = 1; i <= col; i++) {
            lcs_mat[0][i] = 0;
        }
        for (int i = 1; i <=row; i++) {
            for (int j = 1; j <=col; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    lcs_mat[i][j] = lcs_mat[i-1][j-1]+1;
                else
                    lcs_mat[i][j] = Math.max(lcs_mat[i-1][j],lcs_mat[i][j-1]);
            }
        }
        return lcs_mat[row][col];
    }
    public static int pulindrom(String str1)
    {
        int max = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = i; j <str1.length() ; j++) {
                if (is_pulindrom(str1,i,j)==true)
                {
                    if((j-i+1)>max)
                        max = j-i+1;
                }
            }
        }
        return max;
    }
    public static boolean is_pulindrom(String str, int i , int j)
    {
     while (i<j) {
         if (str.charAt(i) != str.charAt(j))
             return false;
         i++;
         j--;
     }
     return true;
    }

    public static void main(String[] args) {
        String str1 = "dfgvdgd" ,str2 = "fvd";
        System.out.println(lcs_size(str1,str2));
        String ss = "alfalfa";
    }

}
