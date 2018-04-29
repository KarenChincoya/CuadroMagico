/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Cuadro;
import ListenersClases.DatosPanelListener;
import ListenersClases.TableroPanelListener;
import Model.ResultadoMatriz;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Karen Velasco
 */
public class MainFrame extends JFrame {

    DatosPanel datosPanel;
    TableroPanel tableroPanel;
    Cuadro cuadro;
    Integer[][] matriz;

    public MainFrame() {
        super("Cuadros magicos");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
        super.setSize(500, 500);

        datosPanel = new DatosPanel();

        datosPanel.setListener(new DatosPanelListener(){
            @Override
            public void onBtnClick() {
                tableroPanel = new TableroPanel(datosPanel.getN());

                matriz = new Integer[datosPanel.getN()][datosPanel.getN()];

                MainFrame.this.add(tableroPanel, BorderLayout.CENTER);
                tableroPanel.setPreferredSize(new Dimension(datosPanel.getN()*45,datosPanel.getN()*45));
                
                setVisible(true);

                tableroPanel.setListener(new TableroPanelListener() {
                    @Override
                    public void onBtnClick() {
                        matriz = tableroPanel.getMatriz();

                        //ahora lee los valores
                        cuadro = new Cuadro(datosPanel.getN(), matriz);
                        ResultadoMatriz result = cuadro.isMagico();
                        
                        switch(result){
                            case valido:
                                JOptionPane.showMessageDialog(tableroPanel, "Congratulations!", "Ganaste!!!", JOptionPane.DEFAULT_OPTION);
                                break;
                            case sumasDesiguales:
                                JOptionPane.showMessageDialog(tableroPanel, "Las sumas son desiguales.", "Alert!",  JOptionPane.WARNING_MESSAGE);
                                break;
                            case valoresRepetidos:
                                JOptionPane.showMessageDialog(tableroPanel, "Ingresaste valores repetidos.", "Alert!",JOptionPane.WARNING_MESSAGE);
                                break;
                            case valoresNoValidos: //los numero deben tener un rango entre 1 y n}n
                                JOptionPane.showMessageDialog(tableroPanel, "Los numero deben estar entre 1 y n^2.", "Alert!",JOptionPane.WARNING_MESSAGE);
                                break;
                            case matrizCero://ingreso valores NO numericos
                                JOptionPane.showMessageDialog(tableroPanel,"Los valores deben ser numericos.", "Alert!", JOptionPane.WARNING_MESSAGE);
                                break;
                        }
                        
                        System.out.println(cuadro.isMagico());
                        
                        tableroPanel.setVisible(false);
                    }
                });
                
//                setVisible(true);
                
            }
        });

        super.add(datosPanel, BorderLayout.NORTH);
        super.setVisible(true);
    }
}
