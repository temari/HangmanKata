package de.cas.mse.exercise;

import java.util.Scanner;

public class HangmanConsole {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a word to be guessed:");
        String wordToGuess = sc.next();
        Hangman hangman = new Hangman(wordToGuess);
        while(!hangman.wasWordGuessed())
        {
        	System.out.println("Please enter the next letter:");
            String guessLetter = sc.next();
            String guessResult = hangman.guessLetter(guessLetter.charAt(0));
            System.out.println(guessResult);
        }
        System.out.println("CONGRATS!!!");
        sc.close();
        System.exit(1);
    }

}