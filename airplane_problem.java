import java.util.ArrayList;
import java.util.List;

public  class airplane_problem {
    static class node
    {
        double x , y, price;
        int n_l_path;
        public node(double y,double x)
        {
            this.x = x;
            this.y = y;
            this.price = Double.MAX_VALUE;
            this.n_l_path = 1;
        }
    }
    public static void create_way_to_airplane(node[][] way)
    {
        for (int i = 0; i < way[0].length; i++) {
            if(i == 0)
                way[0][i].price=0;
            else
                way[0][i].price = way[0][i-1].price + way[0][i-1].x;
        }
        for (int i = 1; i <way.length ; i++) {
            way[i][0].price = way[i-1][0].price + way[i-1][0].y;
        }
        for (int i = 1; i <way.length ; i++) {
            for (int j = 1; j < way[0].length; j++) {
                if((way[i-1][j].y+way[i-1][j].price) == (way[i][j-1].x+way[i][j-1].price)) {
                    way[i][j].price = way[i - 1][j].y + way[i - 1][j].price;
                    way[i][j].n_l_path = way[i - 1][j].n_l_path + way[i][j-1].n_l_path;
                }
                else if((way[i-1][j].y+way[i-1][j].price) < (way[i][j-1].x+way[i][j-1].price))
                {
                    way[i][j].price = way[i - 1][j].y + way[i - 1][j].price;
                    way[i][j].n_l_path = way[i - 1][j].n_l_path ;
                }
                else
                {
                    way[i][j].price = way[i][j-1].x + way[i][j-1].price;
                    way[i][j].n_l_path = way[i][j-1].n_l_path ;
                }
            }
        }
    }
    public static double shotest_path_airplane(node[][] way)
    {
        create_way_to_airplane(way);
        int row_size = way.length, col_size = way[0].length;
        return way[row_size-1][col_size-1].price;
    }
    public static int number_of_short_path(node[][]way)
    {
        create_way_to_airplane(way);
        int row_size = way.length, col_size = way[0].length;
        return way[row_size-1][col_size-1].n_l_path;
    }
    public static String one_short_path(node[][]way)
    {
        create_way_to_airplane(way);
        String short_path = "";
        int i = way.length-1 ,j= way[0].length-1;

        while (i>0 && j>0)
        {
            if(way[i-1][j].y+way[i-1][j].price == way[i][j].price)
            {
                short_path = short_path + '1';
                i--;
            }
            else
            {
                short_path = short_path + '0';
                j--;
            }
        }
        while(j>0)
        {
            short_path = short_path + '0';
            j--;
        }
        while(i>0)
        {
            short_path = short_path + '1';
            i--;
        }
     return short_path;
    }
    public static List<String> all_short_path(long number , node[][]way)
    { String path = "";
        List<String> all_path = new ArrayList<>();
        while(all_path.size()<number)
        {
            create_path(all_path,way,way.length,way[0].length,path);
        }
        return all_path;
    }
    public static void create_path(List<String> all_path,node[][] mat,int i, int j,String path)
    {
        if(i>0 && j>0)
        {
              if((mat[i-1][j].price + mat[i-1][j].y)==(mat[i][j-1].price + mat[i][j-1].x) )
              {
                  String new_path = path + '1';
                  create_path(all_path,mat,i-1,j,new_path );
                  create_path(all_path,mat,i,j-1,path + '0');
              }
              else if((mat[i-1][j].price + mat[i-1][j].y) < (mat[i][j-1].price + mat[i][j-1].x))
              {
                 create_path(all_path,mat,i-1,j,path + '1');
              }
              else
              {
                  create_path(all_path,mat,i,j-1,path + '0');
              }
        }
        else if(i == 0 && j == 0)
            all_path.add(path);
        else if(i>0)
        {
            while(i>0) {
                path = path + '1';
                i--;
            }
            all_path.add(path);
        }
        else if(j>0)
        {
            while(j>0) {
                path = path + '0';
                j--;
            }
            all_path.add(path);
        }
    }
    public static void main (String [] args)
    {
      node [][] way = new node[4][4];
      way[0][0] = new node(4,2);
        way[0][1] = new node(2,3);
        way[0][2] = new node(10,1);
        way[0][3] = new node(9,0);

        way[1][0] = new node(2,5);
        way[1][1] = new node(1,3);
        way[1][2] = new node(2,4);
        way[1][3] = new node(1,0);

        way[2][0] = new node(1,2);
        way[2][1] = new node(6,7);
        way[2][2] = new node(1,2);
        way[2][3] = new node(1,0);

        way[3][0] = new node(0,5);
        way[3][1] = new node(0,1);
        way[3][2] = new node(0,3);
        way[3][3] = new node(0,0);
        System.out.println(shotest_path_airplane(way));
     }
}
