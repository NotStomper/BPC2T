package com.premysl.functions;

import static java.lang.System.out;

public class SetWork extends Function {
    private WorkType type;
    private String amount;

    public SetWork(int typeVal, String amountVal) {
        setType(WorkType.fromInteger(typeVal));
        setAmount(amountVal);
    }

    @Override
    public void run() {
        int amountInt = 0;

        if (amount.startsWith("+")) {
            if (type == WorkType.Components)
                amountInt = factory.getComponentsPerHour() + Integer.parseInt(amount.substring(1));
            else if (type == WorkType.Nails)
                amountInt = factory.getNailsPerHour() + Integer.parseInt(amount.substring(1));
        } else if (amount.startsWith("-")) {
            if (type == WorkType.Components)
                amountInt = factory.getComponentsPerHour() - Integer.parseInt(amount.substring(1));
            else if (type == WorkType.Nails)
                amountInt = factory.getNailsPerHour() - Integer.parseInt(amount.substring(1));
        } else {
            amountInt = Integer.parseInt(amount);
        }

        if (type == WorkType.Components) {
            if (amountInt < 0)
                amountInt = 0;

            factory.setComponentsPerHour(amountInt);
            out.println("Vyroba soucastek upravena na " + amountInt);
        } else if (type == WorkType.Nails) {
            if (amountInt < 0)
                amountInt = 0;

            factory.setNailsPerHour(amountInt);
            out.println("Vyroba hrebiku uravena na " + amountInt);
        } else {
            out.println("Spatne zadani");
        }
    }

    public WorkType getType() {
        return type;
    }

    public void setType(WorkType type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
