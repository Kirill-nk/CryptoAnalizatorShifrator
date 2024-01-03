import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public static void main(String[] args) throws Exception {
        while (true) {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("""
                    Выберите действие введя его номер\s
                    1. Зашифровать текст из файла\s
                    2. Расшифровать тект из файла\s
                    3. Подобрать ключ к зашифрованному файлу\s
                    4. Расшифровать файл используя синтаксический анализ\s
                    5. Выйти из программы""");
            String answer = input.readLine();
            switch (answer) {
                case "1" -> new Encrypted().encrypted();
                case "2" -> new Decrypted().decrypted();
                case "3" -> System.out.println("3. Подобрать ключ к зашифрованному файлу");
                case "4" -> System.out.println("4. Расшифровать текст из файла");
                case "5" -> {
                    return;
                }
            }
        }
    }
}
