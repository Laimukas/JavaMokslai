package exercise31;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileHandler {

    public void processFile(File file) throws IOException{
    Scanner input = new Scanner(file);
    ArrayList<String> zodziai = new ArrayList<>();
        while (input.hasNext()) {
        zodziai.add(input.next());

    }

        input.close();
    HashMap<String, Integer> map = new HashMap<>();


        for (int i = 0; i < zodziai.size(); i++) {
        int counter = 1;
        String zodis = zodziai.get(i);
        for (int j = i + 1; j < zodziai.size(); j++) {
            if (zodis.equals(zodziai.get(j))) {
                counter++;
            }
        }
        map.putIfAbsent(zodis, counter);
    }
    writeToFile(map);


}

    private static void writeToFile(HashMap<String, Integer> map) throws IOException {
        File file = new File("src/main/resources/output.txt");
        if (file.createNewFile()) {
            FileWriter myWriter = new FileWriter(file);


            map.forEach((k, v) -> {
                try {
                    myWriter.write("zodis: " + k + " , skaicius: " + v + "\n");
                } catch (IOException e) {
                    System.out.println("Nesugebejome irasyti i file, nes : " + e.getMessage());
                }
            });
            myWriter.close();
        } else {
            System.out.println("Ivyko klaida, nepavyko sukurti file!");
        }
    }

}
