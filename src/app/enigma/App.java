package app.enigma;


import app.enigma.encrypt.EnigmaDecoder;
import app.enigma.encrypt.EnigmaEncoder;
import app.enigma.rotor.RotorPlusOne;
import app.enigma.rotor.RotorPlusThree;
import app.enigma.rotor.Rotors;
import app.enigma.swap.Switchboard;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        var switchboard = new Switchboard();
        var rotors = new Rotors(List.of(
                new RotorPlusOne(0),
                new RotorPlusThree(0),
                new RotorPlusOne(0))
        );

        try (var sc = new Scanner(System.in)) {

            while (true) {

                var command = sc.nextLine();

                if ("exit".equals(command)) {
                    break;
                }

                var encryptSwapText = switchboard.swap(rotors.changeText(command, new EnigmaEncoder()));
                rotors.startingPosition();

                var decryptText = rotors.changeText(switchboard.swap(encryptSwapText), new EnigmaDecoder());
                rotors.startingPosition();

                System.out.println("Зашифрованное текст: " + encryptSwapText);
                System.out.println("Расшифрованное текст: " + decryptText);

            }
        }
    }
}
