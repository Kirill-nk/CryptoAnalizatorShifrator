import java.io.*;
import java.util.Scanner;

public class Encrypted {
    public void encrypted() throws Exception{
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к файлу с данными для его зашифровки: ");
        String src = scanner.readLine();

        System.out.println("Введите ключ: ");
        int key = Integer.parseInt(scanner.readLine());

        System.out.println("Введите путь куда записать зашифрованный текст: ");
        String dest = scanner.readLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(src));
        BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
            CaesarCipher caesar = new CaesarCipher();
            while (reader.ready()) {
                String string = reader.readLine();
                String encrypt = caesar.encrypt(string, key);
                writer.write(encrypt);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
//Реализовать класс decrypted, который расшифровывает по аналогии с декриптед.
//Это новый класс = новый файл. 99% совпадает.
//Подумать как объединить два класса енкриптед и декриптед в один, для того чтобы убрать избыточность

//К 04.01.2024
//1. Найти почему пропадают переносы строк и отсутствует форматирование. Взять 3-5 строк и проверить куда делись переносы строк.
//2. Подумать как объединить два класса енкриптед и декриптед в один, для того чтобы убрать избыточность. (Задача со звездочкой).