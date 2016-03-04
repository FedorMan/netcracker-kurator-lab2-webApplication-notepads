package ru.bk.leontev.fedor.webController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import com.google.gson.Gson;
import ru.bk.leontev.fedor.controller.Controller;
import ru.bk.leontev.fedor.models.Entity;
import ru.bk.leontev.fedor.models.User;

@Path(value="/w")
public class WebController {
    Controller controller=new Controller();
    @GET
    @Path(value="/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public String listAllUsers() {
        Gson gson = new Gson();
        LinkedList<User> message=new LinkedList<User>();
        LinkedList<Entity> entites=controller.listOnQuery("select * from users", User.class);
        for (int i = 0; i <entites.size(); i++) {
            message.add((User)entites.get(i));
        }
        String json = gson.toJson(message);
        return json;
    }
    @GET
    @Path(value="/get")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        Gson gson = new Gson();
        User user=new User("fbdb","fdb");
        String json = gson.toJson(user);
        return json;
    }
}
