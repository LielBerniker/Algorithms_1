import java.lang.reflect.Array;
import java.util.Arrays;

public class lis {
    public static int[] lis_in_arr(int [] a)
    {
        int arr_size = a.length, i=0,k=1;
        int [][] mat = new int[arr_size][arr_size];
        mat[0][0] = a[0];
        for (int j = 1; j <arr_size ; j++) {
            i = binary_serch(mat,k,a[j]);
            mat[i][i] = a[j];
            if(i == k)
                k++;
            copy(mat,i);
        }
        int []new_arr = new int[k];
        for (int j = 0; j <k ; j++) {
            new_arr[j] = mat[k-1][j];
        }
        return new_arr;
    }
    public static void copy(int [][] mat,int size)
    {
        for (int i = 0; i < size; i++) {
           mat[size][i] = mat[size-1][i];
        }
    }
    public static int binary_serch(int[][] mat,int size,int val )
    { if(val<mat[0][0])
        return 0;
    if(val>mat[size-1][size-1])
        return size;
    int low = 0,high = size;
    while(low<=high)
    {
        if (low == high)
            return low;
        int mid = (low+high)/2;
        if(mat[mid][mid] == val)
            return mid;
        if(mat[mid][mid]> val)
           high = mid;
        else
            low = mid+1;
    }
    return -1;
    }
    public static void main(String [] args)
    {
        int [] arr = {1,5,45,22,3,675,988,3,546,43};
        int [] a = lis_in_arr(arr);
        System.out.println(Arrays.toString(a));
    }
}
