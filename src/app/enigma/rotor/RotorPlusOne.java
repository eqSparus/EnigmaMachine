package app.enigma.rotor;

public class RotorPlusOne extends Rotor {

    public RotorPlusOne() {
        super(0);
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
