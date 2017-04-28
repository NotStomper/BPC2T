package com.premysl;

import com.premysl.machine.Machine;
import com.premysl.machine.MachineTypeA;
import com.premysl.machine.MachineTypeB;
import com.premysl.machine.MachineTypeC;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Premysl Lefler.
 */
public class Factory {
    private ArrayList<Machine> MachineList;
    private int componentsPerHour;
    private int nailsPerHour;

    Factory() {
        MachineList = new ArrayList<>();
        setComponentsPerHour(0);
    }

    public void add(String name, MachineType m) {
        Machine item = null;

        if (m == MachineType.A)
            item = new MachineTypeA(name);
        else if (m == MachineType.B)
            item = new MachineTypeB(name);
        else if (m == MachineType.C)
            item = new MachineTypeC(name);

        MachineList.add(item);
    }

    public Machine getMachineByName(String name) {
        for (Machine machine : getMachineList()) {
            if (Objects.equals(machine.getName(), name))
                return machine;
        }

        return null;
    }

    public int getComponentsPerHour() {
        return componentsPerHour;
    }

    public void setComponentsPerHour(int componentsPerHour) {
        this.componentsPerHour = componentsPerHour;
    }

    public int getNailsPerHour() {
        return nailsPerHour;
    }

    public void setNailsPerHour(int nailsPerHour) {
        this.nailsPerHour = nailsPerHour;
    }

    public ArrayList<Machine> getMachineList() {
        return MachineList;
    }

    public void setMachineList(ArrayList<Machine> machineList) {
        MachineList = machineList;
    }

}
