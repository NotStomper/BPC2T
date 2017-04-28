package com.premysl.functions;

import static java.lang.System.out;

/**
 * Created by Premysl Lefler on 28.4.17.
 */
public class Help extends Function {
    @Override
    public void run() {
        out.println("h nebo H           Napoveda"); // help
        out.println("gw                 Zjistit aktualni vyrobu"); // get work
        out.println("ge                 Zjistit aktualni celkovou spotrebu"); // get energy
        out.println("sw [typ] [pocet]   Nastavit vyrobu"); // set work
        out.println("am [typ] [nazev]   Pridat stroj do tovarny"); // add machine
        out.println("rm [nazev]         Odstranit stroj z tovarny"); // remove machine
        out.println("ls                 Vratit existujicich stroju"); // list
        out.println("bm [nazev]         Nastavit stroj jako \"porouchany\""); // break machine
        out.println("rpm [nazev]        Nastavit stroj jako \"opraveny\""); // repair machine
        out.println("save               Aktualizovat databazi");
        out.println("load               Nacist stav z databaze");
        out.println("exit               Ukoncit program");
    }
}
