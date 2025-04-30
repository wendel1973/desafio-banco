package classes;

public class Main {
    public static void main(String[] args) {
        Cliente jose = new Cliente("Jose", 123456);
        Cliente carlos = new Cliente("Carlos", 789456);
        Cliente aparecido = new Cliente("Aparecido", 643215);
        ContaCorrente conta = new ContaCorrente(jose);
        ContaCorrente conta2 = new ContaCorrente(carlos);
        ContaCorrente conta3 = new ContaCorrente(aparecido);
        
        conta.depositar(100d);
        conta.transferir(50d, conta2);
        conta3.depositar(150d);
        conta2.depositar(300d);
        conta2.transferir(65d, conta);

        
       // System.out.println("Agencia: "+ conta.getAgencia()+" - Conta: "+conta.getNumeroConta()+ " Cliente: "+conta.cliente +" Saldo: "+ conta.getSaldo());

        
        //System.out.println("Agencia: "+ conta2.getAgencia()+" - Conta: "+conta2.getNumeroConta()+ " Cliente: "+conta2.cliente +" Saldo: "+ conta2.getSaldo());

     
       // System.out.println("Agencia: "+ conta3.getAgencia()+" - Conta: "+conta3.getNumeroConta()+ " Cliente: "+conta3.cliente +" Saldo: "+ conta3.getSaldo());

       conta.imprimirExtrato();
       conta2.imprimirExtrato();
       conta3.imprimirExtrato();

       System.out.println();
       System.out.println();

       System.out.println("+++++CLIENTES DO BANCO+++++++");
       System.out.println(conta.listaClientes);
        
    }
    

    

}
