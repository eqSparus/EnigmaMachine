package app.enigma.encrypt;

public class EnigmaEncoder extends Cipher {

    @Override
    public Character getIndexChar(int sumIndexRotor, char character) {

        var indexLetter = getChars().indexOf(character);

        var newIndex = indexLetter + sumIndexRotor;

        if (newIndex < Cipher.SIZE_ALPHABET) {
            return getChars().get(newIndex);
        }

        return getChars().get(newIndex - Cipher.SIZE_ALPHABET * (newIndex / Cipher.SIZE_ALPHABET));
    }

}
