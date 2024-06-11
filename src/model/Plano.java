package model;

import enums.Assinatura;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_plano")
public class Plano implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    
    @Column(name = "valor", nullable = false)
    private int valor;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "assinatura", nullable = false)
    private Assinatura assinatura;

    public Plano() {
        this.setId(0);
        this.setNome("SEM NOME");
        this.setValor(0);
        this.setAssinatura(Assinatura.A);
    }

    public Plano(int id, String nome, int valor, Assinatura assinatura) {
        this.setId(id);
        this.setNome(nome);
        this.setValor(valor);
        this.setAssinatura(assinatura);
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

    public void setAssinatura(Assinatura assinatura) {
        this.assinatura = assinatura;
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

    public Assinatura getAssinatura() {
        return this.assinatura;
    }

    @Override
    public String toString() {
        return "Plano: " + this.nome + ", Valor: " + this.valor;
    }   
}
