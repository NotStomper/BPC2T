package com.premysl;

import com.premysl.machine.IBreakable;
import com.premysl.machine.ICanCreateNails;
import com.premysl.machine.Machine;

import java.util.*;

import static java.lang.System.out;

/**
 * Trida pro optimalizaci prace stroju v tovarne
 *
 * Created by Premysl Lefler on 28.4.17.
 */
class Optimizer {
    static void optimize(Factory factory) {
        ArrayList<Machine> machines = factory.getMachineList();
        List<List<Machine>> result = new LinkedList<>();

        for (int i = 1; i <= machines.size(); i++)
            result.addAll(combination(machines, i));

        if (result.size() > 0) {
            List<Machine> bestValue = result.get(0);
            int bestFitnessValue = getListFitnessValue(result.get(0), factory.getComponentsPerHour(), factory.getNailsPerHour());
            int actualFitnessValue = 0;

            for (List<Machine> value : result) {
                actualFitnessValue = getListFitnessValue(value, factory.getComponentsPerHour(), factory.getNailsPerHour());

                if (actualFitnessValue < bestFitnessValue) {
                    bestFitnessValue = actualFitnessValue;
                    bestValue = value;
                }
            }

            for (Machine machine : bestValue) {
                for (Machine machine1 : machines) {
                    if (Objects.equals(machine.getNameOnly(), machine1.getNameOnly())) {
                        machine1.setActive(true);
                    }
                }
            }
        }
    }

    /**
     * source: stackoverflow; nevedel jsem, jak tohle vyrobit
     *
     * @param values
     * @param size
     * @param <T>
     * @return
     */
    private static <T> List<List<T>> combination(List<T> values, int size) {
        if (0 == size) {
            return Collections.singletonList(Collections.<T>emptyList());
        }

        if (values.isEmpty()) {
            return Collections.emptyList();
        }

        List<List<T>> combination = new LinkedList<>();

        T actual = values.iterator().next();

        List<T> subSet = new LinkedList<>(values);
        subSet.remove(actual);

        List<List<T>> subSetCombination = combination(subSet, size - 1);

        for (List<T> set : subSetCombination) {
            List<T> newSet = new LinkedList<>(set);
            newSet.add(0, actual);
            combination.add(newSet);
        }

        combination.addAll(combination(subSet, size));

        return combination;
    }

    private static int getListFitnessValue(List<Machine> input, int wantToProduce, int wantToProduceNails) {
        int energy = 0;
        int production = 0;
        int nailProduction = 0;

        for (Machine machine: input) {
            if (machine instanceof IBreakable && ((IBreakable) machine).IsBroken())
                continue;

            production += machine.getCapacity();
            energy += machine.getEnergy();

            if (machine instanceof ICanCreateNails) {
                nailProduction += ((ICanCreateNails) machine).getNailsCapacity();
            }
        }

        return energy + Math.abs(production - wantToProduce) + Math.abs(nailProduction - wantToProduceNails);
    }
}