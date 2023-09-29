package tasks.leetcode;

import java.util.HashSet;
import java.util.Set;

public class PeriodicSpelling {
    private static final Set<String> tableSymbols = new HashSet<String>() {{
        add("h");
        add("he");
        add("li");
        // ... Add all symbols
    }};

    public static boolean canBeSpelled(String word) {
        if (word.isEmpty()) {
            return true;
        }

        for (int i = 1; i <= word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (tableSymbols.contains(prefix.toLowerCase()) && canBeSpelled(suffix)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canBeSpelled("feline"));  // true
        System.out.println(canBeSpelled("began"));   // true
        System.out.println(canBeSpelled("physics")); // true, assuming all letters are valid symbols.


        // with memo
        Set<String> memo = new HashSet<>();
        System.out.println(canBeSpelled("feline", memo));  // true
        System.out.println(canBeSpelled("began", memo));   // true
        System.out.println(canBeSpelled("physics", memo)); // true, assuming all letters are valid symbols.
    }

    //with memo
    public static boolean canBeSpelled(String word, Set<String> memo) {
        if (word.isEmpty()) {
            return true;
        }

        if (memo.contains(word)) {
            return false;
        }

        for (int i = 1; i <= word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (tableSymbols.contains(prefix.toLowerCase()) && canBeSpelled(suffix, memo)) {
                return true;
            }
        }

        memo.add(word);
        return false;
    }
}
