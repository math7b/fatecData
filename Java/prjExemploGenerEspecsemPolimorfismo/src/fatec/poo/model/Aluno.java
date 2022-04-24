package fatec.poo.model;

/**
 *
 * @author Luiz
 */
public class Aluno extends Pessoa {
    private int regEscolar;
    private double mensalidade;

    public Aluno(int regEscolar, String nome, String dataNascimento) {
        super(nome, dataNascimento); // chamada do método construtor da superclasse
        this.regEscolar = regEscolar;
    }
    
    public double getMensalidade() {
        return mensalidade;
    }

    public int getRegEscolar() {
        return regEscolar;
    }
    
    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }
    
    
}
