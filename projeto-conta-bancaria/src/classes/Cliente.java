package classes;

public class Cliente {
    private String nome;
    private long cpf;
    
    public Cliente(String nome, long cpf){
        this.nome = nome;
        this.cpf = cpf;

    }
    public String getNome() {
        return nome;
    }
    public long getCpf() {
        return cpf;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "nome: "+this.getNome()+" CPF: "+this.getCpf();
    }

}
