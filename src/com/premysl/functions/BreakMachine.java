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
        Machine machine = factory.getMachineByName(name);

        if (machine instanceof IBreakable && !((IBreakable) machine).IsBroken()) {
            int i = 0;
            for (Machine value : factory.getMachineList()) {
                if (Objects.equals(value.getName(), machine.getName())) {
                    ((IBreakable) factory.getMachineList().get(i)).breakUp();
                    break;
                }

                i++;
            }

            out.println("Stroj " + machine.getName() + " byl rozmrdan");
        } else {
            out.println("Tento stroj se nemuze rozbit");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
