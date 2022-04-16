package lt.bit.first.example;

public interface NoiseImplementation {
    //Pagal nutylejima -> public static final
    String TIPAS="Zinduoliai";

    //Pagal nutylejima tai yra -> public abstract
    void makeNoise();

    void makeBiggerNoise();

    default void sayGreetings (){
        System.out.println("Hi there, human!");
    }

    static void layDown(){
        System.out.println("Laying down");
        waitCommand();
    }
//si metoda galima issaukti tik clases viduje esantiems metodams
    private static void waitCommand(){
        System.out.println("Waiting command.");
    }

}
