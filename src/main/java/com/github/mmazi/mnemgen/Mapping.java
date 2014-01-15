package com.github.mmazi.mnemgen;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Mapping {

    private static final Multimap<Integer, String> map = TreeMultimap.create();
    private static final Map<Character, Integer> charMap = new HashMap<>();

    static {
        charMap.put('c', 0);
        charMap.put('s', 0);
        charMap.put('z', 0);
        charMap.put('t', 1);
        charMap.put('d', 1);
        charMap.put('n', 2);
        charMap.put('m', 3);
        charMap.put('r', 4);
        charMap.put('l', 5);
        charMap.put('š', 6);
        charMap.put('č', 6);
        charMap.put('ž', 6);
        charMap.put('k', 7);
        charMap.put('g', 7);
        charMap.put('q', 7);
        charMap.put('f', 8);
        charMap.put('v', 8);
        charMap.put('p', 9);
        charMap.put('b', 9);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Mapping.class.getResourceAsStream("/words.txt")))) {
            String word;
            while ((word = reader.readLine()) != null) {
                map.put(toNumber(word), word);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Integer toNumber(String word) {
        int n = 0;
        for (char c : word.toCharArray()) {
            c = Character.toLowerCase(c);
            if (charMap.containsKey(c)) {
                n *= 10;
                n += charMap.get(c);
            }
        }
        return n;
    }

    public static Collection<String> getWordsForNumber(int n) {
        return map.get(n);
    }
}
