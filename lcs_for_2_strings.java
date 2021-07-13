public class lcs_for_2_strings {
    public static int[][] build_mat(String str1,String str2)
    {
        int row_size = str1.length()+1, col_size = str2.length()+1;
        int [][] mat = new int[row_size][col_size];
        for (int i = 0; i <row_size ; i++) {
             mat[i][0] = 0;
        }
        for (int i = 1; i < col_size; i++) {
            mat[0][i] = 0;
        }
        for (int i = 1; i <row_size ; i++) {
            for (int j = 1; j <col_size ; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    mat[i][j] = mat[i-1][j-1] + 1;
                else
                {
                    if (mat[i-1][j]>mat[i][j-1])
                        mat[i][j] = mat[i-1][j];
                    else
                        mat[i][j] = mat[i][j-1];
                }
            }
        }
        return mat;
    }
    public static int length_of_lcs(String str1,String str2)
    {
        int mat[][] = build_mat(str1,str2);
        return mat[str1.length()][str2.length()];
    }
    public static String longest_lcs(String str1,String str2)
    {
        String str_long = "";
        int mat[][] = build_mat(str1,str2);
        int i = str1.length(), j = str2.length();
        while(mat[i][j] != 0)
        {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                str_long = str1.charAt(i - 1) + str_long;
                i--;
                j--;
            }
            else
            {
                if (mat[i-1][j]>mat[i][j-1])
                    i--;
                else
                    j--;
            }
        }
        return str_long;
    }
    public static void main(String[] args)
    {
        String str1,str2;
        str1 = "avchsacs";
        str2 = "acqscsaa";
        System.out.println(longest_lcs(str1,str2));

    }
}
