import org.w3c.dom.ls.LSOutput;

import java.io.*;

public class EncryptedDecrypted {
    public void encryptedDecrypted(boolean flag) throws Exception{
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(flag ? "Введите путь к файлу с данными для его зашифровки: " : "Введите путь к файлу для его расшифровки: ");

        String src = scanner.readLine();

        System.out.println("Введите ключ: ");
        int key = Integer.parseInt(scanner.readLine());

        System.out.println(flag ? "Введите путь куда записать зашифрованный текст: " : "Введите путь куда записать расшифрованный текст: ");

        String dest = scanner.readLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
            CaesarCipher caesar = new CaesarCipher();
            while (reader.ready()) {
                String string = reader.readLine();
                String encrypt = caesar.encrypt(string, key);
                String decrypt = caesar.decrypt(string, key);
                String k = flag ? encrypt : decrypt;
                writer.write(k);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

//реализуй через иф элсе, а лучше через тернарный оператор.