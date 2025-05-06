package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public abstract class Conta {
    private static int SEQUENCIAL = 1;
    private static final int  AGENCIA = 12;
    protected int numeroConta;
    protected double saldo;
    protected String tipoConta;
    public Cliente cliente;
    public static Map<Cliente, List<String>> listaClientes = new HashMap<>();
    protected List<String> extrato = new ArrayList<>();

    public Conta(Cliente cliente, String tipoConta){
        this.numeroConta = SEQUENCIAL++;
        this.cliente = cliente;
        this.tipoConta=tipoConta;
        adicionarCliente();
        
        
    }
    public int getNumeroConta() {
        return numeroConta;
    }
    public  int getAgencia() {
        return AGENCIA;
    }
    public double getSaldo() {
        return saldo;
    }
    public String getTipoConta() {
        return tipoConta;
    }
    public void adicionarCliente(){
        List<String> dados = new ArrayList<>();
        dados.add(String.valueOf(AGENCIA));
        dados.add(String.valueOf(numeroConta));
        dados.add(String.valueOf(getTipoConta()));

              
       
        if (listaClientes.containsKey(cliente)){
            List<String> dadosAnteriores = new ArrayList<>();
            dadosAnteriores.addAll(listaClientes.get(cliente));
            for(String d:dadosAnteriores){
                dados.add(d);
                
            }
            listaClientes.put(cliente, dados);
                 
        }else{
            listaClientes.put(cliente, dados);
        }

    }
    public void depositar(double valor){
        if(valor > 0){
            saldo += valor;
            String dados = "Depósito - " + String.valueOf(valor);
            extrato.add(dados);
           
            
        }
    }
    public void sacar(double valor){
        if(this.getSaldo() >0 && this.getSaldo() >= valor){
            saldo -= valor;
            String dados = "Saque - " + String.valueOf(valor);
            extrato.add(dados);
            
        }else{
            throw new RuntimeException("Transação não permitida.");
        }
    }
    public void transferir(double valor, Conta conta){
        if(valor > 0){
            this.sacar(valor);
            conta.depositar(valor);
            
        }
    }
    protected void imprimirInfosComuns(){
        System.out.println("Agência "+ this.getAgencia());
        System.out.println("Conta "+ this.getNumeroConta());
        System.out.println("Cliente "+ this.cliente);
        System.out.println("***********************");
        this.extrato.forEach(n -> System.out.println(n));
        System.out.println("Saldo "+ this.getSaldo());
       
    }
    protected void relacaoClientes(){
        listaClientes.forEach(new BiConsumer<Cliente,List<String>>() {

            @Override
            public void accept(Cliente cliente, List<String> conta) {
                 System.out.println(cliente);
                 System.out.println("========Agência/Conta(s)/Tipo de Conta========");
                 System.out.println(conta);
                 System.out.println("----------------------------------------------");
            }
            
        });
    }
    
    
}



