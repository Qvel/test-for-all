package tasks.string;

/*
Короч є рядок - "abcabcab" і є шаблон "bc", потрібно було по шаблону ревертнути літери в рядку
тобто якщо шаблон - "bc", то на виході потрібно отримати "acbacbab"
 */
/*
    //StringBuilder vs StringBuffer vs String

        /*
                     StringBuffer vs StringBuilder
        Thread Safe       +               -
        synchronized      +               -
        slower            +               -
        faster            -               +
                    Since Java 1.0   Since Java 1.5

         Навіщо ці класи ?
         так як String immutable in Java, то зробили допоміжні класи які змінюють / маніпулюють зі String
         і звичайно мають купу своїх методів для цього
     */
public class RevertString {
    public static void main(String[] args) {
        String input = "abcabcab";
        String pattern = "bc";
        System.out.println(replace(input, pattern));
    }

    private static String replace(String input, String pattern) {
        StringBuilder stringBuilder = new StringBuilder(pattern);
        return input.replaceAll(pattern,stringBuilder.reverse().toString());
    }

    private static String replaceBetter(String input, String pattern) {
        StringBuilder result = new StringBuilder();
        StringBuilder reversedPattern = new StringBuilder(pattern).reverse();

        int lastEnd = 0;
        int index = input.indexOf(pattern);

        while (index != -1) {
            result.append(input, lastEnd, index);  // додаємо частину рядка до знаходження шаблону
            result.append(reversedPattern);  // додаємо реверсований шаблон

            lastEnd = index + pattern.length();
            index = input.indexOf(pattern, lastEnd);  // шукаємо наступне входження шаблону
        }

        result.append(input.substring(lastEnd));  // додаємо залишок рядка
        return result.toString();
    }
}
