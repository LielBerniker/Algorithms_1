public class roud_and_then_circle {
    class Node {

        char value;
        Node nextNode, prevnode;

        public Node(char value, Node temp, Node temp2) {
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
    public int size_of_road(all_pass road)
    {
        Node tur = road.head;
        Node bun = road.head;
        Node meet;
        int counter = 0;
        tur = tur.nextNode;
        bun = bun.nextNode.nextNode;
        while(bun.value!= tur.value)
        {
            bun = bun.nextNode.nextNode;
            tur =tur.nextNode;
        }
        meet = tur;
        tur = meet;
        bun = road.head;
        while(tur.value!= bun.value)
        {
            tur = tur.nextNode;
            bun = bun.nextNode;
        }
        meet = tur;
        tur = road.head;

        while(tur.value != meet.value)
        {
            counter++;
            tur = tur.nextNode;
        }
        return counter;
    }

}
