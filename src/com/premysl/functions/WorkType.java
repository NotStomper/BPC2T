package com.premysl.functions;

/**
 * Created by Premysl Lefler on 28.4.17.
 */
public enum WorkType {
    Components,
    Nails,
    Unknown;

    public static WorkType fromInteger(int value) {
        if (value == 1)
            return Components;
        else if (value == 2)
            return Nails;

        return Unknown;
    }
}
