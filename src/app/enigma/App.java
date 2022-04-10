package app.enigma;


import app.enigma.encrypt.EnigmaDecoder;
import app.enigma.encrypt.EnigmaEncoder;
import app.enigma.rotor.OffsetRotor;
import app.enigma.rotor.RotorsEncrypt;
import app.enigma.swap.Switchboard;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        var switchboard = new Switchboard();

        var rotors = new RotorsEncrypt(List.of(
                new OffsetRotor(9, 1),
                new OffsetRotor(10, 3),
                new OffsetRotor(7, 1)
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
