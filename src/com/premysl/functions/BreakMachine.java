package com.premysl.functions;

import com.premysl.machine.IBreakable;
import com.premysl.machine.Machine;

import java.util.Objects;

import static java.lang.System.out;

/**
 * Created by Premysl Lefler on 28.4.17.
 */
public class BreakMachine extends Function {
    private String name;

    public BreakMachine(String name) {
        setName(name);
    }

    @Override
    public void run() {
        int i = 0;
        boolean done = false;

        for (Machine value : factory.getMachineList()) {
            if (Objects.equals(value.getName(), getName()) && value instanceof IBreakable) {
                ((IBreakable) factory.getMachineList().get(i)).breakUp();

                done = true;
                break;
            }

            i++;
        }

        if (done)
            out.println("Stroj " + getName() + " byl rozmrdan");
        else
            out.println("Stroj nelze rozbit");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
