package app.enigma.rotor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Rotor {

    public static final int NUMBER_ROTOR = 26;
    private final List<Integer> integers;
    private int index;
    private final int startPost;
    private boolean isOverflow;

    Rotor(int startPost) {
        this.isOverflow = false;
        this.startPost = startPost;
        this.index = startPost;
        this.integers = new ArrayList<>();
        for (var i = 1; i <= NUMBER_ROTOR; i++) {
            integers.add(i);
        }
        Collections.shuffle(integers);
    }

    public abstract void shift();

    public int getNumber() {
        return integers.get(index);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getStartPost() {
        return startPost;
    }

    public boolean isOverflow() {
        if (isOverflow) {
            isOverflow = false;
            return true;
        } else {
            return false;
        }
    }

    public void setOverflow(boolean overflow) {
        isOverflow = overflow;
    }

}
