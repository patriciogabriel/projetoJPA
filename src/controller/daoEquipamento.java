package controller;

import abstratas.Dados;
import abstratas.dao;
import java.util.List;
import javax.persistence.Query;
import model.Equipamento;

public class daoEquipamento extends dao<Equipamento>{
    public List<Equipamento> read(){
        String JPQL="select e from Equipamento e order by e.nome";
        Query query =  Dados.getManager().createQuery(JPQL);
        return query.getResultList();
    }
}
