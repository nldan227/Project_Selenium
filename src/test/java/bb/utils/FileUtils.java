package bb.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.UUID;

public class FileUtils {

    public static File createRandomTextFile() {
        try {
            String randomText = "Auto text: " + UUID.randomUUID();

            File file = new File("target/random-file-" + System.currentTimeMillis() + ".txt");
            FileWriter writer = new FileWriter(file);
            writer.write(randomText);
            writer.close();

            return file;
        } catch (Exception e) {
            throw new RuntimeException("Cannot create random file", e);
        }
    }
}
