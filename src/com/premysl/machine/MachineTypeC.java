package com.premysl.machine;

/**
 * Created by Premysl Lefler.
 */
public class MachineTypeC extends Machine implements IBreakable {
    private static final int Energy = 2;
    private static final int Capacity = 150;
    private static final String Type = "C";

    private boolean BrokenValue = false;

    /**
     * Default construct for type C machine
     */
    public MachineTypeC(String name) {
        super(name, Energy, Capacity, Type);
    }

    @Override
    public boolean IsBroken() {
        return BrokenValue;
    }

    @Override
    public void breakUp() {
        BrokenValue = true;
    }

    @Override
    public void repair() {
        BrokenValue = false;
    }
}
