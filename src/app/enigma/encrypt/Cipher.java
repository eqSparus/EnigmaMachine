package app.enigma.encrypt;

import java.util.ArrayList;
import java.util.List;


public abstract class Cipher {

    public static final int SIZE_ALPHABET = 58;
    private final List<Character> chars;

    Cipher() {
        this.chars = new ArrayList<>();
        var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ,.?!:".toCharArray();
        for (var c : alphabet) {
            chars.add(c);
        }

    }

    public abstract Character getIndexChar(int sumIndexRotor, char character);

    public List<Character> getChars() {
        return chars;
    }
}
