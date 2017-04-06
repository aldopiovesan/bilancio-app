/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.Categoria;

import com.airhacks.AbstractREST;
import com.airhacks.Utente.Utente;
import com.airhacks.Utente.UtenteManager;
import com.airhacks.Variazione.VariazioneManager;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author tss
 */
@Path("Categoria")
@Stateless

public class CategoriaREST extends AbstractREST {

    @Inject
    CategoriaManager categoriamanager;
    
    @Inject
    UtenteManager utentemanager;

    @Inject
    VariazioneManager variazionemanager;

    @GET
    public List<Categoria> getCategoria() {
        long ID = 2;
        Utente finded = utentemanager.find(ID);
        return categoriamanager.findCategoria(finded);
    }
}
