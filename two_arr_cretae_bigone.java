public class two_arr_cretae_bigone {
    public int[] big_arr_from_two(int [] a, int [] b)
    { int i = 0,j = b.length-1;
      int [] c = new int [a.length];
        for (int k = 0; k < c.length; k++) {
            if(a[i]>b[j])
            {
                fill_up(i,k,a,c);
                return c;
            }
            else
            {
                c[k] = b[j];
                j--;
                i++;
            }
        }
        return c;
    }
    public void fill_up(int index_a,int index_c , int [] a,int [] c)
    { int a_i = index_a;
        for (int i = index_c; i <c.length ; i++) {
            c[i] = a[a_i];
        }
    }
}
