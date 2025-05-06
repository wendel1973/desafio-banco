package classes;

public class Main {
    public static void main(String[] args) {
        Cliente jose = new Cliente("Jose", 123456);
        Cliente carlos = new Cliente("Carlos", 789456);
        Cliente aparecido = new Cliente("Aparecido", 643215);
        ContaCorrente conta = new ContaCorrente(jose, "Corrente");
        ContaCorrente conta2 = new ContaCorrente(carlos, "Corrente");
        ContaCorrente conta3 = new ContaCorrente(aparecido, "Corrente");
        ContaPoupanca conta4 = new ContaPoupanca(aparecido, "Poupança");
        ContaPoupanca conta5 = new ContaPoupanca(jose, "Poupança");
        ContaPoupanca conta6 = new ContaPoupanca(aparecido, "Poupança");
        
        conta.depositar(100d);
        conta.transferir(50d, conta2);
        conta3.depositar(150d);
        conta2.depositar(300d);
        conta2.transferir(65d, conta);
        conta4.depositar(400d);
        conta5.depositar(1000d);
        conta6.depositar(2000d);
        conta6.transferir(65d, conta4);
        conta6.transferir(50d, conta3);

        
        conta.imprimirExtrato();
        conta2.imprimirExtrato();
        conta3.imprimirExtrato();
        conta4.imprimirExtrato();
        conta5.imprimirExtrato();
        conta6.imprimirExtrato();

        System.out.println();
        System.out.println();

        System.out.println("+++++CLIENTES DO BANCO+++++++");
        conta.relacaoClientes();

        
    }
    

    

}
