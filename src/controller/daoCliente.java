package controller;

import abstratas.Dados;
import abstratas.dao;
import java.util.List;
import javax.persistence.Query;
import model.Cliente;
import model.Plano;

public class daoCliente extends dao<Cliente>{
    public List<Cliente> read(){
        String JPQL="select c from Cliente c order by c.nome";
        Query query =  Dados.getManager().createQuery(JPQL);
        return query.getResultList();
    }
    
    public List<Cliente> readByNome(String filtro){
        String JPQL = "select c from Cliente c where c.nome like ?1 order by c.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1, "%" + filtro.toUpperCase() + "%");
        return query.getResultList();
     }
    
    public List<Cliente>readByPlano(Plano p){
        String JPQL="select c from Cliente c where c.plano = ?1 order by c.plano.nome";
        Query query = Dados.getManager().createQuery(JPQL);
        query.setParameter(1,p);
        return query.getResultList();
    }
}
