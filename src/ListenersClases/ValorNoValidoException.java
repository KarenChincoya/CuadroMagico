/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListenersClases;

/**
 *
 * @author Karen Velasco
 */
public class ValorNoValidoException extends Exception {

    /**
     * Creates a new instance of <code>ValorNoValidoException</code> without
     * detail message.
     */
    public ValorNoValidoException() {
    }

    /**
     * Constructs an instance of <code>ValorNoValidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ValorNoValidoException(String msg) {
        super(msg);
    }
}
