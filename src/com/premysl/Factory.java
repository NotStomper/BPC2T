package com.premysl;

import com.premysl.machine.Machine;
import com.premysl.machine.MachineTypeA;
import com.premysl.machine.MachineTypeB;
import com.premysl.machine.MachineTypeC;

import java.util.ArrayList;

enum MachineType {
    A,
    B,
    C
}

/**
 * Created by Premysl Lefler.
 */
class Factory {
    private ArrayList<Machine> MachineList;

    Factory() {
        MachineList = new ArrayList<>();
    }

    void add(String name, MachineType m) {
        Machine item = null;

        if (m == MachineType.A)
            item = new MachineTypeA(name);
        else if (m == MachineType.B)
            item = new MachineTypeB(name);
        else if (m == MachineType.C)
            item = new MachineTypeC(name);

        MachineList.add(item);
    }

    String getListString() {
        StringBuilder result = new StringBuilder();

        for(Machine item: MachineList) {
            result.append("\n").append(item.toString());
        }

        return result.toString();
    }
}
