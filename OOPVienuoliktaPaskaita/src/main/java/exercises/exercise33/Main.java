package exercises.exercise33;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        String[] extensions = { ".png", ".jpg"};
        File direktorija = new File("C:/....");
        Collection<File> files = FileUtils.listFiles(direktorija, extensions, true);
        files.forEach(f -> System.out.println(f.getName()));
    }
}
