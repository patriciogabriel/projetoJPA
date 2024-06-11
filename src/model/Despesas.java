package model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_despesas")
public class Despesas implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    
    @Column(name = "valor", nullable = false)
    private int valor;
    
    @Column(name = "data", nullable = false)
    private LocalDate data;
    
    @Column(name = "descricao", length = 150, nullable = false)
    private String descricao;

    public Despesas() {
        this.setId(0);
        this.setNome("SEM NOME");
        this.setValor(0);
        this.setData(LocalDate.now());
        this.setDescricao("SEM DESCRIÇÃO");
    }

    public Despesas(int id, String nome, int valor, LocalDate data, String descricao) {
        this.setId(id);
        this.setNome(nome);
        this.setValor(valor);
        this.setData(data);
        this.setDescricao(descricao);
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "SEM NOME" : nome.toUpperCase();
    }

    public void setValor(int valor) {
        this.valor = valor < 0 ? 1 : valor;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public int getValor() {
        return this.valor;
    }

    public LocalDate getData() {
        return this.data;
    }

    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Nome: " + this.nome;
    } 
}