/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Karen Velasco
 */
public class RTextField extends JTextField{
    Integer numero;
    
    
    public void setNumero(Integer numero){
        this.numero = numero;
    }
    
    public Integer getNumero(){
        return numero;
    }
}
