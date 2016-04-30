package ru.bk.leontev.fedor.web_controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import com.google.gson.Gson;
import ru.bk.leontev.fedor.controller.Controller;
import ru.bk.leontev.fedor.models.Entity;
import ru.bk.leontev.fedor.models.Notepad;
import ru.bk.leontev.fedor.models.User;

@Path(value="/w")
public class WebController {
    Controller controller=new Controller();
    Gson gson = new Gson();
    @GET
    @Path(value="/getAllUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public String listAllUsers() {
        LinkedList<Entity> entites=controller.listOnQuery("select * from users", User.class);
        String json = gson.toJson(entites);
        return json;
    }
    @GET
    @Path(value="/getNotepads/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getNotepades(@PathParam("idUser") int idUser) {
        LinkedList<Entity> notepads=controller.listOnQuery("select * from notepads where id_user="+idUser, Notepad.class);
        String json = gson.toJson(notepads);
        return json;
    }

    @POST
    @Path(value="/saveNotepad")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveNotepad(String content) {
        System.out.println(content);

    }
}
//singleton