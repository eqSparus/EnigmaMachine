package app.enigma.rotor;

import java.util.List;

public class RotorPlusThree extends Rotor {

    public RotorPlusThree() {
        super(0);
    }

    public RotorPlusThree(List<Integer> integers) {
        super(integers, 0);
    }

    public RotorPlusThree(List<Integer> integers, int startPost){
        super(integers, startPost);
    }

    public RotorPlusThree(int startPost) {
        super(startPost);
    }

    @Override
    public void shift() {
        setIndex(getIndex() + 3);
        if (getIndex() >= NUMBER_ROTOR) {
            setOverflow(true);
            setIndex(NUMBER_ROTOR - (NUMBER_ROTOR - 3));
        }
    }
}
