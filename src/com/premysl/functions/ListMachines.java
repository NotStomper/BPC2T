package com.premysl.functions;

import com.premysl.machine.Machine;
import static java.lang.System.out;

/**
 * Created by Premysl Lefler on 28.4.17.
 */
public class ListMachines extends Function {
    @Override
    public void run() {
        for (Machine machine : factory.getMachineList()) {
            out.println(" - " + machine.getName() + " (typ " + machine.getMachineType() + ")");
        }
    }
}
