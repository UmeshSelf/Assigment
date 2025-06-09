package logicalProgramming;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class FileUtils {



        public static byte[] convertFileToByteArray(String filePath) throws IOException {
        File file = new File(filePath);
        return Files.readAllBytes(file.toPath());
    }
        public static void main(String[] args) throws IOException {
        byte[] fileBytes = convertFileToByteArray("/demo/src/main/resources/com/example/demo/dimensionValue100_Upload (4).csv");


//      // Encode byte array to Base64 string
       String base64String = Base64.getEncoder().encodeToString(fileBytes);
       
       System.out.println("**"+base64String);
        }
}