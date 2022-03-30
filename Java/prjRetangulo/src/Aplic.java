
import fatec.poo.model.Retangulo;
import java.util.Scanner;

/**
 *
 * @author matheusBarth
 */
public class Aplic {

    public static void main(String[] args) {
        //Instanciação de um objeto da classe  Scanner
        Scanner entrada = new Scanner(System.in);

        //Instanciação de um objeto da classe Retangulo
        Retangulo objRet = new Retangulo();

        double medAlt, medBase;
        int opcao;

        System.out.println("Digite a medida da altura: ");
        medAlt = entrada.nextDouble(); //scanf("%lf", &medAlt);
        System.out.println("Digite a medida da base: ");
        medBase = entrada.nextDouble(); //scanf("%lf", &medBase);

        objRet.setAltura(medAlt);
        objRet.setBase(medBase);

        do {
            System.out.println("\n1-Consultar Área");
            System.out.println("2-Consultar Perimetro");
            System.out.println("3-Consultar Diagonal");
            System.out.println("4-Sair");
            System.out.print("\n\tDigite sua opção?: ");
            opcao = entrada.nextInt();//scanf("%d", &opcao)

            System.out.println("\n\nMedida da altura: " + objRet.getAltura());
            System.out.println("Medida da base: " + objRet.getBase());

            switch (opcao) {
                case 1:
                    System.out.println("\nMedida da Área: " + objRet.calcArea());
                    break;
                case 2:
                    System.out.println("\nMedida do Perimetro: " + objRet.calcPerimetro());
                    break;
                case 3:
                    System.out.println("\nMedida da Diagonal: " + objRet.calcDiagonal());
                    break;
            }
        } while (opcao < 4); //passagem de mensagens
    }
}
