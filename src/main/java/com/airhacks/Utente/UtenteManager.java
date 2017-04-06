/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.Utente;

import com.airhacks.AbstractManager;
import com.airhacks.Categoria.Categoria;
import com.airhacks.Result;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

/**
 *
 * @author tss
 */
@Stateless
public class UtenteManager extends AbstractManager
{

    @PersistenceContext
    EntityManager em;

    
    //This function receives an user as input. First it checks if this user has valid data; then it checks if this user is present in the database.
    //Result is sent to the calling function via a Result object
    public Result addUtente(Utente u)
    {
        Result result;

        if (
                (u.getMail().compareTo("") == 0) ||
                (u.getNome().compareTo("") == 0) ||
                (u.getPwd().compareTo("") == 0)
            )
        {
            result = new Result(this.FAILURE_DATA_NOT_VALID);
        }
        else
        {
            Utente finded = findByMail(u.getMail());
            if (finded == null)
            {
                result = new Result(this.SUCCESS);
                em.merge(u);
            }
            else
            {
                result = new Result(this.FAILURE_DATA_ALREADY_PRESENT);
            }
        }
        return result;
    }

    public List<Utente> findAll()
    {
        return em.createNamedQuery(Utente.FIND_ALL)
                .getResultList();
    }

    public void delete(Long id)
    {
        Utente finded = em.find(Utente.class, id);
        em.remove(finded);
    }

    public Utente find(Long id)
    {
        return em.createNamedQuery(Utente.FIND_BY_ID, Utente.class)
                .setParameter("idUtente", id)
                .getSingleResult();
    }

    public Utente findByMailAndPwd(String mail, String pwd)
    {
        return em.createNamedQuery(Utente.FIND_BY_MAIL_PWD, Utente.class)
                .setParameter("mail", mail)
                .setParameter("pwd", pwd)
                .getSingleResult();
    }

    public Utente findByMail(String mail)
    {
        Utente result = null;
        System.out.println("\n_____\n\n" + "Avvio la ricerca ora. La mail è " + mail + "\n_____\n\n");
        try
        {
            result = em.createNamedQuery(Utente.FIND_BY_MAIL, Utente.class)
                    .setParameter("mail", mail)
                    .getSingleResult();
        }
        catch (NoResultException ex)
        {
        }
        return result;
    }
}
