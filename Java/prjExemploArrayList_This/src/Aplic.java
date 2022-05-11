import fatec.poo.model.Departamento;
import fatec.poo.model.FuncionarioComissionado;
import fatec.poo.model.FuncionarioHorista;
import fatec.poo.model.FuncionarioMensalista;
import fatec.poo.model.Projeto;

/**
 *
 * @author Dimas
 */
public class Aplic {
    public static void main(String[] args) {
        FuncionarioHorista funcHor  = new FuncionarioHorista(1010,
                                                             "Pedro Silveira",
                                                             "14/05/78",
                                                             15.80);
        
        funcHor.setCargo("Programador");
        
        FuncionarioMensalista funcMen  = new FuncionarioMensalista(2020,
                                                                   "Ana Beatriz",
                                                                   "22/07/88",
                                                                   600);
        
        funcMen.setCargo("Aux. Administrativo");
        
        FuncionarioComissionado funcCom = new FuncionarioComissionado(3030, 
                                                                     "Joao Mendes",
                                                                     "10/12/1975",
                                                                     10);
        funcCom.setCargo("Vendedor");
       
        //Instanciação de objetos da 
        //classe Departamento    
        Departamento objDep1 = new Departamento("RH", "Recursos Humanos");
        Departamento objDep2 = new Departamento("VD", "Vendas");
      
	//instanciação de  um objeto da 
        //classe Projeto
        Projeto objPrj = new Projeto(1234, "Segurança no Trabalho");
        objPrj.setDtInicio("02/05/2022");
        objPrj.setDtTermino("22/05/2022"); 
            
        //estabelecendo a associação binária
        //entre Departamento e FuncionarioHorista, 
        //FuncionarioMensalista e FuncionarioComissionado   
        objDep1.addFuncionario(funcHor);
        objDep1.addFuncionario(funcMen);
        objDep2.addFuncionario(funcCom);
       
        System.out.println("O funcionário horista " + funcHor.getNome() +
                           " trabalha no deparamento " + funcHor.getDepartamento().getNome());
        System.out.println("O funcionário mensalista " + funcMen.getNome() +
                           " trabalha no departamento " + funcMen.getDepartamento().getNome());
        System.out.println("O funcionário comissionado " + funcCom.getNome() +
                           " trabalha no departamento " +  funcCom.getDepartamento().getNome());
      
        objDep1.listarFuncionarios();
        objDep2.listarFuncionarios();
       
        //estabelecendo a associação binária
        //entre Projeto e FuncionarioHorista, 
        //FuncionarioMensalista e FuncionarioComissionado   
        objPrj.addFuncionario(funcHor);
        objPrj.addFuncionario(funcMen);
        objPrj.addFuncionario(funcCom);

        objPrj.listarFuncionarios();
    }    
}
