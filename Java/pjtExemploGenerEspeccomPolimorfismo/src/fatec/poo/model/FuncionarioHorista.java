package fatec.poo.model;

/**
 *
 * @author matheusBarth
 */
public class FuncionarioHorista extends Funcionario {

    private double valHorTrab;
    private int qtdeHorTrab;

    public FuncionarioHorista(int registro, String nome, String dtAdmissao, double valHorTrab, String cargo) {
        super(registro, nome, dtAdmissao);

        this.valHorTrab = valHorTrab;
    }

    public void setQtdeHorTrab(int qtdeHorTrab) {
        this.qtdeHorTrab = qtdeHorTrab;
    }

    @Override
    public double calcSalBruto() {
        return (valHorTrab * qtdeHorTrab);
    }

    public double calcGradificacao() {
        return (0.75 * valHorTrab);
    }

    @Override
    public double calcSalLiquido() {
        return (valHorTrab * qtdeHorTrab) + calcGradificacao() - 0.10;
    }
}
