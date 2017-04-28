package com.premysl.functions;

import com.premysl.machine.IBreakable;
import com.premysl.machine.Machine;

import java.util.Objects;

import static java.lang.System.out;

/**
 * Created by Premysl Lefler on 28.4.17.
 */
public class RepairMachine extends Function {
    private String name;

    public RepairMachine(String name) {
        setName(name);
    }

    @Override
    public void run() {
        int i = 0;
        boolean done = false;

        for (Machine value : factory.getMachineList()) {
            if (Objects.equals(value.getNameOnly(), getName()) && value instanceof IBreakable) {
                ((IBreakable) factory.getMachineList().get(i)).repair();

                done = true;
                break;
            }

            i++;
        }

        if (done)
            out.println("Stroj " + getName() + " byl opraven");
        else
            out.println("Stroj nelze opravit");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
