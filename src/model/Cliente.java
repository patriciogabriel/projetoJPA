package model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements java.io.Serializable {
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
    
    @Column(name = "nascimento", nullable = false)
    @SwingColumn(description = "Nascimento")
    private LocalDate nascimento;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_plano", nullable = false, referencedColumnName = "id")
    @SwingColumn(description = "Plano")
    private Plano plano;
    
    public Cliente(){
        this.setId(0);
        this.setNome("");
        this.setCpf("000.000.000-00");
        this.setNascimento(null);
        this.setPlano(null);
    }
    
    public Cliente(int id, String nome, String cpf, LocalDate nascimento, Plano plano) {
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setNascimento(nascimento);
        this.setPlano(plano);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "SEM NOME": nome.toUpperCase();
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.trim().isEmpty() ? "000.000.000-00" : cpf;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento == null ? LocalDate.now() : nascimento;
    }

    public void setPlano(Plano plano) {
        this.plano = plano == null? new Plano() : plano;
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

    public LocalDate getNascimento() {
        return this.nascimento;
    }

    public Plano getPlano() {
        return this.plano;
    }

    @Override
    public String toString() {
        return "Nome:" + this.nome + ", CPF: " + this.cpf;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
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
        final Cliente other = (Cliente) obj;
        return this.id == other.id;
    }   
}
