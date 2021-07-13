public class fibo {
    public static int fibo_mat(int fibo)
    {int [][] res = new int[2][2];
          res[0][0] = 1;
        res[0][1] = 0;
        res[1][0] = 0;
        res[1][1] = 1;
        if(fibo == 0)
            return 0;
        if(fibo == 1 || fibo == 2)
            return  1;
        int [][] mat = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if(i==1 && j==1)
                mat[i][j] = 0;
                else
                    mat[i][j] = 1;
            }}

            while(fibo>0)
            {
                if(fibo%2 == 1)
                {
                   res = mat_mult(res,mat);
                }
                mat = mat_mult(mat,mat);
            }
            return res[1][1];
    }
    public static int[][] mat_mult(int[][] mat1, int [][] mat2)
    {
        int [][] mat = new int[2][2];
        mat[0][0] = mat1[0][0]*mat2[0][0] +mat1[0][1]*mat2[1][0];
        mat[0][1] = mat1[0][0]*mat2[0][1] +mat1[0][1]*mat2[1][1];
        mat[1][0] = mat1[1][0]*mat2[0][0] +mat1[1][1]*mat2[1][0];
        mat[1][1] = mat1[1][0]*mat2[0][1] +mat1[1][1]*mat2[1][1];
        return mat;
    }
}
