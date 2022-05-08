import java.util.ArrayList;

public class Box <T extends Number> {

    ArrayList<T> listOfElements;

    public Box(ArrayList<T> listOfElements){
        this.listOfElements = listOfElements;
    }

    public void displayArray(){
        for(T element : listOfElements){
            System.out.println(element);
        }
    }

    public void display(Object object){
        // NEturi būti taip -> CastingException
        // String tekstas1 = (String) object;

        // Kaip turi būti
        if(object instanceof String){
            String tekstas = (String) object;
        }
    }
}
