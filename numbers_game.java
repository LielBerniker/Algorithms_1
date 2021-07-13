public class numbers_game {
    public static int[][] create_mat(int a[])
    {
        int [][] mat = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            mat[i][i] = a[i];
        }
        for (int i = a.length-2; i >=0 ; i--) {
            for (int j = i+1; j <a.length ; j++) {
                if(a[i] - mat[i+1][j] > a[j] - mat[i][j-1])
                    mat[i][j] = a[i] - mat[i+1][j];
                else
                    mat[i][j] = a[j] - mat[i][j-1];
            }
        }
        return mat;
    }
    public static int game_play(int a[])
    {
        int [][] mat = create_mat(a);
        int i = 0 , j = a.length-1, sum_1 = 0, sum_2 = 0;
        for (int k = 0; k < a.length/2; k++) {
            if(a[j] - mat[i][j-1] > a[i] - mat[i+1][j])
            {
                sum_1 = sum_1 + a[j];
                j--;
            }
            else
            {
                sum_1 = sum_1 + a[i];
                i++;
            }
            if(i!=j)
            {
                if(a[j] - mat[i][j-1] > a[i] - mat[i+1][j])
                {
                    sum_2 = sum_2 + a[j];
                    j--;
                }
                else
                {
                    sum_2 = sum_2 + a[i];
                    i++;
                }
            }
            else {
                sum_2 = sum_2 + a[i];
            }
        }
        System.out.println("player_1 : " + sum_1 + " player_2 :"+ sum_2);
        return sum_1-sum_2;
    }
    public static void main ( String [] args)
    {
        int [] arr  = {1,2,6,1,2,6};
        game_play(arr);
    }
}
