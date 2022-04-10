package app.enigma;


import app.enigma.encrypt.EnigmaDecoder;
import app.enigma.encrypt.EnigmaEncoder;
import app.enigma.rotor.OffsetRotor;
import app.enigma.rotor.RotorsEncrypt;
import app.enigma.swap.Switchboard;

import java.util.List;
import java.util.Scanner;

public class App {

    private static final List<Integer> rotorOne = List.of(
            26, 11, 24, 17, 14, 2, 18, 5, 1, 8, 20, 23, 4, 22, 25, 13, 12, 21, 9, 6, 15, 16, 3, 7, 10, 19
    );

    private static final List<Integer> rotorTwo = List.of(
            19, 1, 6, 18, 14, 17, 24, 4, 22, 11, 21, 3, 2, 7, 15, 25, 12, 5, 10, 20, 26, 9, 16, 8, 23, 13
    );

    private static final List<Integer> rotorThree = List.of(
            6, 7, 20, 17, 16, 11, 5, 10, 14, 19, 18, 21, 3, 23, 22, 26, 2, 25, 8, 1, 24, 12, 15, 9, 4, 13
    );

    public static void main(String[] args) {

        var switchboard = new Switchboard();

        var rotors = new RotorsEncrypt(List.of(
                new OffsetRotor(rotorOne, 9, 1),
                new OffsetRotor(rotorTwo, 10, 3),
                new OffsetRotor(rotorThree, 7, 1)
        ));

        try (var sc = new Scanner(System.in)) {

            while (true) {
                var command = sc.nextLine();

                if ("exit".equals(command)) {
                    break;
                }

                var encryptText = switchboard.swap(rotors.changeText(command, new EnigmaEncoder()));
                System.out.println("Зашифрованное текст: " + encryptText);

                var decryptText = rotors.changeText(switchboard.swap(encryptText), new EnigmaDecoder());
                System.out.println("Расшифрованное текст: " + decryptText);
            }
        }
    }
}
