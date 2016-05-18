package ru.bk.leontev.fedor.web_controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.util.LinkedList;
import com.google.gson.Gson;
import ru.bk.leontev.fedor.controller.Controller;
import ru.bk.leontev.fedor.models.Entity;
import ru.bk.leontev.fedor.models.Notepad;
import ru.bk.leontev.fedor.models.Record;
import ru.bk.leontev.fedor.models.User;

@Path(value="/w")
public class WebController {
    Controller controller=new Controller();
    Gson gson = new Gson();

    @GET
    @Path(value="/getNotepads")
    @Produces(MediaType.APPLICATION_JSON)
    public String getNotepades() {
        HttpSession session = request.getSession(false);
        System.out.println(session.getAttribute("userId"));
        LinkedList<Entity> notepads=controller.listOnQuery("select * from notepads where id_user="+(Integer)(session.getAttribute("userId")), Notepad.class);
        String json = gson.toJson(notepads);
        return json;
    }

    @POST
    @Path(value="/saveNotepad")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveNotepad(String content) {
        System.out.println("Save Notepad");
        Notepad notepad=gson.fromJson(content, Notepad.class);
        HttpSession session = request.getSession(false);
        notepad.setId_user((Integer)(session.getAttribute("userId")));
        controller.save(notepad);
    }

    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;

    @POST
    @Path(value="/login")
    public Response getUser(@FormParam("username") String username,@FormParam("username") String password) throws ServletException, IOException {
        LinkedList<Entity> entites=controller.listOnQuery("select * from users where login="+"'"+username+"'"+" and password="+"'"+password+"'", User.class);
        if (entites.size()==1){
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", ((User) entites.get(0)).getId());
            response.sendRedirect("/index.html");
        }
        return null;
    }

    @GET
    @Path(value="/dropSession")
    @Produces(MediaType.APPLICATION_JSON)
    public void dropSession() {
        System.out.println("dropSession");
        HttpSession session = request.getSession(false);
        System.out.println(session.getAttribute("dropSession"));
        session.invalidate();
    }

    @GET
    @Path(value="/loadRecords")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRecordings(String idNotepad) {
        System.out.println("loadRecords");
        LinkedList<Entity> recordings=controller.listOnQuery("select * from recording where id_notepad="+Integer.parseInt(idNotepad), Record.class);
        String json = gson.toJson(recordings);
        return json;
    }
}
//singleton
//multipart jersey