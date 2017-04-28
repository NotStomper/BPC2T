package com.premysl.functions;

import com.premysl.machine.Machine;

import java.io.IOException;

import static java.lang.System.out;

/**
 * Created by Premysl Lefler on 28.4.17.
 */
public class GetEnergy extends Function {
    @Override
    public void run() throws IOException {
        int amount = 0;

        for (Machine machine : factory.getMachineList()) {
            amount += machine.getEnergy();
        }

        out.println("Soucasna celkova spotreba je " + amount + " W/soucastku");
    }
}
