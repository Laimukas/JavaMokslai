package exercise30;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        File dir = new File("src/main/resources");
        Collection<File> files = FileUtils.listFiles(dir, null, true);
        files.forEach(f -> {
            try {
                String filename = f.getName();
                String fileNameWithoutExtention = filename.substring(0, filename.indexOf('.') - 1);
                String extention = filename.substring(filename.indexOf('.'));

                FileUtils.writeStringToFile(new File(getReversedString(fileNameWithoutExtention) + extention),
                        getReversedString(FileUtils.readFileToString(f, StandardCharsets.UTF_8)),
                        StandardCharsets.UTF_8);

            } catch (IOException e) {
                System.out.println("Failed to read from the file");
            }
        });
    }

    public static String getReversedString(String obj) {
        char[] chars = obj.toCharArray();
        String reversedObj = "";

        for (int i = chars.length - 1; i >= 0; i--) {
            reversedObj += chars[i];
        }
        return reversedObj;
    }
}
