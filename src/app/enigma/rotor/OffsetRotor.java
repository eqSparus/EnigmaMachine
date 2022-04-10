package app.enigma.rotor;

import java.util.List;

public class OffsetRotor extends Rotor {

    private final int ring;

    public OffsetRotor(int ring) {
        super(0);
        this.ring = ring;
    }

    public OffsetRotor(List<Integer> integers, int ring) {
        super(integers, 0);
        this.ring = ring;
    }

    public OffsetRotor(List<Integer> integers, int startPost, int ring){
        super(integers, startPost);
        this.ring = ring;
    }

    public OffsetRotor(int startPost, int ring) {
        super(startPost);
        this.ring = ring;
    }


    public void shift() {
        setIndex(getIndex() + ring);
        if (getIndex() == NUMBER_ROTOR) {
            setOverflow(true);
            setIndex(0);
        }
    }

}
