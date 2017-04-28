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
        Machine machine = factory.getMachineByName(name);

        if (machine instanceof IBreakable && !((IBreakable) machine).IsBroken()) {
            int i = 0;
            for (Machine value : factory.getMachineList()) {
                if (Objects.equals(value.getName(), machine.getName())) {
                    ((IBreakable) factory.getMachineList().get(i)).repair();
                    break;
                }

                i++;
            }

            out.println("Stroj " + machine.getName() + " byl opraven");
        } else {
            out.println("Tento stroj nelze opravit");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
