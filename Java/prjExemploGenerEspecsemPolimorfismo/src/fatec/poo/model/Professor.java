
package fatec.poo.model;

/**
 *
 * @author aluno
 */
public class Professor extends Pessoa {
    private int regFuncional;
    private double salario;
    

    public Professor(int regFuncional, String nome, String dataNascimento) {
        super(nome, dataNascimento);
        this.regFuncional = regFuncional;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public int getRegFuncional() {
        return regFuncional;
    }

    public double getSalario() {
        return salario;
    }

    
}
