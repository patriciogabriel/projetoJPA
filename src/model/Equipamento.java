package model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_equipameto")
public class Equipamento implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SwingColumn(description = "Código")
    private int id;
    
    @Column(name = "nome", length = 100, nullable = false)
    @SwingColumn(description = "Nome")
    private String nome;
    
    @Column(name = "compra", nullable = false)
    @SwingColumn(description = "Data de Compra")
    private LocalDate compra;
    
    @Column(name = "valor", nullable = false)
    @SwingColumn(description = "valor")
    private double valor;

    public Equipamento() {
        this.setId(0);
        this.setNome("SEM NOME");
        this.setCompra(LocalDate.now());
        this.setValor(0.01);
    }

    public Equipamento(int id, String nome, LocalDate compra, double valor) {
        this.setId(id);
        this.setNome(nome);
        this.setCompra(compra);
        this.setValor(valor);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "SEM NOME" : nome.toUpperCase();
    }

    public void setCompra(LocalDate compra) {
        this.compra = compra == null ? LocalDate.now() : compra;
    }

    public void setValor(double valor) {
        this.valor = valor < 0 ? 0 : valor;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public LocalDate getCompra() {
        return this.compra;
    }

    public double getValor() {
        return this.valor;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Nome: " + this.nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipamento other = (Equipamento) obj;
        return this.id == other.id;
    }
}
