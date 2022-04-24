
import fatec.poo.model.Aluno;
import fatec.poo.model.Professor;
import java.text.DecimalFormat;

/**
 *
 * @author Luiz
 */
public class Aplic {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.00");

        Aluno objAluno = new Aluno(1010, "Carlos Silveira", "15/03/1978");

        Professor objProfessor = new Professor(1025, "Juca de Almeida", "04/07/1953");

        objAluno.setMensalidade(1500);
        objProfessor.setSalario(5000);

        System.out.println("-----Aluno--------");
        System.out.println(
                "Registro Escolar : "
                + objAluno.getRegEscolar()
        );
        System.out.println(
                "Nome             : "
                + objAluno.getNome()
        );
        System.out.println(
                "Data Nascimento  : "
                + objAluno.getDataNascimento()
        );
        System.out.println(
                "Mensalidade      : "
                + df.format(objAluno.getMensalidade())
        );

        System.out.println("\n-----Professor--------");
        System.out.println(
                "Registro Funcional : "
                + objProfessor.getRegFuncional()
        );
        System.out.println(
                "Nome               :"
                + objProfessor.getNome()
        );
        System.out.println(
                "Data de Nascimento :"
                + objProfessor.getDataNascimento()
        );
        System.out.println(
                "Salário            :"
                + df.format(objProfessor.getSalario())
        );

    }

}
