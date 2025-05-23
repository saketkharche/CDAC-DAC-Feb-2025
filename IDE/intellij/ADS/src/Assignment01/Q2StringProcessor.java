package Assignment01;
import java.util.Arrays;

public class Q2StringProcessor {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        String sentence = "Practice makes a man perfect";

        // Check if the strings are anagrams
        boolean isAnagram = checkAnagram(str1, str2);
        System.out.println("Are '" + str1 + "' and '" + str2 + "' anagrams? " + isAnagram);

        // Find the longest word in the sentence
        String longestWord = findLongestWord(sentence);
        System.out.println("Longest word: " + longestWord);

        // Count vowels and consonants in the sentence
        int[] counts = countVowelsAndConsonants(sentence);
        System.out.println("Vowels: " + counts[0] + ", Consonants: " + counts[1]);
    }

    // Function to check if two strings are anagrams
    public static boolean checkAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    // Function to find the longest word in a sentence
    public static String findLongestWord(String sentence) {
        String[] words = sentence.split(" ");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    // Function to count vowels and consonants in a sentence
    public static int[] countVowelsAndConsonants(String sentence) {
        int vowels = 0, consonants = 0;
        String lowerSentence = sentence.toLowerCase();

        for (char ch : lowerSentence.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        return new int[]{vowels, consonants};
    }
}
