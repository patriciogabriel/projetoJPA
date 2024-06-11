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
}
