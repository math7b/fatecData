

package fatec.poo.model;

/**
 *
 * @author kevin
 */
public class Aluno {
    
    private int RA;
    private double NtPrv1;
    private double NtPrv2;
    private double NtTrab1;
    private double NtTrab2;
    
    public void setRA(int valorRA){
        
        RA = valorRA;
        
    }
    
    public void setNtPrv1(double valorNota1){
    
        NtPrv1 = valorNota1;
        
    }
    
    public void setNtPrv2(double valorNota2){
    
        NtPrv2 = valorNota2;
    
    }
    
    public void SetNtTrab1(double valorTrab1){
        
        NtTrab1 = valorTrab1;
    }
    
    public void SetNtTrab2(double valorTrab2){
    
        NtTrab2 = valorTrab2;
        
    }
    
    public int getRA(){
        return RA;
        
    }
    
    public double getNtPrv1(){
        return NtPrv1;
    }
    
    public double getNtPrv2(){
        return NtPrv2;
    }
    
    public double getNtTrab1(){
         return NtTrab1;
     }
     
    public double getNtTrab2(){
         return NtTrab2;
     }
    
    public double calcMediaProva(){
        
        return 0.75 * (NtPrv1 + (2 * NtPrv2))/3;
        
    }
    
    public double calcMediaTrab(){
        
        return 0.25 *(NtTrab1 + NtTrab2)/2;
        
    }
    
    public double calcMediaFinal(){
        
        return calcMediaProva() + calcMediaTrab();
        
    }
    
    
    
}
