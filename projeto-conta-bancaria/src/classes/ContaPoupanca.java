package classes;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente cliente, String tipoConta){
        super(cliente, tipoConta);
              
    }

    public void imprimirExtrato(){
        System.out.println("=========Extrato Conta Poupança==========");
        super.imprimirInfosComuns();
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    @Override
    public int getAgencia() {
        // TODO Auto-generated method stub
        return super.getAgencia();
    }

}
