/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ResultadoMatriz;
import static Model.ResultadoMatriz.matrizCero;
import static Model.ResultadoMatriz.sumasCorrectas;
import static Model.ResultadoMatriz.sumasDesiguales;
import static Model.ResultadoMatriz.valido;
import static Model.ResultadoMatriz.valoresCorrectos;
import static Model.ResultadoMatriz.valoresNoValidos;
import static Model.ResultadoMatriz.valoresRepetidos;

/**
 *
 * @author Karen Velasco
 */
public class Cuadro {
    Integer n;
    Integer[][] matriz;
    
    public Cuadro(Integer n, Integer[][] matriz){
        this.n = n;
        this.matriz = matriz;
    }
    
    public ResultadoMatriz isMagico(){//0 = correcto, 1 = sumas no coinciden, 2 ingreso los mismos valores 
        if(this.evaluarSumas()== sumasCorrectas && this.evaluarNumeros()==valoresCorrectos)
            return valido;
        else if(this.evaluarNumeros()== valoresNoValidos)
                return valoresNoValidos;
        else if(this.evaluarNumeros() == valoresRepetidos)
                return valoresRepetidos;
        else if(this.evaluarSumas() == sumasDesiguales)
                return sumasDesiguales;
        else
            return matrizCero;
    }
    
    public ResultadoMatriz evaluarSumas(){
        ResultadoMatriz resultado = null;
        Integer[] suma = new Integer[2*n+2];
        //evauar las sumas horizontales
        int coef = 0;
        for(int i=0;i<n; i++){//filas, 0,1
            suma[coef] = 0;
            
            for(int j=0; j<n; j++){//x
                //evaluar las sumas de las filas
                System.out.println(matriz[j][i]);
                suma[coef]+= matriz[j][i];//dfdfdfd
            }
            
            coef++;
        }
        //evaluar las sumas verticales
        for(int i=0;i<n; i++){//columnas, x 
            suma[coef]=0;
            for(int j=0; j<n; j++){//filas, y
                //evaluar las sumas de las filas
                suma[coef]+= matriz[i][j];
            }
            coef++;
        }
        //diagonal positiva
        
        suma[coef]=0;
        for(int i=0;i<n; i++){//filas
            suma[coef]+=matriz[i][i];
        }
        coef++;
        //diagonal negativa
        suma[coef]=0;
        int x = n-1;
        for(int y=0; y<n;y++){
            suma[coef]+=matriz[x][y];
            x--;
        }

        //verificar que todas las sumas sean iguales
        int cont = 0;
        for(int i=1;i<(2*n+2);i++){
            if(suma[i]==suma[0])
                cont++;
        }
        if(cont==(2*n+1))
            resultado = sumasCorrectas;
        else
            resultado = sumasDesiguales;
        
        return resultado;
    }
    
    public ResultadoMatriz evaluarNumeros(){
        //1. ordenar los datos
        Integer[] valores = new Integer[n*n];
                
        //evaluar los ceros
        int ceros = 0;
        for(int i=0;i<n; i++){
            for(int j=0; j<n; j++){
                if(matriz[j][i]==0)
                    ceros++;
            }
        }

        if(ceros==(n*n))return matrizCero;

        int k=0;
        
        for(k=0; k<(n*n); k++){
            valores[k] = 0;
        }
        
        for(int i=0; i<n;i++){ //y
            for(int j=0; j<n; j++){ //x
                
                //Aumentar valores
                if(matriz[j][i]<1 || matriz[j][i]>(n*n)){
                    return valoresNoValidos;//valores no validos
                }
                //aumentar 
                valores[matriz[j][i]-1]++;
                
            }
        }
                
        Integer cont=0;
        for(k=0; k<(n*n);k++){
            if(valores[k]==1)
                cont++;
        }
        
        if(cont==(n*n))
            return valoresCorrectos;
        
        return valoresRepetidos;//valores repetidos
    }
    
}
