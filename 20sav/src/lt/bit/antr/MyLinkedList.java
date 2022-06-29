package lt.bit.antr;

public class MyLinkedList<E> {

    private Node head;

    public MyLinkedList() {
        this.head = null;
    }

    public void add(E o) {
        Node node = new Node(o, null);
        if (this.head == null) {
            this.head = node;
        } else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
        }
    }

    public E get(int index) {
        String ret = "";
        int count = -1;
        Node node = this.head;
        while (node != null) {
            count++;
            if (count == index) {
                ret += node.value;
            }
            node = node.next;
        }
        return (E) ret;

        // destytojo budas

//        int i = 0;
//        Node node = this.head;
//        while (node != null) {
//            if (i == index) {
//                return node.value;
//            }
//            i++;
//            node = node.next;
//        }
//        return null;
    }

    public void set(int index, E o) {
        int count = 0;
        Node node = this.head;
        while (node != null) {
            if (count == index) {
                node.value = o;
            }
            count++;
            node = node.next;
        }

        //destytojo budas

//        int i = 0;
//        Node node = this.head;
//        while (node != null) {
//            if (i == index) {
//                node.value = o;
//                break;
//            }
//            i++;
//            node = node.next;
//        }
    }

    public void remove(int index) {
        if (index == 0) {
            head=head==null?null:head.next;
        } else {
            int count = 0;
            Node node = this.head;
            while (node != null) {
                if (count == index - 1) {
                    node.next = node.next.next;
                    break;
                }
                count++;
                node = node.next;
            }
        }
    }

    public void insert(int index, E o) {
        if (index == 0) {
            Node naujas = new Node(o, head);
         head=naujas;
        } else {
            int count = 0;
            Node node = this.head;
            while (node != null) {
                if (count == index - 1) {
                    Node naujas = new Node(o, node.next);
                    node.next = naujas;
                    break;
                }
                count++;
                node = node.next;
            }
        }
    }

    public int size() {
        int count = 0;
        Node node = this.head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;

        //destytojo budas
//        int i = 0;
//        Node node = this.head;
//        while (node != null) {
//            i++;
//            node = node.next;
//        }
//        return i;
    }

    public String toString() {
        String ret = "[";
        Node node = this.head;
        while (node != null) {
            ret += node.value;
            if (node.next != null) {
                ret += ", ";
            }
            node = node.next;
        }

        //komandinis varijantas
//        if (this.head != null) { //sitas sako visai nereikalingas
//            Node node = this.head;
//            while (node.next != null) {
//                ret += node.value + ", ";
//                node = node.next;
//            }
//            ret += node.value;
//        }
        ret += "]";
        return ret;
    }


    private class Node {
        Node next;
        E value;

        public Node(E value, Node next) {
            this.next = next;
            this.value = value;
        }
    }
}
