package com.premysl.functions;

import com.premysl.MachineType;
import com.premysl.machine.Machine;

import java.util.Objects;

import static java.lang.System.out;

/**
 * Created by Premysl Lefler on 28.4.17.
 */
public class AddMachine extends Function {
    MachineType type;
    String typeStr;
    String name;

    public AddMachine(String type, String name) {
        setTypeStr(type);
        setType(MachineType.getFromString(type));
        setName(name);
    }

    @Override
    public void run() {
        if (type == MachineType.Unknown) {
            out.println("Neznamy typ stroje");
        } else {
            if (type == MachineType.C) {
                boolean cTypeExists = false;

                for (Machine machine : factory.getMachineList()) {
                    if (Objects.equals(machine.getMachineType(), "C")) {
                        cTypeExists = true;
                    }
                }

                if (cTypeExists) {
                    out.println("Type C muze byt v tovarne pouze jeden!");
                } else {
                    factory.add(name, type);
                    out.println("Stroj " + name + "(" + type + ")" + " byl uspesne pridan do tovarny");
                }
            } else {
                factory.add(name, type);
                out.println("Stroj " + name + "(" + type + ")" + " byl uspesne pridan do tovarny");
            }
        }
    }

    public MachineType getType() {
        return type;
    }

    public void setType(MachineType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }
}
