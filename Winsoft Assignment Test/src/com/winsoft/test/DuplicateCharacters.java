package com.winsoft.test;

import java.util.HashMap;

public class DuplicateCharacters {

	
	
	 public static void main(String[] args) {
	        String str = "Hello, World!";
	        HashMap<Character, Integer> charCountMap = findDuplicateCharacters(str);

	        System.out.println("Duplicate Characters:");
	        for (char ch : charCountMap.keySet()) {
	            if (charCountMap.get(ch) > 1) {
	                System.out.println(ch);
	            }
	        }
	    }

	    public static HashMap<Character, Integer> findDuplicateCharacters(String str) {
	        HashMap<Character, Integer> charCountMap = new HashMap<>();

	        // Convert the string to lowercase to treat uppercase and lowercase characters as same
	        str = str.toLowerCase();

	        // Loop through each character in the string
	        for (char ch : str.toCharArray()) {
	            // Increment the count of the character in the map
	            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
	        }

	        return charCountMap;
	    }
}
