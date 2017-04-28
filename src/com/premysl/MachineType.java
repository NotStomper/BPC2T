package com.premysl;

import java.util.Objects;

public enum MachineType {
    A,
    B,
    C,
    Unknown;

    /**
     * Ziskat typ ze vstupu
     * @param input
     * @return
     */
    public static MachineType getFromString(String input) {
        if (Objects.equals(input.toLowerCase(), "a"))
            return A;
        else if (Objects.equals(input.toLowerCase(), "b"))
            return B;
        else if (Objects.equals(input.toLowerCase(), "c"))
            return C;

        return Unknown;
    }
}
