package com.premysl;

public class Main {

    public static void main(String[] args) {
        Factory factory = new Factory();
        factory.add("test1", MachineType.A);
        factory.add("teasf", MachineType.B);
        factory.add("asfsf", MachineType.C);
        factory.add("asdfasdf", MachineType.A);

        System.out.println(factory.getListString());
    }
}
