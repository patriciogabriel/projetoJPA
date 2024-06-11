package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supementos")
public class Suplementos implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    
    @Column(name = "valor", nullable = false)
    private double valor;
    
    @Column(name = "cliente", nullable = false)
    private boolean cliente;

    public Suplementos() {
        this.setId(0);
        this.setNome("SEM NOME");
        this.setValor(0.01);
        this.setCliente(false);
    }

    public Suplementos(int id, String nome, double valor, boolean cliente) {
        this.setId(id);
        this.setNome(nome);
        this.setValor(valor);
        this.setCliente(cliente);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "SEM NOME" : nome.toUpperCase();
    }

    public void setValor(double valor) {
        this.valor = valor < 0 ? 0.01 : valor;
    }

    public void setCliente(boolean cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public double getValor() {
        return this.valor;
    }

    public boolean isCliente() {
        return this.cliente;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Nome: " + this.nome;
    }  
}
