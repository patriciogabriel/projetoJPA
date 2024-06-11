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
}
