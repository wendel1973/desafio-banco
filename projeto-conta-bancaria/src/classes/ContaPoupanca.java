package classes;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente cliente, String tipoConta){
        super(cliente, tipoConta);
              
    }

    public void imprimirExtrato(){
        System.out.println("=========Extrato Conta Poupança==========");
        super.imprimirInfosComuns();
    }
    

}
