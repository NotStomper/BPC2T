package com.premysl.machine;

/**
 * Stroj, ktery muze vyrabet sroubky
 * Created by Premysl Lefler on 28.4.17.
 */
public interface ICanCreateNails {
    /**
     * Pocet vyrobenych sroubu za hodinu
     * @return int
     */
    int getNailsCapacity();

    /**
     * Nastavit pocet vyrabenych sroubu
     */
    void setNailCapacity(int value);
}
