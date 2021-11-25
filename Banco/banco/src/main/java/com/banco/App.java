package com.banco;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.banco.Model.Categoria;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Categoria model = new Categoria();
        model.setNome("teste Jpa");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("banco");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(model);
        em.getTransaction().commit();

        List<Categoria> lista = em.createQuery("SELECT c FROM Categoria c ORDER By c.id ASC",Categoria.class).getResultList();
        for (Categoria categoria : lista) {
            System.out.println(categoria.getId()+"-"+categoria.getNome());
        }

    }
}
