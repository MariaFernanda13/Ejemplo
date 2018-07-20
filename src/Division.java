/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pacheco Angeles Maria Fernanda
 * TIC03SM-17
 * 26-JUNIO-2018
 */
public class Division {
    
    static int numerador = 20;
    static Integer denominador = null;
    static double division;
    
    public static void main(String[] args){
        System.out.println("Antes de la División");
        
        try{
        division = numerador / denominador;
        }
        catch(ArithmeticException ex){
            division= 0.0;
            System.out.println("Error: " + ex.getMessage());
        }
        catch(NullPointerException np){
            division = 1;
            System.out.println("Error: " + np.getMessage());
        }
        finally{
            System.out.println("Division: " + division);
        System.out.println("Despues de la division");
        }
    }
}
