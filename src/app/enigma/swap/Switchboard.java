package app.enigma.swap;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Switchboard implements ISwapLetter {

    private static final Path path = Path.of("src/app/enigma/swap/switchboard.txt");
    private final Map<Character, Character> maps;

    public Switchboard() {
        this.maps = new HashMap<>();
        try (var stream = Files.lines(path, StandardCharsets.UTF_8)) {

            stream.forEach(line -> {
                var splitLine = line.split("-");
                maps.put(splitLine[0].charAt(0), splitLine[1].charAt(0));
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String swap(String text) {

        var result = new StringBuilder();

        text.chars()
                .mapToObj(value -> (char) value)
                .forEach(character -> {

                    if (maps.containsKey(character)) {
                        result.append(maps.get(character));
                    } else {
                        var ch = maps.entrySet().stream()
                                .filter(entry -> entry.getValue().equals(character))
                                .findAny();

                        ch.ifPresentOrElse(c -> result.append(c.getKey()),
                                () -> result.append(character));
                    }

                });

        return result.toString();
    }
}
