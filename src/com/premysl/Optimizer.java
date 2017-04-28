package com.premysl;

import com.premysl.machine.Machine;

import java.util.ArrayList;

/**
 *
 * Created by Premysl Lefler on 28.4.17.
 */
class Optimizer {
    static void optimize(Factory factory) {
//        ArrayList<ArrayList<Machine>> combinations = findCombinations(factory.getMachineList());
    }

//    private static ArrayList<ArrayList<Machine>> findCombinations(ArrayList<Machine> machines) {
//        ArrayList<ArrayList<Machine>> combinations = new ArrayList<>();
//
//        for (int i = 0; i < machines.size(); i++) {
//            ArrayList<Machine> comb = new ArrayList<>();
//            comb.add(machines.get(i));
//
//            ArrayList<Machine> newMachineList = new ArrayList<>(machines);
//            newMachineList.remove(i);
//
//            combinations.add(comb);
//            combinations.addAll(findCombinations(newMachineList, combinations));
//        }
//
//        return combinations;
//    }
//
//    private static ArrayList<ArrayList<Machine>> findCombinations(ArrayList<Machine> machines, ArrayList<ArrayList<Machine> fixed) {
//        ArrayList<ArrayList<Machine>> combinations = new ArrayList<>();
//
//        for (int i = 0; i < fixed.size(); i++) {
//            ArrayList<Machine> comb = fixed[i];
//            comb.add(machines.get(i));
//
//            ArrayList<Machine> newMachineList = new ArrayList<>(machines);
//            newMachineList.remove(i);
//
//            combinations.add(comb);
//            combinations.addAll(findCombinations(newMachineList, combinations));
//        }
//
//        return findCombinations(machines, combinations);
//    }
}