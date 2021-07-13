public class round_roud {
    class Node {

        char value;
        Node nextNode, prevnode;

        public Node(char value,Node temp, Node temp2) {
            this.value = value;
            this.nextNode = temp;
            this.prevnode = temp2;
        }
    }

    class all_pass {
       Node head, last;

        public all_pass() {
            this.head = null;
            this.last = null;
        }

    }
    public boolean find_round_roud(all_pass pass)
    {
        Node tur = pass.head;
        Node bun = pass.head;
        while(tur.nextNode != null && bun.nextNode != null && bun.nextNode.nextNode != null)
        {
            tur = tur.nextNode;
            bun = bun.nextNode.nextNode;
            if (tur.value == bun.value)
                return true;
        }
        return false;
    }
}
