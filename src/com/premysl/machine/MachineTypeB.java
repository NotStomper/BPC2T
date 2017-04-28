package com.premysl.machine;

/**
 * Created by Premysl Lefler.
 */
public class MachineTypeB extends Machine implements IBreakable {
    private static final int Energy = 3;
    private static final int Capacity = 50;
    private static final String Type = "B";

    private boolean BrokenValue = false;

    /**
     * Default construct for type B machine
     */
    public MachineTypeB(String name) {
        super(name, Energy, Capacity, Type);
    }

    @Override
    public boolean IsBroken() {
        return BrokenValue;
    }

    @Override
    public void breakUp() {
        BrokenValue = false;
    }

    @Override
    public void repair() {
        BrokenValue = true;
    }
}
