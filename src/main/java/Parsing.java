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
    public void parse() {

        Util.writeMessage("Введите адрес файла для его расшифровки: ");
        String src = Util.readString();
        Util.writeMessage("Введите адрес файла для набора статистики: ");
        String statisticSrc = Util.readString();

        List<Map.Entry<Character, Integer>> listEncrypted = convertToList(src);
        List<Map.Entry<Character, Integer>> listStatistic = convertToList(statisticSrc);

        Map<Character, Character> decrypted = new HashMap<>();
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
