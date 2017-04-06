/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.Categoria;

import com.airhacks.AbstractManager;
import com.airhacks.Utente.Utente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
public class CategoriaManager extends AbstractManager {

    @PersistenceContext
    EntityManager em;

    /*
        La funzione findCategoria riceve in input un Utente e lancia una serie di query per ritrovare tutte le
        categorie utilizzate nelle spese da lui effettuate
     */
    public List<Categoria> findCategoria(Utente u) {
        return em.createNamedQuery(Categoria.FIND_BY_IDUTENTE, Categoria.class)
                .setParameter("idUtente", u)
                .getResultList();
    }
}
