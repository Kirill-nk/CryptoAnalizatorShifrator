import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

public class Decrypted {
    public void decrypted() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу с данными для его зашифровки: ");
        String src = scanner.nextLine();

        System.out.println("Введите ключ: ");
        int key = scanner.nextInt();

        System.out.println("Введите путь куда записать зашифрованный текст: ");
        String dest = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(src))
        {

        }



    }
}
