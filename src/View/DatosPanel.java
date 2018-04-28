/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import ListenersClases.DatosPanelListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Karen Velasco
 */
public class DatosPanel extends JPanel{
    JLabel instrucciones;
    JTextField numero;
    JButton boton;
    DatosPanelListener listener;
    
    public DatosPanel(){
        super();
        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        instrucciones = new JLabel("Ingrese la dimension del cuadro"); 
        numero = new JTextField();
        numero.setBounds(100, 150, 50,50);
        
        boton = new JButton("OK");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onBtnClick();
            }
        });
        
        super.add(instrucciones);
        super.add(numero);
        super.add(boton);
    }
    
    public void setListener(DatosPanelListener listener){
        this.listener = listener;
    }
    
    public Integer getN(){
        return Integer.valueOf(numero.getText());
    }
}
