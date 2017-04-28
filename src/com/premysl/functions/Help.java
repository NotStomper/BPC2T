package com.premysl.functions;

import static java.lang.System.out;

/**
 * Created by Premysl Lefler on 28.4.17.
 */
public class Help extends Function {
    @Override
    public void run() {
        out.println("h nebo H           Napoveda");
        out.println("gw                 Zjistit aktualni vyrobu");
        out.println("sw [typ] [pocet]   Nastavit vyrobu");
        out.println("am [typ] [nazev]   Pridat stroj do tovarny");
        out.println("rm [nazev]         Odstranit stroj z tovarny");
        out.println("ls                 Vratit existujicich stroju");
        out.println("bm [nazev]         Nastavit stroj jako \"porouchany\"");
        out.println("rpm [nazev]        Nastavit stroj jako \"opraveny\"");
        out.println("exit               Ukoncit program");
    }
}
