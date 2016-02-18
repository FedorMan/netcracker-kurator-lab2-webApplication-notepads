package controller;

import models.*;
import org.junit.Test;

import java.sql.*;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class ControllerTest {


    @Test
    public void testSave() throws Exception {
        Controller controller = new Controller();
        //��������� ������������
        Essence user = new User("tester", "password");
        controller.save(user);
        //��������� ������������
        Connection dbh = DriverManager.getConnection(
                "jdbc:mysql://localhost:3305/notepadmanager", "notepadmanager", "123123"
        );
        Statement st = dbh.createStatement();
        ResultSet rs = st.executeQuery(
                "select * from users ORDER BY ID DESC LIMIT 1"
        );
        rs.next();
        String s = rs.getString(2);
        int id = 0;
        id = Integer.parseInt(rs.getString(1));
        //������� ������
        assertTrue(s.equals("tester"));
        //������� ���������� ������������
        PreparedStatement preparedStatement = null;
        preparedStatement = dbh.prepareStatement("DELETE from users where id =" + id);
        preparedStatement.executeUpdate();
        rs.close();
        st.close();
        preparedStatement.close();
        dbh.close();
    }

    //� ������� ������� ������ ���� ���� ��  ������������
    @Test
    public void testDelete() throws Exception {
        //�������� ������������, ����� ������ ���, ��������� �� ���������� � ����� id, ���� �� ������ ��� ��� � ���������� �� ����� ��������
        Connection dbh = DriverManager.getConnection(
                "jdbc:mysql://localhost:3305/notepadmanager", "notepadmanager", "123123"
        );
        PreparedStatement preparedStatement = null;
        //���������
        preparedStatement = dbh.prepareStatement("INSERT INTO users"
                + "(login, password, time_create) VALUES"
                + "(?,?,?)");
        preparedStatement.setString(1, "last1");
        preparedStatement.setString(2, "password");
        preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
        //�������
        Statement st = dbh.createStatement();
        ResultSet rs = st.executeQuery(
                "select * from users ORDER BY ID DESC LIMIT 1"
        );
        rs.next();
        int id = 0;
        id = Integer.parseInt(rs.getString(1));
        Controller controller = new Controller();
        controller.delete(id, User.class);
        //���������
        rs = st.executeQuery(
                "select * from users ORDER BY ID DESC LIMIT 1"
        );
        rs.next();
        int lastId = 0;
        lastId = Integer.parseInt(rs.getString(1));
        assertTrue(lastId < id);

        st.close();
        rs.close();
        preparedStatement.close();
        dbh.close();
    }

    @Test
    public void listOnQuery() throws Exception {
        //���������
        Connection dbh = DriverManager.getConnection(
                "jdbc:mysql://localhost:3305/notepadmanager", "notepadmanager", "123123"
        );
        PreparedStatement preparedStatement = null;
        preparedStatement = dbh.prepareStatement("INSERT INTO users"
                + "(login, password, time_create) VALUES"
                + "(?,?,?)");
        preparedStatement.setString(1, "tester");
        preparedStatement.setString(2, "password");
        preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
        Controller controller = new Controller();
        //��������
        LinkedList<Essence> listResult = controller.listOnQuery("SELECT * from users  where login='tester'", User.class);
        assertTrue(((User)listResult.get(0)).getLogin().equals("tester"));
        //�������
        Statement st = dbh.createStatement();
        ResultSet rs = st.executeQuery(
                "select * from users ORDER BY ID DESC LIMIT 1"
        );
        rs.next();
        int id = 0;
        id = Integer.parseInt(rs.getString(1));
        //������� ���������� ������������
        preparedStatement = dbh.prepareStatement("DELETE from users where id =" + id);
        preparedStatement.executeUpdate();

        rs.close();
        st.close();
        preparedStatement.close();
        dbh.close();
    }

    @Test
    public void testCorrect() throws Exception {
        //���������
        Connection dbh = DriverManager.getConnection(
                "jdbc:mysql://localhost:3305/notepadmanager", "notepadmanager", "123123"
        );
        PreparedStatement preparedStatement = null;
        preparedStatement = dbh.prepareStatement("INSERT INTO users"
                + "(login, password, time_create) VALUES"
                + "(?,?,?)");
        preparedStatement.setString(1, "tester");
        preparedStatement.setString(2, "password");
        preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
        //��������� ������������
        dbh = DriverManager.getConnection(
                "jdbc:mysql://localhost:3305/notepadmanager", "notepadmanager", "123123"
        );
        Statement st = dbh.createStatement();
        ResultSet rs = st.executeQuery(
                "select * from users ORDER BY ID DESC LIMIT 1"
        );
        rs.next();
        User user=new User();
        user.setId(Integer.parseInt(rs.getString(1)));
        user.setLogin("tester1");
        user.setPassword(rs.getString(3));
        user.setTimeCreate(new Timestamp(System.currentTimeMillis()));

        Controller controller = new Controller();
        controller.correct(user);

        dbh = DriverManager.getConnection(
                "jdbc:mysql://localhost:3305/notepadmanager", "notepadmanager", "123123"
        );
        st = dbh.createStatement();
        rs = st.executeQuery(
                "select * from users ORDER BY ID DESC LIMIT 1"
        );
        rs.next();
        assertTrue(rs.getString(2).equals("tester1"));
        int id = 0;
        id = Integer.parseInt(rs.getString(1));

        //������� ���������� ������������
        preparedStatement = dbh.prepareStatement("DELETE from users where id =" + id);
        preparedStatement.executeUpdate();

        rs.close();
        st.close();
        preparedStatement.close();
        dbh.close();
    }

}