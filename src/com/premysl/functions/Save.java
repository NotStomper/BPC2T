package com.premysl.functions;

import java.io.FileNotFoundException;

import static java.lang.System.out;

/**
 * Created by Premysl Lefler on 28.4.17.
 */
public class Save extends Function {
    @Override
    public void run() throws FileNotFoundException {
        try {
            factory.save();
            out.println("Databaze uspesne aktualizovana");
        } catch (FileNotFoundException e) {
            out.println("Chyba: soubor neexistuje");
        }
    }
}
