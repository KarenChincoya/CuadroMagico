/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import ListenersClases.TableroPanelListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Karen Velasco
 */
public class TableroPanel extends JPanel {

    JPanel cajitas;
    RTextField[][] valor;
    JButton enviar;
    
    TableroPanelListener listener;
    
    Integer[][] matriz;
    Integer n;

    public TableroPanel(Integer n) {
        this.n = n;
        matriz = new Integer[n][n];
        super.setLayout(new BorderLayout());

        cajitas = new JPanel();
        GridLayout layout = new GridLayout(n, n);
        cajitas.setLayout(layout);
        cajitas.setSize(n * 45, n * 45);

        
        //int y = 0;
        //GridLayout(n,n)
        valor = new RTextField[n][n];

        this.agregarCajitas();

        enviar = new JButton("Enviar");
        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onBtnClick();
            }
        });

        int rows = layout.getRows();
        int columns = layout.getColumns();

        super.add(cajitas, BorderLayout.CENTER);
        super.add(enviar, BorderLayout.SOUTH);
    }

    public void setListener(TableroPanelListener listener) {
        this.listener = listener;
    }

    public Integer[][] getMatriz() {
        Integer aux;
        String cadenita;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //object
                cadenita = valor[j][i].getText();

                aux = null;
                try {
                    aux = Integer.valueOf(cadenita);

                } catch (Exception e) {
                    //retorna la matriz cero
                    System.out.println("Funcion de invoco valores invalidos");
                    return this.matrizCero();
//                    e.printStackTrace();
                } finally {
                    if (aux != null) {
                        matriz[j][i] = aux;
                    } else {//validar los datos
                        System.out.println("Valor no valido: " + cadenita);
                        
                    }

                }
            }
        }
        System.out.println("matriz");
        return matriz;

    }
    
    public void agregarCajitas(){
        int x = 0;
        for (int i = 0; i < n; i++) {//Y
            x = 0;
            for (int j = 0; j < n; j++) {//X
                valor[j][i] = new RTextField();
                valor[j][i].setBounds(i * 35 + 10, j * 35 + 10, 30, 30);
                valor[j][i].setText("");
                cajitas.add(valor[j][i]);
            }
        }
    }
    
    public Integer[][] matrizCero(){
        Integer[][] matriz = new Integer[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matriz[j][i]=0;
            }
        }
        return matriz;
    }
    
}
