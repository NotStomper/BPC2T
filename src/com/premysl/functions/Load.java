package com.premysl.functions;

import java.io.IOException;

/**
 * Created by Premysl Lefler on 28.4.17.
 */
public class Load extends Function {
    @Override
    public void run() throws IOException {
        factory.load();
    }
}
