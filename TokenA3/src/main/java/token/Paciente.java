package main.java.token;
public class Paciente {
    private String cpf;
    private String nome;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Paciente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

   


    
}
