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
}
