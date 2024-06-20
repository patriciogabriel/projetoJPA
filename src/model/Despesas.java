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
    @SwingColumn(description = "Código")
    private int id;
    
    @Column(name = "nome", length = 100, nullable = false)
    @SwingColumn(description = "Nome")
    private String nome;
    
    @Column(name = "valor", nullable = false)
    @SwingColumn(description = "Valor")
    private double valor;
    
    @Column(name = "data", nullable = false)
    @SwingColumn(description = "Data")
    private LocalDate data;
    
    @Column(name = "descricao", length = 150, nullable = false)
    @SwingColumn(description = "Descrição")
    private String descricao;

    public Despesas() {
        this.setId(0);
        this.setNome("SEM NOME");
        this.setValor(0.01);
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

    public void setValor(double valor) {
        this.valor = valor < 0 ? 0.01 : valor;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.trim().isEmpty() ? "SEM DESCRIÇÃO" : descricao.toUpperCase();
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
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
        final Despesas other = (Despesas) obj;
        return this.id == other.id;
    } 
}
