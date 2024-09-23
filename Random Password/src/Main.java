import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*
Реализовать программу для генерации паролей пользователей.
Программа должна формировать случайную последовательность символов
длины L, при этом должен использоваться алфавит из A символов.
Составить частотный словарь вхождения символов алфавита в парольную
фразу.
 */
public class Main {
    public static void main(String[] args) {
        String A = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_+";
        char[] AA = A.toCharArray();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Длинна пароля: ");
        int L = scanner.nextInt();

        Random rand = new Random();

        StringBuilder passwd = new StringBuilder();

        boolean[] used = new boolean[AA.length];

        for (int i = 0; i < L; i++) {
            if (L > A.length()) {
                System.out.println("Ошибка длинны");
                break;
            } else {
                int index;

                // Генерация уникального символа, который ещё не использован
                do {
                    index = rand.nextInt(AA.length);
                } while (used[index]); // Повторяем, если символ уже использован

                passwd.append(AA[index]);
                used[index] = true; // Отмечаем символ как использованный
            }
        }

        String password = passwd.toString();
        System.out.println("Сгенерированный пароль: " + passwd);

        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : password.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Вывод частотного словаря
        System.out.println("Частотный словарь вхождений символов:");
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("Символ: '" + entry.getKey() + "' - Частота: " + entry.getValue());
        }
    }
}