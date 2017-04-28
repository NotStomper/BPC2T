package com.premysl.functions;

import com.premysl.machine.Machine;

import java.util.Objects;

import static java.lang.System.out;

/**
 * Created by Premysl Lefler on 28.4.17.
 */
public class RemoveMachine extends Function {
    private String name;

    public RemoveMachine(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        boolean done = false;
        int i = 0;

        for (Machine machine : factory.getMachineList()) {
            if (Objects.equals(machine.getName(), name)) {
                factory.getMachineList().remove(i);
                out.println("Stroj " + machine.getName() + " uspesne odstranen.");

                done = true;
                break;
            }

            i++;
        }

        if (!done) {
            out.println("Stroj " + name + " v tovarne neexistuje.");
        }
    }
}
