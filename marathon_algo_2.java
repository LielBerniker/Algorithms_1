import java.lang.reflect.Array;
import java.util.Arrays;

public class marathon_algo_2 {
    public static double []arr_of_sqr_or_power(double []a)
    {
        int [] counter =new int [a.length];
        int j , max = 0,index =0;
        counter[0] = 1;
        for (int i = 1; i < counter.length; i++) {
            j = i-1;
            while(j>=0)
            {
                if(a[j] == Math.sqrt(a[i]) || a[j] == Math.pow(a[i],2) )
                {
                    counter[i] = counter[j] +1; break;
                }
                else
                { j--; }
            }
            if(counter[i] == 0)
                counter[i] = 1;
            if(max<counter[i])
            { max = counter[i]; index = i;}
        }
        double [] aaa =new double[max];
        aaa[aaa.length-1] = a[index];
        int togo = counter[index], cnt =max-2;
        index--;
      while(index >=0 &&togo>1)
      {
         if(a[index] == Math.sqrt(aaa[cnt+1]) || a[index] == Math.pow(aaa[cnt+1],2))
         {aaa[cnt] = a[index]; cnt--;togo = counter[index];}

         {index--;}
      }
      return aaa;
    }
    public static int length_of_sqr_or_power(double []a)
    {
        int [] counter =new int [a.length];
        int j , max = 0;
        counter[0] = 1;
        for (int i = 1; i < counter.length; i++) {
            j = i-1;
            while(j>=0)
            {
                if(a[j] == Math.sqrt(a[i]) || a[j] == Math.pow(a[i],2) )
                {
                    counter[i] = counter[j] +1; break;
                }
                else
                { j--; }
            }
            if(counter[i] == 0)
                counter[i] = 1;
            if(max<counter[i])
                max = counter[i];
        }
        return max;
    }
    public static int number_game_circle(int [] arr)
    {
        int max= Integer.MIN_VALUE;
        int [] a = new int[arr.length-1];
        int[][] mat = new int[a.length][a.length];
        for (int i = 0; i <arr.length ; i++) {
             update_arr(arr,a,i);
             upd_mat_num_game(mat,a);
             if(max<arr[i]-mat[0][mat.length-1] )
                 max = arr[i]-mat[0][mat.length-1];
        }
return max;
    }
    public static void update_arr(int [] arr, int[] a,int k)
    {
        int j= k+1;
        for (int i = 0 ; i < a.length; i++) {
            a[i] = arr[j];
            j++;
            if(j==arr.length)
                j=0;
        }
    }
    public static void upd_mat_num_game(int [][] mat,int []a)
    {
        for (int i = 0; i <a.length ; i++) {
            mat[i][i] = a[i];
        }
        for (int i = mat.length-2; i >=0 ; i--) {
            for (int j = i+1; j <mat[0].length ; j++) {
                mat[i][j]= Math.max(a[i]-mat[i+1][j],a[j]-mat[i][j-1]);
            }
        }
    }
    public static void horse_problem(int[] a)
    {
      int max1=0,max2=0,max3=0,max4=0,max5=0;
     max_horse_1(a,0,4);
     max_horse_1(a,5,9);
     max_horse_1(a,10,14);
     max_horse_1(a,15,19);
     max_horse_1(a,20,24);
    max_horse_2(a);
    int[] race_3 = {a[19],a[23],a[22],a[18],a[14]};
        Arrays.sort(race_3);
        System.out.println("furst: " + a[24] + " second: " + race_3[4]+ " Third: " + race_3[3]);
    }
    public static void max_horse_1(int[] a,int i, int j)
    {

        for (int k = i; k < j; k++) {
            for (int l = i; l <j; l++) {
                if(a[l]>a[l+1])
                {
                    int temp = a[l];
                    a[l] = a[l+1];
                    a[l+1] = temp;
                }
            }
        }
    }
    public static void max_horse_2(int[] a)
    {

        for (int k = 4; k < 25; k= k+5) {
            for (int l = k; l <=19; l= l+5) {
                if(a[l]>a[l+5])
                {
                    for (int i = l-4; i <= l; i++) {
                        int temp = a[i];
                        a[i] = a[i+5];
                        a[i+5] = temp;
                    }
                }
            }
        }
    }
    public static int big_plus_in_table(int[][] mat)
    {
        int max=0,temp,row = mat.length,col=mat[0].length;
        for (int i = 1; i <row-1 ; i++) {
            for (int j = 1; j <col-1 ; j++) {
                temp = fling_size_plus(mat,i,j);
                if(temp>max)
                    max = temp;
            }
        }
        return  max;
    }
    public static int fling_size_plus(int[][] mat, int i, int j)
    {
        int up=0,down = 0, lef = 0, right = 0 , row = mat.length,col = mat[0].length;
        for (int k = i; k <row ; k++) {
            if(mat[k][j] == 1)
                down++;
            else break;
        }
        for (int k = i; k >=0 ; k--) {
            if(mat[k][j] == 1)
                up++;
            else break;
        }
        for (int k = j; k >=0 ; k--) {
            if(mat[i][k] == 1)
                lef++;
            else break;
        }
        for (int k = j; k <col; k++) {
            if(mat[i][k] == 1)
                right++;
            else break;
        }
        int min1 = Math.min(up,down), min2 = Math.min(lef,right), min3,final_ans;
        min3 = Math.min(min1,min2);
        final_ans = (min3-1)*4 +1;
        return final_ans;
    }
    public static void main(String [] args)
    {
        double [] a= {2,7,1,49,3,4,1,9,2,30,81};
        System.out.println(length_of_sqr_or_power(a));
    }
}
