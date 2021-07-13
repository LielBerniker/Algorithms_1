public class test_2020_a {
    public static int length_com(String s1, String s2)
    {
        int lcs_sixe = lcs(s1,s2);
        return s1.length() +s2.length() - lcs_sixe;
    }
    public static int lcs(String s1, String s2)
    {
        int row = s1.length()+1, col = s2.length()+1;
        int [][]mat = new int[row][col];
        for (int i = 0; i <row ; i++) {
            mat[i][0]= 0;
        }
        for (int i = 1; i <col ; i++) {
            mat[0][i]= 0;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j <col ; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    mat[i][j]= mat[i-1][j-1] + 1;
                }
                else
                {
                    mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
                }
            }
        }
        return mat[row][col];
    }
}
