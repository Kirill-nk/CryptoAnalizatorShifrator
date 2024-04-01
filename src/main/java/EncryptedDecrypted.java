import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class EncryptedDecrypted {

    @SneakyThrows
    public void encryptedDecrypted(boolean flag) {
        Util.writeMessage(flag ? "Введите путь к файлу с данными для его зашифровки: " : "Введите путь к файлу для его расшифровки: ");

        String src = Util.readString();

        Util.writeMessage("Введите ключ: ");
        int key = Util.readInt();

        Path dest = Util.buildFileName(src, flag ? "_encrypted" : "_decrypted");

        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = Files.newBufferedWriter(dest)) {
            CaesarCipher caesar = new CaesarCipher();
            while (reader.ready()) {
                String string = reader.readLine();
                String encrypt = caesar.encrypt(string, key);
                String decrypt = caesar.decrypt(string, key);
                String k = flag ? encrypt : decrypt;
                writer.write(k);
                writer.newLine();
            }
        }
    }
}