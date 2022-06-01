package fatec.poo.model;

/**
 *
 * @author Dimas
 */
public class PropostaSeguro {

    private String nome;
    private double valorCarro;
    private double valorBase;
    private boolean sexo;//F-false  M-true
    private int faixaIdade;//0-abaixo de 26 anos 1-de 26 a 35 anos 2-Acima de 35 anos
    private boolean perfilMotorista;
    private boolean perfilCidade;

    public PropostaSeguro(String nome, double valorCarro) {
        this.nome = nome;
        this.valorCarro = valorCarro;
        valorBase = 0.10 * this.valorCarro;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public void setFaixaIdade(int faixaIdade) {
        this.faixaIdade = faixaIdade;
    }

    public void setPerfilMotorista(boolean perfilMotorista) {
        this.perfilMotorista = perfilMotorista;
    }

    public void setPerfilCidade(boolean perfilCidade) {
        this.perfilCidade = perfilCidade;
    }

    public String getNome() {
        return nome;
    }

    public double getValorBase() {
        return valorBase;
    }

    public double calcDescSexo() {
        if (sexo == false) {//feminino
            return (valorBase * 0.075);
        } else {
            return (0);
        }
    }

    public double calcDescIdade() {
        double desc = 0; //abaixo de 26 anos
        if (faixaIdade == 1) { //de 26 a 35 anos
            desc = 0.025 * valorBase;
        } else if (faixaIdade == 2) {//acima de 35 anos
            desc = 0.037 * valorBase;
        }
        return (desc);
    }

    public double calcDescPerfilMotorista() {
        if (perfilMotorista) {
            return (0.015 * valorBase);
        } else {
            return (0);
        }
    }

    public double calcDescPerfilCidade() {
        if (perfilCidade) {
            return (0.018 * valorBase);
        } else {
            return (0);
        }
    }

    public double calcSeguro() {
        return (valorBase - calcDescSexo() - calcDescIdade()
                - calcDescPerfilMotorista() - calcDescPerfilCidade());
    }
}
