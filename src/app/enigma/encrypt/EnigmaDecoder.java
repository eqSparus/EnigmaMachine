package app.enigma.encrypt;

public class EnigmaDecoder extends Cipher {


    @Override
    public Character getIndexChar(int sumIndexRotor, char character) {

        var indexLetter = getChars().indexOf(character);

        var newIndex = indexLetter - sumIndexRotor;

        if (newIndex >= 0) {
            return getChars().get(newIndex);
        } else if (newIndex > -Cipher.SIZE_ALPHABET) {
            return getChars().get(Cipher.SIZE_ALPHABET + newIndex);
        }

        newIndex -= Cipher.SIZE_ALPHABET * (newIndex / Cipher.SIZE_ALPHABET);

        return getChars().get(Cipher.SIZE_ALPHABET + newIndex);

    }
}
