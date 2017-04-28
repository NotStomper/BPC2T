package com.premysl.machine;

/**
 * Created by Premysl Lefler.
 */
public interface IBreakable {
    /**
     * @return boolean is machine broken
     */
    boolean IsBroken();

    /**
     * break up machine
     */
    void breakUp();

    /**
     * repair machine
     */
    void repair();
}
