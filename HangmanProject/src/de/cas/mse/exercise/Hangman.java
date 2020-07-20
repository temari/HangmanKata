package de.cas.mse.exercise;

public class Hangman {
    private static final char UNGUESSED_SYMBOL = '-';

    private final char[] wordToGuessCharrArr;
    private final boolean[] wordGuessMask;
    private final int wordLength;

    public Hangman(String wordToGuess) {
        this.wordToGuessCharrArr = wordToGuess.toCharArray();
        this.wordLength = wordToGuess.length();
        this.wordGuessMask = new boolean[wordLength];
    }

    public String guessLetter(char inputLetter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordLength; i++) {
            wordGuessMask[i] = isCorrectGuessForIndex(i, inputLetter);
            if (wordGuessMask[i]) {
                sb.append(wordToGuessCharrArr[i]);
            } else {
                sb.append(UNGUESSED_SYMBOL);
            }
        }
        return sb.toString();
    }

    public boolean wasWordGuessed() {
        for (boolean wasGuessed : wordGuessMask) {
            if (!wasGuessed) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isCorrectGuessForIndex(int idx, char inputLetter) {
    	return wordGuessMask[idx]
    			|| Character.toLowerCase(wordToGuessCharrArr[idx]) == Character.toLowerCase(inputLetter);
    }
}