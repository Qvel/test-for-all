package tasks.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramsWithMap {
    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return result;
        }

        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sWindowMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            sWindowMap.put(currentChar, sWindowMap.getOrDefault(currentChar, 0) + 1);

            if (i >= p.length()) {
                char charToRemove = s.charAt(i - p.length());
                sWindowMap.put(charToRemove, sWindowMap.get(charToRemove) - 1);
                if (sWindowMap.get(charToRemove) == 0) {
                    sWindowMap.remove(charToRemove);
                }
            }

            if (pMap.equals(sWindowMap)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

}
