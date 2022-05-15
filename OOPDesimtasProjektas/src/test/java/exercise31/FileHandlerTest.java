package exercise31;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FileHandlerTest {

   @Test
    void testFileProcess() throws IOException{
       FileHandler fileHandler = new FileHandler();
       File input = new File("src/main/resources/textfile.txt");
       File output = new File("src/main/resources/output.txt");
       File expected = new File("src/test/resources/expected.txt");
       fileHandler.processFile(input);
       assertTrue(FileUtils.contentEquals(expected,output));
   }

}
