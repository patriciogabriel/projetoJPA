package controller;

import abstratas.Dados;
import abstratas.dao;
import java.util.List;
import javax.persistence.Query;
import model.Funcionario;

public class daoFuncionario extends dao<Funcionario>{
    public List<Funcionario> read(){
        String JPQL="select f from Funcionario f order by f.nome";
        Query query =  Dados.getManager().createQuery(JPQL);
        return query.getResultList();
    }
    
    public List<Funcionario> readByNome(String filtro){
        String JPQL = "select f from Funcionario f where f.nome like ?1 order by f.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1, "%" + filtro.toUpperCase() + "%");
        return query.getResultList();
     }
    
    public List<Funcionario> readByCpf(String filtro){
        String JPQL="select f from Funcionario f where f.cpf = ?1";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1,filtro);
        return query.getResultList();
    }
}
