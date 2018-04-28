/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Cuadro;
import ListenersClases.DatosPanelListener;
import ListenersClases.TableroPanelListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;

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

        datosPanel.setListener(new DatosPanelListener() {
            @Override
            public void onBtnClick() {
                tableroPanel = new TableroPanel(datosPanel.getN());

                matriz = new Integer[datosPanel.getN()][datosPanel.getN()];

                MainFrame.this.add(tableroPanel, BorderLayout.CENTER);
                
                setVisible(true);

                tableroPanel.setListener(new TableroPanelListener() {
                    @Override
                    public void onBtnClick() {
                        matriz = tableroPanel.getMatriz();

                        //ahora lee los valores
                        cuadro = new Cuadro(datosPanel.getN(), matriz);
                        cuadro.isMagico();
                        System.out.println(cuadro.isMagico());
                    }
                });

//
            }
        });

        super.add(datosPanel, BorderLayout.NORTH);
        super.setVisible(true);
    }
}
