
import Controller.Cuadro;
import View.MainFrame;
import View.TableroPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karen Velasco
 */
public class Main {
    
    public static void main(String[] args) {
        Integer[][] matriz3 = {
                                {2,4,6},
                                {9,5,1},
                                {7,3,8}
                             };
        
        Integer[][] matriz4 = {
                                {16,3,2,13},
                                {5,10,11,8},
                                {9,6,7,12},
                                {4,15,14,1},
                             };
        
        //Cuadro cuadro = new Cuadro(4, matriz4);
       // System.out.println(cuadro.isMagico());
        
        new MainFrame();
    }
}
