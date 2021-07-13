import java.util.Stack;

public class two_maxs {
    class node{
        int num;
        Stack<Integer> lowers;

        public node(int num)
        {
            this.num = num;
            lowers = new Stack<>();
        }
    }
    public void twomax_max(node[] a)
    {
        two_maxs(a,0,a.length-1);
    }
    public int two_maxs(node [] a,int low,int high)
    {
        if(low<high)
        {
            int i,j,max_index;
            int mid = (low+high)/2;
            i = two_maxs(a,low,mid);
            j = two_maxs(a,mid+1,high);
            if(a[i].num > a[j].num)
            {
                a[i].lowers.add(a[j].num);
                max_index = i;
            }
            else
            {
                a[j].lowers.add(a[i].num);
                max_index = j;
            }
            return max_index;
        }
        else
            return low;
    }

}
