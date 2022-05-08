public class Element {

    public static <T> void display(T element){
        System.out.println(element.getClass().getName());
    }

    public static <T> void displayArray(T [] elementArray){
        for(T element : elementArray){
            System.out.println(element);
        }
    }
}
