public class glass_bal_min_number_checks {
    public static int numberOfCheckingK(int n,int k) {
        int numCheack = 0, min = 0;
        int[][] cheack = new int[k+1][n+1];
        for (int j = 0; j <= n; j++) {
            cheack[0][j] = 0;
            cheack[1][j] = j;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <=n; j++) {
                min = Integer.MAX_VALUE;
                for (int p = 1; p <= j; p++) {
                    if((Math.max(cheack[i][j-p], (cheack[i-1][p-1]))+1)<min) {
                        min = Math.max(cheack[i][j - p], (cheack[i - 1][p - 1])) + 1;
                        System.out.println("Math.max(cheack["+ i + "]["+ (j-p) + "]="+cheack[i][j - p]+", (cheack["+ (i-1)+ "][" + (p-1)+ "])=" + (cheack[i - 1][p - 1]) + ") + 1");
                    }
                }
                cheack[i][j] = min;

            }
        }


        numCheack =	cheack[k][n];
        return numCheack;
    }
    public static void main (String [] args)
    {
        int [] a = {1,2,3,4,5,6};
        System.out.println(numberOfCheckingK(6,4));
    }
}
