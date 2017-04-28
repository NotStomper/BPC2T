package com.premysl.machine;

/**
 * Created by Premysl Lefler.
 */
public class MachineTypeB extends Machine implements IBreakable, ICanCreateNails {
    private static final int Capacity = 50;
    private static final int DefaultCapacityNails = 0;
    private static final String Type = "B";
    private static final int Energy = Capacity - DefaultCapacityNails;

    private boolean BrokenValue = false;
    private int EnergyNails;

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
        BrokenValue = true;
    }

    @Override
    public void repair() {
        BrokenValue = false;
    }

    @Override
    public int getNailsCapacity() {
        return EnergyNails;
    }

    @Override
    public void setNailCapacity(int value) {
        EnergyNails = value;
    }

    @Override
    public String getMachineType() {
        return Type;
    }
}
