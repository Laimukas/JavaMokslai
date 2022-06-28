package lt.bit.antr;

public class MyLinkedList {

    private Node head;

    public MyLinkedList() {
        this.head = null;
    }

    public void add(Object o) {
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

    public Object get(int index) {
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
        return ret;
    }

    public void set(int index, Object o) {
        int count = -1;
        Node node = this.head;
        while (node != null) {
            count++;
            if (count == index) {
                node.value = o;
            }
            node = node.next;
        }
    }

    public void remove(int index) {

        //------------nepasisekes mano remove metodas----ilsetis reikejo eit
//        int count = -1;
//        Node node = this.head;
//        while (node != null) {
//            count++;
//            if (count == index) {
//                node.value=null;
//            }
//            node = node.next;
//        }
        // ---------cia is MyList metodas REMOVE
        //Object[] newList = new Object[this.list.length - 1];
        //        for (int i = 0, j = 0; i < this.list.length; i++) {
        //            if (i != index) {
        //                newList[j++] = this.list[i];
        //            }
        //        }
        //        this.list = newList;
    }

    public void insert(int index, Object o) {
//        int count = -1;
//        Node node = this.head;
//
//        while (node != null) {
//            count++;
//            if (count == index) {
//                node.value=o;
//            }
//            node = node.next;
//        }
    }

    public int size() {
        int count = 0;
        Node node = this.head;
        while (node != null) {
            count++;
            if (node.next != null) {
            }
            node = node.next;
        }
        return count;
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
        Object value;

        public Node(Object value, Node next) {
            this.next = next;
            this.value = value;
        }
    }
}
