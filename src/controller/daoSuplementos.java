package controller;

import abstratas.Dados;
import abstratas.dao;
import java.util.List;
import javax.persistence.Query;
import model.Suplementos;

public class daoSuplementos extends dao<Suplementos>{
    public List<Suplementos> read(){
        String JPQL="select s from Suplementos s order by s.nome";
        Query query =  Dados.getManager().createQuery(JPQL);
        return query.getResultList();
    }
    
    public List<Suplementos> readByNome(String filtro){
        String JPQL = "select s from Suplementos s where s.nome like ?1 order by s.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1, "%" + filtro.toUpperCase() + "%");
        return query.getResultList();
    }
    
    public List<Suplementos> readByMarca(String filtro){
        String JPQL = "select s from Suplementos s where s.marca like ?1 order by s.marca";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1, "%" + filtro.toUpperCase() + "%");
        return query.getResultList();
    }
}
