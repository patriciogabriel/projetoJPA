package abstratas;

abstract public class dao<T> {
    public void create(T objeto){
        Dados.getManager().getTransaction().begin();
        Dados.getManager().persist(objeto);
        Dados.getManager().getTransaction().commit();
    }
    
    public void update(T objeto){
        Dados.getManager().getTransaction().begin();
        Dados.getManager().merge(objeto);
        Dados.getManager().getTransaction().commit();
    }
    
    public void delete(T objeto){
        Dados.getManager().getTransaction().begin();
        Dados.getManager().remove(objeto);
        Dados.getManager().getTransaction().commit();
    }
    
    public T read(Class<T> classeRetorno, int id){
        return Dados.getManager().find(classeRetorno, id);
    }
}
    