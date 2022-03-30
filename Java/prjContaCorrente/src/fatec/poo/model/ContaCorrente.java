package fatec.poo.model;

/**
 *
 * @author Nicolas
 */
public class ContaCorrente {
    private int numero;
    private double saldo;

    public ContaCorrente(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void sacar(double valor){
        if(saldo < valor){
            System.out.println("Saldo insuficiente");
        }else{
            saldo -= valor;
            System.out.println(valor + " foi sacado da conta n° "+numero);
        }
       
    }
    
    public void depositar(double valor){
        saldo+= valor;
        System.out.println(valor + " foi depositado da conta n° "+numero);
    }
    
}
