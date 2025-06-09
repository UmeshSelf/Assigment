package logicalProgramming;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileToBytesConverter {

    public static byte[] convertFileToBytes(String resourceFileName) throws IOException {
        try (InputStream inputStream = FileToBytesConverter.class.getClassLoader().getResourceAsStream(resourceFileName)) {
            if (inputStream == null) {
                throw new IOException("File not found in resources: " + resourceFileName);
            }
            return inputStream.readAllBytes();
        }
    }

    public static void main(String[] args) {
        try {
            String resourceFileName = "dimensionValue100_Upload (4).csv"; // File in resources
            byte[] fileBytes = convertFileToBytes(resourceFileName);
            System.out.println("File converted to bytes successfully. Byte array length: " + fileBytes.length);
        } catch (IOException e) {
            System.err.println("Error converting file to bytes: " + e.getMessage());
        }
    }
}