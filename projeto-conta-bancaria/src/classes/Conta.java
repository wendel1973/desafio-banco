package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Conta {
    private static int SEQUENCIAL = 1;
    private static final int  AGENCIA = 12;
    protected int numeroConta;
    protected double saldo;
    public Cliente cliente;
    public static Map<Cliente, String> listaClientes = new HashMap<>();
    protected List<String> extrato = new ArrayList<>();

    public Conta(Cliente cliente){
        this.numeroConta = SEQUENCIAL++;
        this.cliente = cliente;
        String dados = String.valueOf(AGENCIA) + " " + String.valueOf(numeroConta);
        listaClientes.put(cliente, dados);
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

    
}



