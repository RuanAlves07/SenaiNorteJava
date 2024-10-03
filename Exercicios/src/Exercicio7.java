
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ruan
 */
public class Exercicio7 {
  public static void main(String []arg){
      Scanner input = new Scanner(System.in);
      
      int numero;
      int i;
      int resultado;
      
      System.out.println("Digite um numero");
      numero = input.nextInt();
      
      System.out.println("Tabuada do número "+numero);
      for(i = 1; i <= 10; i++ ){
      resultado = numero * i;
      System.out.println(numero+ " x "+i+" = "+ resultado);
      }
      
  }  
}
