
import fatec.poo.model.ContaCorrente;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Nicolas
 */
public class Aplic {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        int numero;
        int opcao = 0;
        double valor;
        
        System.out.println("Digite o número da conta: ");
        numero = entrada.nextInt();
       
        System.out.println("Digite o valor da conta");
        valor = entrada.nextDouble();
        
        ContaCorrente objContaCorrente = new ContaCorrente(numero,valor);
        
        do {
            System.out.println("\n1-Depositar");
            System.out.println("2-Sacar");
            System.out.println("3-Consultar o saldo");
            System.out.println("4-Sair");
            System.out.println("\t Digite a sua opção: ");
            
            opcao = entrada.nextInt();
            
            switch(opcao){
                case 1:
                    System.out.println("Digite o valor do deposito");
                    valor = entrada.nextDouble();
                    objContaCorrente.depositar(valor);
                    break;
                case 2:
                    System.out.println("Digite o valor do saque");
                    valor = entrada.nextDouble();
                    objContaCorrente.sacar(valor);
                    break;
                    
                case 3:
                    System.out.println("O saldo da conta n° "+objContaCorrente.getNumero()+
                            " é de "+df.format(objContaCorrente.getSaldo()));
                    break;
            }
        }while(opcao <4);
    }
    
}
