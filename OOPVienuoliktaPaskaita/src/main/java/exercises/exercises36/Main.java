package exercises.exercises36;

public class Main {

    private static Thread firstThread;
    private static Thread secondThread;

    public static void main(String[] args) {
        firstThread = new Thread(new ThreadPlaygroundRunnable("ManoTredas1"));
        secondThread = new Thread(new ThreadPlaygroundRunnable("ManoTredas2"));

        firstThread.start();
        secondThread.start();
    }
}
