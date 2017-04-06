/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks;

import com.airhacks.Categoria.CategoriaManager;
import com.airhacks.Utente.UtenteManager;
import com.airhacks.Variazione.VariazioneManager;
import javax.inject.Inject;

/**
 *
 * @author tss
 */
public abstract class AbstractREST {

    @Inject
    CategoriaManager categoriamanager;
    
    @Inject
    UtenteManager utentemanager;

    @Inject
    VariazioneManager variazionemanager;
}
