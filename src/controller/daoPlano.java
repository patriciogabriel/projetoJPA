package controller;

import abstratas.Dados;
import abstratas.dao;
import java.util.List;
import javax.persistence.Query;
import model.Plano;

public class daoPlano extends dao<Plano>{
    public List<Plano> read(){
        String JPQL="select p from Plano p order by p.nome";
        Query query =  Dados.getManager().createQuery(JPQL);
        return query.getResultList();
    }
}
