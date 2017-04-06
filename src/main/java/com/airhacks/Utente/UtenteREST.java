/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.Utente;

import com.airhacks.AbstractREST;
import com.airhacks.Categoria.Categoria;
import com.airhacks.Categoria.CategoriaManager;
import com.airhacks.Result;
import static com.airhacks.Result.result.FAILURE_DATA_ALREADY_PRESENT;
import static com.airhacks.Result.result.SUCCESS;
import com.airhacks.Variazione.VariazioneManager;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author tss
 */
@Path("Utente")
@Stateless
public class UtenteREST extends AbstractREST {

    @Inject
    CategoriaManager categoriamanager;

    @Inject
    UtenteManager utentemanager;

    @Inject
    VariazioneManager variazionemanager;

    @GET
    @Path("Login")
    public void ciao() {
        System.out.println("Ciao");
    }

    @POST
    @Path("Login")
    @Consumes(MediaType.APPLICATION_JSON)

    public Response login(Utente u) {
        System.out.println("Tentativo di login. L'utente dice di essere " + u.getMail());
        // System.out.println("login"+u);
        if (u == null) {
            return Response.serverError().header("errore", "erroreeee").build();
        }
        Utente finded = utentemanager.findByMailAndPwd(u.getMail(), u.getPwd());

        if (finded == null) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .header("caused-by", "login failed")
                    .build();

        } else {
            JsonObject json = Json
                    .createObjectBuilder()
                    .add("id_token", finded.getIdUtente())
                    .build();
            System.out.println("Accesso consentito a " + finded.getNome());
            return Response.ok(json).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)

    public Response Register(Utente u) {
        Response response;
        JsonObject json;

        System.out.println("Tentativo di registrazione in corso.\nNome: " + u.getNome() + "\nMail: " + u.getMail() + "\nPwd: " + u.getPwd());

        Result result = utentemanager.addUtente(u);

        if (result.getResult() == SUCCESS) {
            Utente finded = utentemanager.findByMail(u.getMail());
            json = Json
                    .createObjectBuilder()
                    .add("id_token", finded.getIdUtente())
                    .build();
            response = Response.ok(json).build();

        } else if (result.getResult() == FAILURE_DATA_ALREADY_PRESENT) {
            response = Response.serverError().header("Mail già presente", "Impossibile registrare questo utente: mail già in uso").build();

        } else {
            response = Response.serverError().header("Inserire dati", "Utente non valido").build();
        }
        return response;
    }

    @GET
    public List<Categoria> getCategoria() {
        long ID = 2;
        System.out.println("\n__________________\nABBIAMO RICEVUTO UNA RICHIESTA, ORA TROVIAMO L'UTENTE\n__________________\n");
        Utente u = utentemanager.find(ID);
        System.out.println("\n__________________\nABBIAMO TROVATO L'UTENTE\n__________________\n");
        return categoriamanager.findCategoria(u);
    }
}
