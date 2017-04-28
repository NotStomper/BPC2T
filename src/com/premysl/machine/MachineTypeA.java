package com.premysl.machine;

/**
 * Created by Premysl Lefler.
 */
public class MachineTypeA extends Machine {
    private static final int Energy = 4;
    private static final int Capacity = 70;
    private static final String Type = "A";

    /**
     * Default construct for type A machine
     */
    public MachineTypeA(String name) {
        super(name, Energy, Capacity, Type);
    }
}
