package com.leet.string;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int len = 0;
        if (s == null || s.length() == 0) {
            return len;
        }
        boolean charFound = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (!charFound) {
                if (c == ' ') {
                    continue;
                } else {
                    charFound = true;
                    len++;///!!!!!
                }
            } else {
                if (c != ' ') {
                    len++;
                } else {
                    return len;
                }
            }
        }        
        return len;
    }

    public static void main(String[] args) {

        System.out.println(new LengthOfLastWord().lengthOfLastWord(" "));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("     "));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("     i"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("     i "));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("ii "));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("iii iii "));
    }
}