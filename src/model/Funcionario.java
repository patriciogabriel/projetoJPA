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
    private int id;
    
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    
    @Column(name = "admissao", nullable = false)
    private LocalDate admissao;
    
    @Column(name = "salario", nullable = false)
    private int salario;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "cargo", nullable = false)
    private Cargo cargo;

    public Funcionario() {
        this.setId(0);
        this.setNome("SEM NOME");
        this.setAdmissao(LocalDate.now());
        this.setSalario(0);
        this.setCargo(Cargo.A);
    }

    public Funcionario(int id, String nome, LocalDate admissao, int salario, Cargo cargo) {
        this.setId(id);
        this.setNome(nome);
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
