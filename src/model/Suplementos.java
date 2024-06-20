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
    @SwingColumn(description = "Código")
    private int id;
    
    @Column(name = "nome", length = 100, nullable = false)
    @SwingColumn(description = "Nome")
    private String nome;
    
    @Column(name = "valor", nullable = false)
    @SwingColumn(description = "Valor")
    private double valor;
    
    @Column(name = "marca", nullable = false)
    @SwingColumn(description = "Marca")
    private String marca;

    public Suplementos() {
        this.setId(0);
        this.setNome("SEM NOME");
        this.setValor(0.01);
        this.setMarca("SEM MARCA");
    }

    public Suplementos(int id, String nome, double valor, String marca) {
        this.setId(id);
        this.setNome(nome);
        this.setValor(valor);
        this.setMarca(marca);
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

    public void setMarca(String marca) {
        this.marca = marca.trim().isEmpty() ? "SEM MARCA" : marca.toUpperCase();
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

    public String getMarca() {
        return marca;
    }
    
    @Override
    public String toString() {
        return "ID: " + this.id + ", Nome: " + this.nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
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
        final Suplementos other = (Suplementos) obj;
        return this.id == other.id;
    }
}
