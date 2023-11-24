public class CaesarCipher {
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Мы делаем то-то и то-то
     *
     * @param message
     * @param key
     * @return
     */

    public String encrypt(String message, int key) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char symbol = message.charAt(i);
            int index = alphabet.indexOf(symbol);
            if (index >= 0) {
                int newIndex = (index + key) % alphabet.length();
/*                char charAt = 0;
                if (newIndex < 0) {
                    charAt = alphabet.charAt(newIndex+alphabet.length());
                } else {
                    charAt = alphabet.charAt(newIndex);
                }
                charAt = newIndex < 0 ? alphabet.charAt(newIndex+alphabet.length()) : alphabet.charAt(newIndex); //Вариант 2
                charAt = alphabet.charAt(newIndex < 0 ? newIndex+alphabet.length() : newIndex); // Вариант 3
*/
                char charAt = alphabet.charAt(newIndex + (newIndex < 0 ? alphabet.length() : 0)); //Вариант 4
                builder.append(charAt); //билдер это строка которая может меняться, а обычная строка не может меняться, билдер - мутабельный.
            }
        }
        return builder.toString();
    }

    public String decrypt(String message, int key) {
        return encrypt(message, key * -1);
    }

    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher();
        String encrypt = caesarCipher.encrypt("privet", 3);

        System.out.println(encrypt);

        String decrypt = caesarCipher.decrypt(encrypt, 3);
        System.out.println(decrypt);
    }
}


