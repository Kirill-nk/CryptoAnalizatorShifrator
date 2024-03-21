import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Key;
import java.util.*;

public class Parsing {
    @SneakyThrows
    public void parse() {
        Util.writeMessage("Введите адрес файла для его расшифровки: ");
        String src = Util.readString();
        Util.writeMessage("Введите адрес файла для набора статистики: ");
        String statisticSrc = Util.readString();

        Path parsing = Util.buildFileName(src, "_parse");

        List<Map.Entry<Character, Integer>> listEncrypted = convertToList(src);
        List<Map.Entry<Character, Integer>> listStatistic = convertToList(statisticSrc);

        if (listEncrypted.size() <= listStatistic.size()) {
            Map<Character, Character> decrypted = new HashMap<>();
            for (int i = 0; i < listEncrypted.size(); i++) {
                decrypted.put(listEncrypted.get(i).getKey(), listStatistic.get(i).getKey());

            }
            try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
                 BufferedWriter writer = Files.newBufferedWriter(parsing);
            ) {
                while (reader.ready()) {
                    String string = reader.readLine();
                    StringBuilder builder = new StringBuilder();
                    for (char aChar : string.toCharArray()) {
                       Character decryptedChar = decrypted.get(aChar);
                       builder.append(decryptedChar);
                    }
                    writer.write(builder.toString());
                    writer.newLine();
                }
            }
            Util.writeMessage("Содержимое файла расшифровано");
        } else {
            Util.writeMessage("Размер файла статистики недостаточен для расшифровки, необходим файл большего размера.");
        }

    }

    @SneakyThrows
    private List<Map.Entry<Character, Integer>> convertToList(String path) {
        Map<Character, Integer> map = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            while (reader.ready()) {
                char aChar = (char) reader.read();
                if (!map.containsKey(aChar)) {
                    map.put(aChar, 1);
                } else {
                    map.put(aChar, map.get(aChar) + 1);
                }
            }
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        return list;
    }
}
