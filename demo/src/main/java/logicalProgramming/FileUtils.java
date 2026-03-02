package logicalProgramming;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class FileUtils {

    public static byte[] convertResourceToByteArray(String resourcePath) throws IOException {
        try (InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new IOException("Resource not found on classpath: " + resourcePath);
            }
            return inputStream.readAllBytes();
        }
    }

    public static void main(String[] args) throws IOException {
        // Resource is located at src/main/resources/com/example/demo/dimensionValue100_Upload (4).csv
        byte[] fileBytes = convertResourceToByteArray("com/example/demo/dimensionValue100_Upload (4).csv");

        String base64String = Base64.getEncoder().encodeToString(fileBytes);
        System.out.println("**" + base64String);
    }
}
