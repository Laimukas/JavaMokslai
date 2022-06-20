package lt.bit.exercise.penkt;

public class MyList {

    private Object[] list;

    public MyList() {
        this.list = new Object[0];
    }

    public void add(Object o) {
        Object[] newList = new Object[this.list.length + 1];
        for (int i = 0; i < this.list.length; i++) {
            newList[i] = this.list[i];
        }
        newList[newList.length - 1] = o;
        this.list = newList;
    }

    public Object get(int i) {
        return this.list[i];
    }

    public void set(int i, Object o) {
        this.list[i] = o;
    }

    public void remove(int j) {
        Object[] newList = new Object[this.list.length-1];
        for (int i = 0; i < this.list.length-1; i++) {

            if (i<j){
                newList[i] = this.list[i];
            }else {
                newList[i] = this.list[i+1];
            }
        }
        this.list = newList;
    }

    public void insert(int j, Object o) {
        Object[] newList = new Object[this.list.length + 1];
        for (int i = 0; i <= this.list.length; i++) {
            if (i < j) {
                newList[i] = this.list[i];
            } else if (i > j) {
                newList[i] = this.list[i - 1];
            } else {
                newList[i] = o;
            }
        }

        this.list = newList;
    }

    // destytojo Aliaus budas
//    public void remove(int index) {
//        Object[] newList = new Object[this.list.length - 1];
//        for (int i = 0, j = 0; i < this.list.length; i++) {
//            if (i != index) {
//                newList[j++] = this.list[i];
//            }
//        }
//        this.list = newList;
//    }
//    public void insert(int index, Object o) {
//        Object[] newList = new Object[this.list.length + 1];
//        for (int i = 0, j = 0; i < newList.length; i++) {
//            if (i == index) {
//                newList[i] = o;
//            } else {
//                newList[i] = this.list[j++];
//            }
//        }
//        this.list = newList;
//    }

    public int size() {
        return this.list.length;
    }

    public String toString() {
        String ret = "[";
        for (int i = 0; i < this.list.length; i++) {
            ret += this.list[i];
            if (i < this.list.length - 1) {
                ret += ", ";
            }
        }
        ret += "]";
        return ret;
    }
}

/*
add(Object o) - prideda nauja elementa i saraso pabaiga
get(int i) - grazina i-ji saraso elementa
set(int i, Object o) - i i-ja vieta padeda nauja reiksme
remove(int i) - istrina i-ji elementa is saraso
insert(int i, Object o) - i i-ja vieta iterpia nauja elementa
size() - grazina elementu kieki sarase
toString() - grazina stringa, kur isvardinti visi elementai
    pvz: [labas, pasauli, !]
*/

