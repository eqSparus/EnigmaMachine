package app.enigma.rotor;

import app.enigma.encrypt.Cipher;

import java.util.ArrayList;
import java.util.List;

public class RotorsEncrypt {

    private final List<Rotor> rotors;

    public RotorsEncrypt(List<Rotor> rotors) {
        this.rotors = new ArrayList<>(rotors);
    }

    public String changeText(String text, Cipher cipher) {

        var result = new StringBuilder();

        text.chars()
                .mapToObj(value -> (char) value)
                .forEach(character -> {

                    var sumIndexRotor = rotors.stream().reduce(0,
                            (integer, rotor) -> integer + rotor.getNumber(), Integer::sum);

                    result.append(cipher.getIndexChar(sumIndexRotor, character));

                    rotors.get(0).shift();
                    for (var i = 0; i < rotors.size(); i++) {
                        if (rotors.get(i).isOverflow()) {
                            try {
                                rotors.get(i + 1).shift();
                            } catch (IndexOutOfBoundsException e) {
                                rotors.forEach(rotor -> rotor.setIndex(rotor.getStartPost()));
                            }
                        }
                    }

                });

        startingPosition();
        return result.toString();
    }

    private void startingPosition() {
        rotors.forEach(rotor -> rotor.setIndex(rotor.getStartPost()));
    }

}
