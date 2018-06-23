package ru.manpower;

import java.util.*;

public class TextAnalizer {
    public static void main(String[] args) {
        String text = "Our Tanya is crying loudly. Our Tanya is nice.";
        analize(text);
    }

    private static void analize(String text) {
        List<String> wordsInTextRepetitive = getWordsFromText(text);
        Map<String, Integer> countWords = countWords(wordsInTextRepetitive);

        for(Map.Entry<String, Integer> entry : countWords.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static List<String> getWordsFromText(String text) {
        List<String> words = new ArrayList<>();
        String wordsInText = removePunctuationMarks(text);
        String[] wordsArray = wordsInText.split(" ");
        words = Arrays.asList(wordsArray);
        return words;
    }

    private static String removePunctuationMarks(String text) {
        String resultText = text.replaceAll("[^\\w]", " ").replaceAll("  ", " ");
        return resultText;
    }

    private static Map<String, Integer> countWords(List<String> wordsInTextRepetitive) {
        Map<String, Integer> countWordsUnsortedMap = new HashMap<>();
        for(String word: wordsInTextRepetitive) {
            if(countWordsUnsortedMap.containsKey(word)) {
                int count = countWordsUnsortedMap.get(word);
                countWordsUnsortedMap.put(word, (count+1));
            } else {
                countWordsUnsortedMap.put(word, 1);
            }
        }
        ValueComparator comparator = new ValueComparator(countWordsUnsortedMap);
        Map<String, Integer> countWordsSorted = new TreeMap<String, Integer>(comparator);
        countWordsSorted.putAll(countWordsUnsortedMap);
        return countWordsSorted;
    }

    static class ValueComparator implements Comparator<String> {
        Map<String, Integer> base;

        public ValueComparator(Map<String, Integer> base) {
            this.base = base;
        }

        @Override
        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
