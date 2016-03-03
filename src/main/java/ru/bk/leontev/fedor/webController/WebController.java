package ru.bk.leontev.fedor.webController;

import ru.bk.leontev.fedor.controller.Controller;
import ru.bk.leontev.fedor.models.Entity;
import ru.bk.leontev.fedor.models.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;

@Path(value="/w")
public class WebController {
    Controller controller=new Controller();
    @GET
    @Path(value="/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public LinkedList<User> listAllUsers() {
        LinkedList<User> message=new LinkedList<User>();
        LinkedList<Entity> entites=controller.listOnQuery("select * from users", User.class);
        for (int i = 0; i <entites.size(); i++) {
            message.add((User)entites.get(i));
        }
        return message;
    }
    @GET
    @Path(value="/get")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {

        return "hello";
    }
}
