package model;

import enums.Cargo;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario implements java.io.Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @SwingColumn(description = "Código")
    private int id;
    
    @Column(name = "nome", length = 100, nullable = false)
    @SwingColumn(description = "Nome")
    private String nome;
    
    @Column(name = "cpf", length = 15, nullable = false)
    @SwingColumn(description = "CPF")
    private String cpf;
    
    @Column(name = "admissao", nullable = false)
    @SwingColumn(description = "Admissão")
    private LocalDate admissao;
    
    @Column(name = "salario", nullable = false)
    @SwingColumn(description = "Salário")
    private int salario;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "cargo", nullable = false)
    @SwingColumn(description = "Cargo")
    private Cargo cargo;

    public Funcionario() {
        this.setId(0);
        this.setNome("SEM NOME");
        this.setCpf("000.000.000-00");
        this.setAdmissao(LocalDate.now());
        this.setSalario(0);
        this.setCargo(Cargo.A);
    }

    public Funcionario(int id, String nome, String cpf, LocalDate admissao, int salario, Cargo cargo) {
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setAdmissao(admissao);
        this.setSalario(salario);
        this.setCargo(cargo);
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "SEM NOME" : nome.toUpperCase();
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.trim().isEmpty() ? "000.000.000-00" : cpf;
    }

    public void setAdmissao(LocalDate admissao) {
        this.admissao = admissao == null ? LocalDate.now() : admissao;
    }

    public void setSalario(int salario) {
        this.salario = salario < 0 ? 1 : salario;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }
    
    public String getCpf() {
        return this.cpf;
    }
    
    public LocalDate getAdmissao() {
        return this.admissao;
    }

    public int getSalario() {
        return this.salario;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Nome: " + this.nome + ", Cargo: " + this.cargo;
    }
}
