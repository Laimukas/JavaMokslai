package exercise31;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.processFile(new File("src/main/resources/textfile.txt"));
    }

}
