import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class BruteForce {
    private static final int MAX_LENGTH_WORD = 28;

    @SneakyThrows //подавляет checked Exeption в unchecked
    public void bruteForce() {
        Util.writeMessage("Введите адрес к файлу для его расшифровки: ");
        String src = Util.readString();
        Path dest = Util.buildFileName(src, "_bruteForce");

        try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
             BufferedWriter writer = Files.newBufferedWriter(dest)) {
            StringBuilder builder = new StringBuilder();
            List<String> list = new ArrayList<>();
            CaesarCipher caesarCipher = new CaesarCipher();
            while (reader.ready()) {
                String string = reader.readLine();
                builder.append(string);
                list.add(string);
            }
            for (int i = 0; i < caesarCipher.alphabetLength(); i++) {
                String string = caesarCipher.decrypt(builder.toString(), i);
                if (isValidate(string)) {
                    for (String str : list) {
                       String decrypt = caesarCipher.decrypt(str, i);
                       writer.write(decrypt);
                       writer.newLine();
                    }
                    Util.writeMessage("Содержимое расшифровано, ключ расшифровки равен " + i);
                    break;
                }
            }
        }
    }

    public boolean isValidate(String text) {

        for (String word : text.split(" ")) {
            if (word.length() > MAX_LENGTH_WORD) {
                return false;
            }
        }
        boolean isValidate = false;
        if (text.contains(". ") || text.contains(", ") || text.contains("? ") || text.contains("! ")) {
            isValidate = true;
        }
        while (isValidate) {
            Util.writeMessage(text/*лимитировать для удобочитаемости, то есть написать допусловие вывода*/);
            Util.writeMessage("Корректно ли расшифрован текст: да/нет?");
            String answer = Util.readString();
            if (answer.equalsIgnoreCase("да")) {
                return true;
            } else if (answer.equalsIgnoreCase("нет")) {
                isValidate = false;
            } else {
                Util.writeMessage("Вы ввели некорректный текст");
            }
        }
        return false;
    }
}

/*ДЗ от 27.01.2024
1. написать метод из Валидейт done
2. проверить что текст имеет размерность не мение 28 символов, предварительно поделить текст по пробелу, done
4. проверить что в тексте есть патерны одного из следующих вариантов ". " ", " "? " "! " done
5. и спросить у пользователя правильно ли расшифровано done
6. Протестировать работоспособность, найти ошибки и исправить их. done

ДЗ от 02.02.2023 -
7.  сообщения куском, лимит например на строки или символы - неважно. - Сделать!!!
 */