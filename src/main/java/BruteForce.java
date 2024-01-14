import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;


public class BruteForce {
@SneakyThrows //подавляет checked Exeption в unchecked
    public void bruteForce() {
        Util.writeMessage("Введите адрес к файлу для его расшифровки: ");
        String src = Util.readString();
        Path dest = Util.buildFileName(src, "_bruteForce");

        try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
             BufferedWriter writer = Files.newBufferedWriter(dest)) {

        }
    }
}
