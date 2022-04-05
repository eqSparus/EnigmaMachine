package app.enigma.rotor;

import java.util.List;

public class RotorPlusOne extends Rotor {

    public RotorPlusOne() {
        super(0);
    }

    public RotorPlusOne(List<Integer> integers) {
        super(integers, 0);
    }

    public RotorPlusOne(List<Integer> integers, int startPost){
        super(integers, startPost);
    }

    public RotorPlusOne(int startPost) {
        super(startPost);
    }


    public void shift() {
        setIndex(getIndex() + 1);
        if (getIndex() == NUMBER_ROTOR) {
            setOverflow(true);
            setIndex(0);
        }
    }

}
