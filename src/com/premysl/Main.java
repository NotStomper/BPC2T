package com.premysl;

import com.premysl.functions.*;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) throws IOException {
        Factory factory = new Factory();
        factory.setFilename("data.txt");

        Scanner reader = new Scanner(System.in);
        Function object;

        while (true) {
            out.print("Zadejte prikaz: ");
            String input = reader.nextLine();

            if (Objects.equals(input, "h") || Objects.equals(input, "H")) {
                object = new Help();
            } else if (input.startsWith("sw ")) {
                String[] values = input.split(" ");
                int type = Integer.parseInt(values[1]);
                String amount = values[2];

                object = new SetWork(type, amount);
            } else if (Objects.equals(input, "gw")) {
                object = new GetWork();
            } else if (input.startsWith("am ")) {
                String[] values = input.split(" ");
                String type = values[1];
                String name = values[2];

                object = new AddMachine(type, name);
            } else if (input.startsWith("ls")) {
                object = new ListMachines();
            } else if (input.startsWith("rm ")) {
                String[] values = input.split(" ");
                String name = values[1];

                object = new RemoveMachine(name);
            } else if (input.startsWith("bm ")) {
                String[] values = input.split(" ");
                String name = values[1];

                object = new BreakMachine(name);
            } else if (input.startsWith("rpm ")) {
                String[] values = input.split(" ");
                String name = values[1];

                object = new RepairMachine(name);
            } else if (Objects.equals(input, "save")) {
                object = new Save();
            } else if (Objects.equals(input, "load")) {
                object = new Load();
            } else if (Objects.equals(input, "ge")) {
                object = new GetEnergy();
            } else if (Objects.equals(input, "exit")) {
                break;
            } else {
                continue;
            }

            object.setFactory(factory);
            object.run();

            Optimizer.optimize(factory);
        }
    }
}
