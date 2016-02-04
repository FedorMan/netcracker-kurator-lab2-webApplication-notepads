package controller;

import models.*;
import org.hibernate.SQLQuery;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ControllerTest {

    @Test
    public void testSave() throws Exception {
        Controller controller = new Controller();

        //сохраняем пользователя
        //Essence user = new User("115", "115");
        //controller.save(user);


        //сохраняем блокнот
        Essence notepad = new Notepad("1", 6);
        controller.save(notepad);
        /*
        //сохраняем запись
        Essence record = new Record("first", "testing", 10);
        controller.save(record);

        //сохраняем файл
        Essence file = new SaveFile(4,"c:\\8",Type.file);
        controller.save(file);
        controller.shutdown();
        */
    }

    @Test
    public void testDelete() throws Exception {
        Controller controller=new Controller();
        controller.delete(2, User.class);
    }


    @Test
    public void testListAll() throws Exception {
        Controller controller = new Controller();
        LinkedList<Essence> listAll=controller.listAll("SELECT * from users",User.class);
        for (int i = 0; i <listAll.size() ; i++) {
            System.out.println(((User)listAll.get(i)).getLogin());
        }

    }

    @Test
    public void testCorrect() throws Exception {
        Controller controller=new Controller();
        Notepad notepad = new Notepad("111", 6);
        notepad.setId(11);
        controller.correct(notepad);
    }
}