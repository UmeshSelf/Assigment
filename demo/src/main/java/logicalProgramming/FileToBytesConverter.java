package logicalProgramming;

import java.io.IOException;
import java.io.InputStream;

public class FileToBytesConverter {

    private static final String RESOURCE_PATH = "/com/example/demo/dimensionValue100_Upload (4).csv";

    public static byte[] convertFileToBytes() throws IOException {
        try (InputStream inputStream = FileToBytesConverter.class.getResourceAsStream(RESOURCE_PATH)) {
            if (inputStream == null) {
                throw new IOException("File not found in resources: " + RESOURCE_PATH);
            }
            return inputStream.readAllBytes();
        }
    }

    public static void main(String[] args) {
        try {
            byte[] fileBytes = convertFileToBytes();
            System.out.println("File converted to bytes successfully. Byte array length: " + fileBytes.length);
        } catch (IOException e) {
            System.err.println("Error converting file to bytes: " + e.getMessage());
        }
    }
}
