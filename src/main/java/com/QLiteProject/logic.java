package com.QLiteProject;

import java.util.*;

public class logic {
    public void initialization() {
        print("Enter text: ");
        String string = read();
        if (string.isEmpty()) {
            print("The text is not recognized ... The procedure is restarted.", true);
            initialization();
        } else {
            print("Output: " + replace(string), true);
            print("Press any key to exit ...");
            read();
        }
    }

    private String replace(String origin) {
        Map<Character, ArrayList<Integer>> buffer = new TreeMap<>();
        char[] chars = new char[origin.length()];
        origin = origin.toLowerCase();

        for(int i = 0; i < origin.length(); i++) {
            char key = origin.charAt(i);
            if(!buffer.containsKey(key)) buffer.put(key, new ArrayList<>());
            buffer.get(key).add(i);
        }

        for (char key : buffer.keySet()) {
            ArrayList<Integer> positions = buffer.get(key);
            char symbol = positions.size() > 1 ? ')' : '(';
            for (int position : positions) {
                chars[position] = symbol;
            }
        }

        return new String(chars);
    }

    private String read() {
        Scanner reader = new Scanner(System.in, "UTF-8");
        return reader.nextLine();
    }

    private void print(String message) {
        print(message, false);
    }

    private void print(String message, boolean enter) {
        if (enter) System.out.println(message); else System.out.print(message);
    }
}
