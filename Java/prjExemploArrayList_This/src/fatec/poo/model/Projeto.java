
package fatec.poo.model;

/**
 *
 * @author Dimas
 */

public class Projeto {
    private int codigo;
    private String descricao;
    private String dtInicio;
    private String dtTermino;
    private Funcionario[] funcionarios; //multiplicidade 1..*
    private int numFunc;

    public Projeto(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
        funcionarios = new Funcionario[10];
        numFunc = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDtInicio() {
        return dtInicio;
    }

    public String getDtTermino() {
        return dtTermino;
    }

    public void setDtInicio(String dtInicio) {
        this.dtInicio = dtInicio;
    }

    public void setDtTermino(String dtTermino) {
        this.dtTermino = dtTermino;
    }
    public void addFuncionario(Funcionario f){ 
        funcionarios[numFunc] = f;
	numFunc++;
    }
    public void listarFuncionarios(){
        System.out.println("\n\nCódigo: " + codigo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Data de Inicio: " + dtInicio);
        System.out.println("Data de termino: " + dtTermino);
        System.out.println("Qtde. Funcionários: " + numFunc);
        System.out.println("\nRegistro\t\tNome\t\t\tCargo\t\tDepartamento");
        
        for(int x =0; x < numFunc;x++){
            System.out.print(funcionarios[x].getRegistro());
            System.out.print("\t\t" + funcionarios[x].getNome());
            System.out.print("\t\t" + funcionarios[x].getCargo());                        
            System.out.println("\t\t" + funcionarios[x].getDepartamento().getNome());
        }
    }
    
}
