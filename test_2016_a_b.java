public class test_2016_a_b {
    public static String lps(String s)
    {
        String rev,small_poli = "";
        rev = reverse_string(s);
        int[][] mat = new int[s.length()+1][rev.length()+1];
        create_lcs_mat(mat,s,rev);
        int i = mat.length, j = mat[0].length;
        while (mat[i][j]!=0)
        {
            if(s.charAt(i-1) == rev.charAt(j-1))
            { small_poli = s.charAt(i-1) + small_poli;i--;j--;}
            else if(mat[i][j-1]>mat[i-1][j])
                j--;
            else
                i--;
        }
        return small_poli;
    }
    public static String reverse_string(String str)
    {
        String rev = "";
        for (int i = 0; i <str.length() ; i++) {
            rev =  str.charAt(i) + rev ;
        }
        return rev;
    }
    public static void create_lcs_mat(int [][] mat , String s1,String s2)
    {
        int row = mat.length, col = mat[0].length;
        for (int i = 0; i <row ; i++) {
            mat[i][0] = 0;
        }
        for (int i = 1; i <col ; i++) {
            mat[0][i] = 0;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j <col ; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    mat[i][j] = mat[i-1][j-1] +1;
                else
                    mat[i][j] = Math.max(mat[i-1][j],mat[i][j-1]);
            }
        }
    }
    class Q3
    { int lower1,lower2;
        Node[][] nodes;
        Point[] forbidden;

        class Point
        {
            int i,j;
        }
        class Node {
            int x, y, lower_1,lower_2;

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
                this.lower_1 = -1;
                this.lower_2 = -1;
            }
        }
        public Q3(Node[][] nodes, Point[] forbidden)
        {
            this.lower1 = Integer.MAX_VALUE;
            this.lower2 = Integer.MAX_VALUE;
            this.forbidden = forbidden;
            this.nodes = nodes;
        }
        public int cheapestPathPrice()
        {
          set_mat();
          return lower1;
        }
        public int secondCheapestPathPrice ()
        {
          set_mat();
          return lower2;
        }
        public void set_mat()
        {
            int row = this.nodes.length ,col = this.nodes[0].length;
            for (Point poin:this.forbidden) {
                this.nodes[poin.i][poin.i].lower_1 = Integer.MAX_VALUE;
                this.nodes[poin.i][poin.i].lower_2 = Integer.MAX_VALUE;

            }
            if(nodes[0][0].lower_1!=Integer.MAX_VALUE)
            {nodes[0][0].lower_1 = 0;
                nodes[0][0].lower_2 = 0;}
            for (int i = 1; i < row; i++) {
                if(nodes[i-1][0].lower_1 == Integer.MAX_VALUE)
                {
                    nodes[i][0].lower_1 = Integer.MAX_VALUE;
                    nodes[i][0].lower_2 = Integer.MAX_VALUE;
                }
                else
                {
                    nodes[i][0].lower_1 = nodes[i-1][0].lower_1+ nodes[i-1][0].y;
                    nodes[i][0].lower_2 = nodes[i-1][0].lower_2+ nodes[i-1][0].y;
                }
            }
            for (int i = 1; i < col; i++) {
                if(nodes[0][i-1].lower_1 == Integer.MAX_VALUE)
                {
                    nodes[0][i].lower_1 = Integer.MAX_VALUE;
                    nodes[0][i].lower_2 = Integer.MAX_VALUE;
                }
                else
                {
                    nodes[0][i].lower_1 = nodes[0][i-1].lower_1+ nodes[0][i-1].x;
                    nodes[0][i].lower_2 = nodes[0][i-1].lower_2+ nodes[0][i-1].x;
                }
            }
            for (int i = 1; i <row ; i++) {
                for (int j = 0; j <col ; j++) {
                    if(nodes[i][j].lower_1 != Integer.MAX_VALUE)
                    {
                        if(nodes[i-1][j].lower_1 != Integer.MAX_VALUE && nodes[i][j-1].lower_1 != Integer.MAX_VALUE )
                        {
                            if(nodes[i-1][j].lower_1 + nodes[i-1][j].y < nodes[i][j-1].lower_1 + nodes[i][j-1].x) {
                                nodes[i][j].lower_1 = nodes[i - 1][j].lower_1 + nodes[i - 1][j].y;
                                if(nodes[i][j-1].lower_1 + nodes[i][j-1].x < nodes[i-1][j].lower_2 + nodes[i-1][j].y)
                                    nodes[i][j].lower_2 = nodes[i][j-1].lower_1 + nodes[i][j-1].x;
                                else
                                    nodes[i][j].lower_2 = nodes[i-1][j].lower_2 + nodes[i-1][j].y;
                            }
                            else
                            {
                                nodes[i][j].lower_1 = nodes[i][j-1].lower_1 + nodes[i][j-1].x;
                                if(nodes[i-1][j].lower_1 + nodes[i-1][j].y < nodes[i][j-1].lower_2 + nodes[i][j-1].x)
                                    nodes[i][j].lower_2 = nodes[i-1][j].lower_1 + nodes[i-1][j].y;
                                else
                                    nodes[i][j].lower_2 = nodes[i][j-1].lower_2 + nodes[i][j-1].x;
                            }
                        }
                        else if(nodes[i-1][j].lower_1 != Integer.MAX_VALUE && nodes[i][j-1].lower_1 == Integer.MAX_VALUE)
                        {
                            nodes[i][j].lower_1 = nodes[i-1][j].lower_1;
                            nodes[i][j].lower_2 = nodes[i-1][j].lower_2;
                        }
                        else if(nodes[i-1][j].lower_1 == Integer.MAX_VALUE && nodes[i][j-1].lower_1 != Integer.MAX_VALUE)
                        {
                            nodes[i][j].lower_1 = nodes[i][j-1].lower_1;
                            nodes[i][j].lower_2 = nodes[i][j-1].lower_2;
                        }
                        else
                        {
                            nodes[i][j].lower_1 = Integer.MAX_VALUE;
                            nodes[i][j].lower_2 = Integer.MAX_VALUE;
                        }
                    }
                }
            }
            this.lower1 = nodes[row-1][col-1].lower_1;
            this.lower2 = nodes[row-1][col-1].lower_2;

        }

    }
}
