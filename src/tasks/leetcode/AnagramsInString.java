package tasks.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramsInString {

    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        // Якщо вхідні рядки пусті, повертаємо пустий список
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return result;

        int[] pCount = new int[26]; // масив для підрахунку символів у рядку p
        int[] sCount = new int[26]; // масив для підрахунку символів у рядку s

        // підрахунок символів у рядку p
        for (char c : p.toCharArray()) {
            /*
            c - 'a': Віднімаємо ASCII код символу 'a' від ASCII коду поточного символу c.
            Це дасть нам індекс від 0 до 25, який відповідає літерам a-z відповідно.

            В комп'ютерах кожен символ має відповідний числовий код. Для англійських символів ці коди визначені стандартом ASCII.
             Наприклад, у стандарті ASCII символ 'a' має код 97, символ 'b' має код 98, і так далі.

            Отже, коли ми беремо символ c і віднімаємо від нього 'a', ми фактично віднімаємо їх ASCII коди. Розглянемо приклад:

            Якщо c = 'a', тоді c - 'a' = 97 - 97 = 0.
            Якщо c = 'b', тоді c - 'a' = 98 - 97 = 1.
            Якщо c = 'c', тоді c - 'a' = 99 - 97 = 2.
             */
            pCount[c - 'a']++;
        }

        // рухоме вікно по рядку s
        for (int i = 0; i < s.length(); i++) {
            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;  // видаляємо символ зліва від вікна
            }
            sCount[s.charAt(i) - 'a']++;  // додаємо новий символ до вікна
            // якщо поточне вікно відповідає рядку p, додаємо початковий індекс до результату
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
