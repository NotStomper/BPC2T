package com.premysl.machine;

/**
 * Created by Premysl Lefler.
 */
public abstract class Machine {
    private int EnergyPerComponent;
    private int Capacity;
    private String Name;
    private String Type;
    private boolean Active;

    Machine(String name, int energy, int capacity, String type) {
        this.setName(name);
        this.setEnergyPerComponent(energy);
        this.setCapacity(capacity);
        this.setType(type);
    }

    public abstract String getMachineType();

    public int getEnergy() {
        return EnergyPerComponent;
    }

    private void setEnergyPerComponent(int energyPerComponent) {
        EnergyPerComponent = energyPerComponent;
    }

    public int getCapacity() {
        return Capacity;
    }

    private void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public String getName() {
        String result = Name;

        if (this instanceof IBreakable && ((IBreakable)this).IsBroken())
            result += " (rozbity)";

        if (isActive())
            result += " - aktivni";

        return result;
    }

    private void setName(String name) {
        Name = name;
    }

    private void setType(String type) {
        Type = type;
    }

    public String getNameOnly() {
        return Name;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = !(this instanceof IBreakable && ((IBreakable) this).IsBroken()) && active;
    }
}
