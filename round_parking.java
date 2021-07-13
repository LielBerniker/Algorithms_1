import java.util.LinkedList;

public class round_parking {
    class Node {

        char value;
        Node nextNode, prevnode;

        public Node(char value, Node temp, Node temp2) {
            this.value = value;
            this.nextNode = temp;
            this.prevnode = temp2;
        }
    }

    class all_cars {
        Node head, last;

        public all_cars() {
            this.head = null;
            this.last = null;
        }

    }

    public int find_car_amount(all_cars cars) {
        Node temp = cars.head;
        temp.value = 'v';
        temp = temp.nextNode;
        int counter = 1;
        boolean flag = false;
        while (flag == false) {
            if (temp.value == 'v') {
                int i = counter;
                temp.value = 'w';
                while (i > 0) {
                    temp = temp.prevnode;
                    i--;
                }
                if (temp.value == 'w')
                    return counter;
                else
                    counter = 1;
                temp = temp.nextNode;
            } else {
                temp = temp.nextNode;
                counter++;
            }
        }
        return counter;
    }
}


