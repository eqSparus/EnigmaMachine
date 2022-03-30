package app.enigma.rotor;

public class RotorPlusThree extends Rotor {

    public RotorPlusThree() {
        super(0);
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
