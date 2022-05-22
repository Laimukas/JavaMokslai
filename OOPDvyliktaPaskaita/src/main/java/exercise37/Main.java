package exercise37;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

    private Executor executor;

    public static void main(String[] args) {
        ThreadPlaygroundRunnable threadPlaygroundRunnable = new ThreadPlaygroundRunnable("manoTredas");
        Executors.newFixedThreadPool(2).execute(threadPlaygroundRunnable);
    }
}
