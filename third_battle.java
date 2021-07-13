public class third_battle {
    static class hunter{
        char name;
        double shot_pr;
        boolean d_or_l;
        public hunter(char name, double shot_pr)
        {
            this.d_or_l = true;
            this.name = name;
            this.shot_pr = shot_pr;
        }
    }
    public static char win_the_battle()
    {
        double rand;
        int rand_temp;
        char winner = ' ';
        hunter [] hunters = new hunter[3];
        hunter hunter1,hunter2, hunter3;
        rand = Math.random()*100;
        hunter1 = new hunter('a',rand);
        rand = Math.random()*100;
        hunter2 = new hunter('b',rand);
        rand = Math.random()*100;
        hunter3 = new hunter('c',rand);
        rand_temp = (int)((Math.random()*3) + 1);
        if(rand_temp == 1)
        {
            hunters[0] = hunter1;
            rand_temp = (int)((Math.random()*2) + 1);
            if (rand_temp == 1)
            {hunters[1] = hunter2;
                hunters[2] = hunter3;}
            else
            {
                hunters[1] = hunter3;
                hunters[2] = hunter2;
            }
        }
        else if(rand_temp == 2)
        {
            hunters[0] = hunter2;
            rand_temp = (int)((Math.random()*2) + 1);
            if (rand_temp == 1)
            {hunters[1] = hunter1;
                hunters[2] = hunter3;}
            else
            {
                hunters[1] = hunter3;
                hunters[2] = hunter1;
            }
        }
        else
        {
            hunters[0] = hunter3;
            rand_temp = (int)((Math.random()*2) + 1);
            if (rand_temp == 1)
            {hunters[1] = hunter1;
                hunters[2] = hunter2;}
            else
            {
                hunters[1] = hunter2;
                hunters[2] = hunter1;
            }
        }
        while (players_count(hunters)!= 1)
        {
          if(hunters[0].d_or_l == true)
          {
              if(players_count(hunters) == 2)
              {
                  rand = Math.random()*100;
                  if (rand<hunters[0].shot_pr)
                  {
                      if(hunters[1].d_or_l == true)
                          hunters[1].d_or_l = false;
                      else
                          hunters[2].d_or_l = false;
                  }
              }
              else
              {
                  if(!islower(0,hunters)) {
                      rand = Math.random()*100;
                      if (hunters[0].shot_pr>rand) {
                          if (hunters[1].shot_pr > hunters[2].shot_pr)
                               hunters[1].d_or_l = false;
                          else
                          hunters[2].d_or_l = false;
                      }
                  }
              }
          }
          if(players_count(hunters)==1)
              break;
            if(hunters[1].d_or_l == true)
            {
                if(players_count(hunters) == 2)
                {
                    rand = Math.random()*100;
                    if (rand<hunters[1].shot_pr)
                    {
                        if(hunters[0].d_or_l == true)
                            hunters[0].d_or_l = false;
                        else
                            hunters[2].d_or_l = false;
                    }
                }
                else
                {
                    if(!islower(1,hunters)) {
                        rand = Math.random()*100;
                        if (hunters[1].shot_pr>rand) {
                            if (hunters[0].shot_pr > hunters[2].shot_pr)
                                hunters[0].d_or_l = false;
                            else
                                hunters[2].d_or_l = false;
                        }
                    }
                }
            }
            if(players_count(hunters)==1)
                break;
            if(hunters[2].d_or_l == true)
            {
                if(players_count(hunters) == 2)
                {
                    rand = Math.random()*100;
                    if (rand<hunters[2].shot_pr)
                    {
                        if(hunters[0].d_or_l == true)
                            hunters[0].d_or_l = false;
                        else
                            hunters[1].d_or_l = false;
                    }
                }
                else
                {
                    if(!islower(2,hunters)) {
                        rand = Math.random()*100;
                        if (hunters[2].shot_pr>rand) {
                            if (hunters[0].shot_pr > hunters[1].shot_pr)
                                hunters[0].d_or_l = false;
                            else
                                hunters[1].d_or_l = false;
                        }
                    }
                }
            }
        }
        for (int i = 0; i <3 ; i++) {
            if(hunters[i].d_or_l == true)
            {winner =  hunters[i].name;
            break;}
        }

return winner;
    }
    public static int players_count(hunter [] hunters)
    {
        int count =0;
        for (int i = 0; i <3 ; i++) {
            if(hunters[i].d_or_l == true)
                count ++;
        }
        return count;
    }
    public static boolean islower(int index,hunter [] hunters)
    {
        hunter min = hunters[0];
        int ind = 0;
        for (int i = 1; i < 3; i++) {
            if(hunters[i].shot_pr<min.shot_pr)
            {
                min  = hunters[i];
                ind = i;
            }
        }
        if(ind == index)
            return true;
        else
            return false;
    }


}
