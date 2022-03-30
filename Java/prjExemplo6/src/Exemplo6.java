
/**
 *
 * @author matheusBarth
 */
public class Exemplo6 {

    public static void main(String[] args) {
        int[] TabNum; //Declaração
        int Cont;

        TabNum = new int[3]; //criação

        TabNum[0] = 34;
        TabNum[1] = 18;
        TabNum[2] = 27;

        for (Cont = 0; Cont < 3; Cont++) {
            System.out.print("Conteudo de TabNum[" + Cont + "]=");
            System.out.println(TabNum[Cont]);
        }
    }

}
