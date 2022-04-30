package lt.bit.task4;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        storage.addToStorage("id1","labas");
        storage.addToStorage("id1","hello");
        storage.addToStorage("id4","hello");
        storage.addToStorage("id2", "hello");
        storage.printValues("id1");
        storage.findValues("hello");
    }
}
