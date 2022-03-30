
/**
 *
 * @author kevin
 */

import fatec.poo.model.Circulo;
import java.util.Scanner;

public class Aplic {

    public static void main(String[] args) {
       
        Circulo objCirculo = new Circulo();
        Scanner entrada = new Scanner(System.in);
        
        double raio;
        int opcao;
        
        System.out.println("Informe o valor do raio");
        raio = entrada.nextDouble();
        
        objCirculo.setRaio(raio);
        
        do{
            
            System.out.println("\nEscolha uma opção");
            System.out.println("1- Calcular Area");
            System.out.println("2- Calcular Perimetro");
            System.out.println("3- Calcular Diametro");
            System.out.println("4- Calcular Area");
            
            opcao = entrada.nextInt();
            
            switch(opcao){
            
                case 1: System.out.println("O valor da area é " + objCirculo.calcArea());  
                break;
                
                case 2: System.out.println("O valor do perimetro é " + objCirculo.calcPerimetro());
                break;
                
                case 3: System.out.println("O valor do diametro é " + objCirculo.calcDiametro());
                break;
                
            
            }
            
        
        }while(opcao < 4);
        
        
    }
    
}
