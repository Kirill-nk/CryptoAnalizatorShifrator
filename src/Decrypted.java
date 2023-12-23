import java.io.*;
import java.util.Scanner;

public class Decrypted {

    public void decrypted() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу с данными для его расшифровки: ");
        String src = scanner.nextLine();

        System.out.println("Введите ключ: ");
        int key = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите путь куда записать зашифрованный текст: ");
        String dest = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
            CaesarCipher caesar = new CaesarCipher();
            while (reader.ready()) {
                String string = reader.readLine();
                String decrypt = caesar.decrypt(string, key);
                writer.write(decrypt);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
