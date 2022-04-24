package fatec.poo.model;

/**
 *
 * @author maheusBarth
 */
public class PessoaFisica extends Pessoa {

    private String cpf;
    private double base;

    public PessoaFisica(String cpf, String nome, int anoInscricao) {
        super(nome, anoInscricao);
        this.cpf = cpf;
    }

    @Override
    public double calcBonus(int anoAtual) {
        if (getTotalCompras() > 12000) {
            return (anoAtual - getAnoInscricao()) * base;
        } else {
            return 0;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getBase() {
        return base;
    }

}
