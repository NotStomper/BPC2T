package com.premysl.functions;

import static java.lang.System.out;

/**
 * Created by Premysl Lefler on 28.4.17.
 */
public class GetWork extends Function {
    @Override
    public void run() {
        out.println("Soucasna vyroba hrebiku : " + factory.getNailsPerHour());
        out.println("Soucasna vyroba soucastek : " + factory.getComponentsPerHour());
    }
}
