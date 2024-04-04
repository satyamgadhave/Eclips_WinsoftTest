package com.winsoft.test;

import java.util.HashMap;

public class WordCount {

	public static void main(String[] args) {
        String str = "Hello world, this is a sample string for word count program. Hello world!";
        HashMap<String, Integer> wordCountMap = countWords(str);
        
        System.out.println("Word Counts:");
        for (String word : wordCountMap.keySet()) {
            System.out.println(word + " : " + wordCountMap.get(word));
        }
    }
    
    public static HashMap<String, Integer> countWords(String str) {
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        
        String[] words = str.split("\\s+"); // Split the string by whitespace
        for (String word : words) {
            // Remove punctuation marks from the word
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!word.isEmpty()) {
                // Update the word count in the map
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }
        
        return wordCountMap;
    }
}
