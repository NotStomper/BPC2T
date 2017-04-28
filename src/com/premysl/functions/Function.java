package com.premysl.functions;

import com.premysl.*;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Premysl Lefler on 28.4.17.
 */
public abstract class Function {
    Factory factory;

    public void setFactory(Factory value) {
        factory = value;
    }

    public abstract void run() throws IOException;
}
