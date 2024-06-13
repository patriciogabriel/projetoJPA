package controller;

import abstratas.Dados;
import abstratas.dao;
import java.util.List;
import javax.persistence.Query;
import model.Despesas;

public class daoDespesas extends dao<Despesas>{
    public List<Despesas> read(){
        String JPQL="select d from Despesas d order by d.nome";
        Query query =  Dados.getManager().createQuery(JPQL);
        return query.getResultList();
    }
    
    public List<Despesas> readByNome(String filtro){
        String JPQL = "select d from Despesas d where d.nome like ?1 order by d.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1, "%" + filtro.toUpperCase() + "%");
        return query.getResultList();
     }
    
    public List<Despesas> readByDescricao(String filtro){
        String JPQL = "select d from Despesas d where d.descricao like ?1 order by d.descricao";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1, "%" + filtro.toUpperCase() + "%");
        return query.getResultList();
     }
}
