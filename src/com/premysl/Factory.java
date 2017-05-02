package com.premysl;

import com.premysl.machine.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.System.out;

/**
 * Created by Premysl Lefler.
 */
public class Factory {
    private ArrayList<Machine> MachineList;
    private String filename;
    private int componentsPerHour;
    private int nailsPerHour;

    Factory() {
        MachineList = new ArrayList<>();
        setComponentsPerHour(0);
        setNailsPerHour(0);
    }

    public void save() throws FileNotFoundException {
        try (PrintWriter fileWriter = new PrintWriter(getFilename())) {
            fileWriter.println(componentsPerHour + ";" + nailsPerHour);

            for (Machine machine : getMachineList()) {
                StringBuilder lineBuilder = new StringBuilder(machine.getNameOnly() + ";" + machine.getMachineType()
                    + ";" + machine.isActive());

                if (machine instanceof IBreakable) {
                    lineBuilder.append(";").append(((IBreakable) machine).IsBroken());
                }

                if (Objects.equals(machine.getMachineType(), "B")) {
                    lineBuilder.append(";").append(((MachineTypeB) machine).getNailsCapacity());
                }

                fileWriter.append(String.valueOf(lineBuilder)).append("\n");
            }
        }

    }

    public void load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(getFilename()), StandardCharsets.UTF_8);

        String firstLine = lines.get(0);
        String[] firstLineValues = firstLine.split(";");

        lines.remove(0);

        this.setComponentsPerHour(Integer.parseInt(firstLineValues[0]));
        this.setNailsPerHour(Integer.parseInt(firstLineValues[1]));

        for (String line : lines) {
            String[] values = line.split(";");
            String name = values[0];
            MachineType type = MachineType.getFromString(values[1]);

            Machine machine = this.add(name, type);
            machine.setActive(Objects.equals(values[2], "true"));

            if (machine instanceof IBreakable && Objects.equals(values[3], "true")) {
                ((IBreakable) machine).breakUp();
            }

            if (machine instanceof MachineTypeB) {
                ((MachineTypeB) machine).setNailCapacity(Integer.parseInt(values[4]));
            }
        }
    }

    public Machine add(String name, MachineType m) {
        Machine item = null;

        if (m == MachineType.A)
            item = new MachineTypeA(name);
        else if (m == MachineType.B)
            item = new MachineTypeB(name);
        else if (m == MachineType.C)
            item = new MachineTypeC(name);

        MachineList.add(item);
        return MachineList.get(MachineList.size() - 1);
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public ArrayList<Machine> getMachineList() {
        return MachineList;
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

    public void setMachineList(ArrayList<Machine> machineList) {
        MachineList = machineList;
    }
}
