public class test_2018_sim_a_a {
    class node
    {
        char name ;
        node next;
        node prev;
        public node(node prev, node next)
        {
            this.name = (char)(Math.random()*27 + 97);
            this.next = next;
            this.prev = prev;
        }
    }
    class link_l
    {
        node head;
        public link_l()
        {
            this.head = null;
        }
    }
    class program_com
    {
        int bytes_num;
        double freq;
        public program_com(int num, double freq)
        {
            this.bytes_num = num;
            this.freq = freq;
        }
    }
    class point
    {
        int x,y;
        public point(int p, int q)
        {
            this.x = p;
            this.y = q;
        }
    }
    class page_node
    {
        double right,down,low_price;
        public page_node(double r, double u)
        {
            this.right = r;
            this.down = u;
            this.low_price = Double.MAX_VALUE;
        }
    }
    public static double lower_form_p1_p2(page_node [][] page,point p1,point p2)
    {
        point row_p,col_p;
        if(p1.y<p2.y)
        {
            row_p = p1;
            col_p = p2;
        }
        else
        {
            row_p = p2;
            col_p = p1;
        }

        page[row_p.y][row_p.x].low_price =0;
        for (int i = row_p.y+1; i <= col_p.y ; i++) {
            page[i][row_p.x].low_price =  page[i-1][row_p.x].low_price +  page[i-1][row_p.x].down;
        }
        for (int i = row_p.x+1; i <= col_p.x ; i++) {
            page[row_p.y][i].low_price =  page[row_p.y][i-1].low_price +  page[row_p.y][-1].right;
        }
        for (int i = row_p.y+1; i <=col_p.y ; i++) {
            for (int j = row_p.x+1; j <+ col_p.x; j++) {
                if((page[i-1][j].low_price + page[i-1][j].down) < (page[i][j-1].low_price + page[i][j-1].right))
                    page[i][j].low_price = page[i-1][j].low_price + page[i-1][j].down;
                else
                    page[i][j].low_price = page[i][j-1].low_price + page[i][j-1].right;
            }
        }
        return page[col_p.y][col_p.x].low_price;

    }
    public static int bigger_then_half(int[] a)
    {
        int max = a[0];
        for (int i = 1; i <a.length && i<64 ; i++) {
            if(a[i]>max)
                max = a[i];
        }
        return max;
    }
    public static int[] all_bigger_half(int[] a, int [] b)
    {
        int [] c = new int[a.length];
        if(a[a.length-1]<b[0])
            return b;
        if(a[0]>b[b.length-1])
            return a;
        int i = 0, j = b.length-1;
        for (int k = 0; k <c.length ; k++) {
            if(a[i]>b[j])
            {
                c[k] = a[i];
                i++;
            }
            else
            {
                c[k] = b[j];
                j--;
            }
        }
        return c;
    }
    public static void sort_by_freq_and_size(program_com [] prog)
    {
        sort_freq_and_size(0,prog.length-1,prog);
    }
    public static void sort_by_freq(program_com [] prog)
    {
       sort_freq(0,prog.length-1,prog);
    }
    public static void sort_by_size(program_com [] prog)
    {
        sort_size(0,prog.length-1,prog);
    }
    public static void sort_freq_and_size(int start,int end,program_com [] prog)
    {
        if(start<end)
        {
            int mid = (int)(end+start)/2;
            sort_freq_and_size(start,mid,prog);
            sort_freq_and_size(mid+1,end,prog);
            merge_sort_freq_and_size(prog,start,mid,end);
        }
    }
    public static void sort_size(int start,int end,program_com [] prog)
    {
        if(start<end)
        {
            int mid = (int)(end+start)/2;
            sort_size(start,mid,prog);
            sort_size(mid+1,end,prog);
            merge_sort_size(prog,start,mid,end);
        }
    }
    public static void sort_freq(int start,int end,program_com [] prog)
    {
        if(start<end)
        {
            int mid = (int)(end+start)/2;
            sort_freq(start,mid,prog);
            sort_freq(mid+1,end,prog);
            merge_sort_freq(prog,start,mid,end);
        }
    }
    public static void merge_sort_freq_and_size(program_com []prog,int start,int mid,int end)
    {
        program_com [] nw_prog = new program_com[prog.length];
        int i = start, j = mid+1,k=0;
        while (i<=mid && j<=end)
        {
            if (prog[i].bytes_num/prog[i].freq<prog[j].bytes_num/prog[j].freq)
            {
                nw_prog[k] = prog[i];
                i++;
            }
            else
            {
                nw_prog[k] = prog[j];
                j++;
            }
            k++;
        }
        while(i<=mid)
        {nw_prog[k] = prog[i];
            i++;
            k++;}
        while (j<=end)
        {
            nw_prog[k] = prog[j];
            j++;
            k++;
        }
        i=start;
        for (int l = 0; l < nw_prog.length; l++) {
            prog[i] = nw_prog[l];
            i++;
        }
    }
    public static void merge_sort_size(program_com []prog,int start,int mid,int end)
    {
        program_com [] nw_prog = new program_com[prog.length];
        int i = start, j = mid+1,k=0;
        while (i<=mid && j<=end)
        {
            if (prog[i].bytes_num<prog[j].bytes_num)
            {
                nw_prog[k] = prog[i];
                i++;
            }
            else
            {
                nw_prog[k] = prog[j];
                j++;
            }
            k++;
        }
        while(i<=mid)
        {nw_prog[k] = prog[i];
        i++;
        k++;}
        while (j<=end)
        {
            nw_prog[k] = prog[j];
            j++;
            k++;
        }
        i=start;
        for (int l = 0; l < nw_prog.length; l++) {
            prog[i] = nw_prog[l];
            i++;
        }
    }
    public static void merge_sort_freq(program_com []prog,int start,int mid,int end)
    {
        program_com [] nw_prog = new program_com[prog.length];
        int i = start, j = mid+1,k=0;
        while (i<=mid && j<=end)
        {
            if (prog[i].freq<prog[j].freq)
            {
                nw_prog[k] = prog[i];
                i++;
            }
            else
            {
                nw_prog[k] = prog[j];
                j++;
            }
            k++;
        }
        while(i<=mid)
        {nw_prog[k] = prog[i];
            i++;
            k++;}
        while (j<=end)
        {
            nw_prog[k] = prog[j];
            j++;
            k++;
        }
        i=start;
        for (int l = 0; l < nw_prog.length; l++) {
            prog[i] = nw_prog[l];
            i++;
        }
    }
    public static String longest_sub_str_in_a_row(String str1)
    {
        int [] letters = new int[26];

        String max_str = "" , str_temp = "";
        int max_count = 0, temp_count;
        for (int i = 0; i <str1.length() ; i++) {
            temp_count = 0;
            str_temp = "";
            reset_letters(letters);
            for (int j = i; j < str1.length(); j++) {
                if (letters[str1.charAt(i) - 97] == 0) {
                    letters[str1.charAt(i) - 97]++;
                    temp_count++;
                    str_temp = str_temp + str1.charAt(i);
                } else {
                    break;
                }
            }
            if (max_count < temp_count) {
                max_count = temp_count;
                max_str = str_temp;
            }
        }
        return max_str;
    }
    public static void reset_letters(int [] a)
    {
        for (int i = 0; i <a.length ; i++) {
            a[i] = 0;
        }
    }
    public static int circle_number_game(int[]a)
    {
        int player1 = 0, player2 = 0,index = 0 ;
        int max_index = bigest_val(a);
        player1 = a[max_index];
        int [] a2 = new int[a.length-1];
        int [] [] mat = create_mat(a2);
        for (int i = 0; i <a.length ; i++) {
            if(i!=max_index)
            {
                a2[index] = a[i];
                index++;
            }
        }
        int i=0,j=a.length-1;
        while(i<=j)
        {
            if(a2[i] - mat[i+1][j] > a2[j] - mat[i][j-1])
            {player2 = player2 + a2[i];
                i++;}
            else
            {
                player2 = player2 + a2[j];
                j--;
            }
            if(i>j)
            {
                break;
            }
            else if(i==j)
            {
                player1 = player1 + a2[i];
                i++;
            }
            else
            {
                if(a2[i] - mat[i+1][j] > a2[j] - mat[i][j-1])
                {player1 = player1 + a2[i];
                    i++;}
                else
                {
                    player1 = player1 + a2[j];
                    j--;
                }
            }
        }
        if(player1>player2)
            return player1 - player2;
        else
            return player2 - player1;



    }
    public static int bigest_val(int[]a)
    {
        int max, index ;
        if(a.length == 0)
            return -1;
        if(a.length == 1)
            return 0;
        if(a[0]>a[1])
        {max = a[0];
        index = 0;}
        else
        {max = a[1];
        index = 1;}
        for (int i = 2; i <a.length-1 ; i = i+2) {
            if (a[i] < a[i + 1]) {
                if (max < a[i])
                {max = a[i];
                index = i;}
            } else {
                if (max < a[i + 1])
                {max = a[i + 1];
                index = i+1;}
            }
        }
            if(a.length%2==1)
            {
                if(max<a[a.length-1])
                { max = a[a.length-1];
                index = a.length-1;}
            }
            return index;
    }
    public static int winner_amount(int [] a)
    {
      int [] [] mat = create_mat(a);
      int player1 =0, player2 = 0, i=0,j=a.length-1;
      while(i<=j)
      {
          if(a[i] - mat[i+1][j] > a[j] - mat[i][j-1])
          {player1 = player1 + a[i];
          i++;}
          else
          {
              player1 = player1 + a[j];
              j--;
          }
          if(i>j)
          {
              break;
          }
          else if(i==j)
          {
              player2 = player2 + a[i];
              i++;
          }
          else
          {
              if(a[i] - mat[i+1][j] > a[j] - mat[i][j-1])
              {player2 = player2 + a[i];
                  i++;}
              else
              {
                  player2 = player2 + a[j];
                  j--;
              }
          }
      }
      if(player1>player2)
          return player1 - player2;
      else
          return player2 - player1;
    }

    public static int [] [] create_mat(int [] a)
    {
        int [][] mat = new int[a.length][a.length];
        for (int i = 0; i <a.length ; i++) {
            mat[i][i] = a[i];
        }
        for (int i = 0; i < a.length-1 ; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i]-mat[i+1][j] > a[j] - mat[i][j-1])
                    mat[i][j] = a[i]-mat[i+1][j];
                else
                    mat[i][j] = a[j] - mat[i][j-1];
            }
        }
        return mat;
    }
    public static int cars_in_circle(link_l all_cars)
    {
        int count =1,down = 0;
        node robot = all_cars.head;
        robot.name = 'v';
        robot = robot.next;
        boolean flag = false;
        while(!flag)
        {
            count = 1;
            while(robot.name!='v')
            {
                robot = robot.next;
                count++;
            }
            robot.name ='w';
            for (int i = 0; i <count ; i++) {
                robot = robot.prev;
            }
            if (robot.name == 'w')
                flag = true;
            else
                robot = robot.next;
        }
        return count;
    }
    public static int size_of_circle_and_arm(link_l all_cars)
    {
        int count  = 0;
        if(all_cars.head == null)
            return 0;
        node bun = all_cars.head;
        node tur = all_cars.head;
        bun = bun.next.next;
        tur = tur.next;
        while(bun!=tur)
        {
            tur = tur.next;
            bun = bun.next.next;
        }
        tur = all_cars.head;
        while(tur!=bun)
        {
            tur = tur.next;
            bun = bun.next;
        }
        tur = all_cars.head;
        while(tur!=bun)
        {
            tur = tur.next;
            count++;
        }
        tur = tur.next;
        count++;
        while(tur!= bun)
        {
            tur =tur.next;
            count++;
        }
        return count;
    }
    public static void main(String [] args)
    {

    }
}
