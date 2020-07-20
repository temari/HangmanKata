package de.cas.mse.exercise;

public class Hangman {
    private static final char UNGUESSED_LETTER = '-';

    private final char[] wordToGuessCharrArr;
    private final int wordLength;
    private final boolean[] wordGuessMask;

    public Hangman(String wordToGuess) {
        this.wordToGuessCharrArr = wordToGuess.toCharArray();
        this.wordLength = wordToGuess.length();
        this.wordGuessMask = new boolean[wordLength];
    }

    public String guessLetter(char letter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordLength; i++) {
            wordGuessMask[i] = correctGuessForIndex(i, letter);
            if (wordGuessMask[i]) {
                sb.append(wordToGuessCharrArr[i]);
            } else {
                sb.append(UNGUESSED_LETTER);
            }
        }
        return sb.toString();
    }

    private boolean correctGuessForIndex(int idx, char inputLetter) {
        return wordGuessMask[idx]
                || Character.toLowerCase(wordToGuessCharrArr[idx]) == Character.toLowerCase(inputLetter);
    }

    public boolean wasWordGuessed() {
        for (boolean wasGuessed : wordGuessMask) {
            if (!wasGuessed) {
                return false;
            }
        }
        return true;
    }
}