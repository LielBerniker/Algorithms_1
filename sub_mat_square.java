public class sub_mat_square {
    public static int biggest_1_square(int[][]mat)
    {
        int row = mat.length, col = mat[0].length,max = 0;
        int [][] temp_mat = new int[row][col];
        for (int i = 0; i < row; i++) {
            temp_mat[i][0] = mat[i][0];
        }
        for (int i = 1; i < col; i++) {
            temp_mat[0][i] = mat[0][i];
        }
        for (int i = 1 ; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(mat[i][j] == 0)
                    temp_mat[i][j] = 0;
                else
                {
                   temp_mat[i][j] =  min_box(temp_mat[i-1][j-1],temp_mat[i-1][j],temp_mat[i][j-1]);
                   if(temp_mat[i][j]>max)
                       max = temp_mat[i][j];
                }
            }
        }
        return max;

    }
    public static int min_box(int num1, int num2, int num3)
    {
        if(num1>num2)
        {
            if (num2>num3)
                return num3+1;
            else
                return num2+1;
        }
        else {
            if(num1>num3)
                return num3+1;
            else
                return num1 + 1;
        }
    }
}
