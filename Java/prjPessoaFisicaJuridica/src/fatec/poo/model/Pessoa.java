package fatec.poo.model;

/**
 *
 * @author matheusBarth
 */
public abstract class Pessoa {

    private String nome;
    private int anoInscricao;
    private double totalCompras;

    public Pessoa(String nome, int anoInscricao) {
        this.nome = nome;
        this.anoInscricao = anoInscricao;
    }

    abstract public double calcBonus(int anoAtual);

    public void addCompras(double valCompra) {
        this.totalCompras = +valCompra;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoInscricao() {
        return anoInscricao;
    }

    public double getTotalCompras() {
        return totalCompras;
    }

}
