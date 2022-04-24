
import fatec.poo.model.FuncionarioHorista;
import fatec.poo.model.FuncionarioMensalista;
import java.text.DecimalFormat;

/**
 *
 * @author matheusBarth
 */
public class Aplic {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.00");

        FuncionarioHorista funcHor = new FuncionarioHorista(
                1010,
                "Sim",
                "14/05/1978",
                15.80,
                "Horista"
        );

        FuncionarioMensalista funcMen = new FuncionarioMensalista(
                2020,
                "Yes",
                "14/05/1978",
                600.0,
                "Mensalista"
        );

        funcHor.setQtdeHorTrab(90);
        funcHor.setCargo("Programador");

        
        System.out.println("\n\nRegistro        => " + funcHor.getRegistro());
        System.out.println("Nome            => " + funcHor.getNome());
        System.out.println("getDtAdmissao   => " + funcHor.getDtAdmissao());

        System.out.println("\n\nRegistro    => " + funcMen.getRegistro());
        System.out.println("Nome            => " + funcMen.getNome());
        System.out.println("getDtAdmissao   => " + funcMen.getDtAdmissao());

        System.out.println("Salário Bruto   => " + df.format(funcHor.calcSalBruto()));
        System.out.println("Desconto        => " + df.format(funcHor.calcDesconto()));
        System.out.println("Salário Liquido => " + df.format(funcHor.calcSalLiquido()));
        System.out.println("Gradificação    => " + df.format(funcHor.calcGradificacao()));

    }

}
