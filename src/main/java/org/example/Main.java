package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.hasNextLine() ? input.nextLine() : "";
        System.out.println(TestWordAutomaton.recognize(line));
    }
}
