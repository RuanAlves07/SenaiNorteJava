
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ruan
 */
public class Exercicio6 {
 public static void main(String arg[]){
     Scanner input = new Scanner (System.in);
     
     int numero;
     int fatorial = 1;
     int i = 1;
     
     System.out.println("Porfavor, insira o número que deseja fatorar.");
     numero = input.nextInt();
     
     while(i <= numero) {
         fatorial = fatorial * i;
         i++;
     }
    
     System.out.println("O fatorial do número "+numero+" é de "+fatorial);
 }   
}
