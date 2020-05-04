/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_bd.dao;

import crud_bd.classes.Person;
import crud_bd.connectionBD.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class PersonDAO {
    
    private Connection connection;

    public PersonDAO() {
        this.connection = SingleConnection.getConnection();
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void addPerson(Person p) throws SQLException{
    
        String sql = "insert into people (name,email,phonenumber,age) values (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, p.getName());
        ps.setString(2, p.getEmail());
        ps.setString(3, p.getPhoneNumber());
        ps.setInt(4, p.getAge());
        ps.execute();
        connection.commit();
        SingleConnection.close(ps);
    
    }
    
    public void deletePerson (Integer id) throws SQLException {
       
        String sql = "delete from people where id_person = "+ id;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.execute();
        connection.commit();
        SingleConnection.close(ps);
    
    }
    
    public Person personSearch (Integer id) throws SQLException {
        
        Person p = null;
        String sql = "select * from people where id_person = "+id;
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultado = ps.executeQuery();
        
        while(resultado.next()) {
            p = new Person();
            p.setId_person(resultado.getInt("id_person"));
            p.setName(resultado.getString("name"));
            p.setEmail(resultado.getString("email"));
            p.setPhoneNumber(resultado.getString("phonenumber"));
            p.setAge(resultado.getInt("age"));
        }

        SingleConnection.close(resultado, ps);
        return p;
        
    }
    
    public List<Person> returnAllPeople () throws SQLException {
        
        List<Person> list = new ArrayList<>();
        Person p;
        String sql = "select * from people";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultado = ps.executeQuery();
        
        while(resultado.next()) {
            p = new Person();
            p.setId_person(resultado.getInt("id_person"));
            p.setName(resultado.getString("name"));
            p.setEmail(resultado.getString("email"));
            p.setPhoneNumber(resultado.getString("phonenumber"));
            p.setAge(resultado.getInt("age"));
            list.add(p);
        }
        
        SingleConnection.close(resultado, ps);
        if(list.isEmpty()) return null;
        return list;
    
    }
    
    public void updatePerson(Person p) throws SQLException {
        
        String sql = "update people set name=?,email=?,phonenumber=?,age=? "
                    + "where id_person = "+p.getId_person();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, p.getName());
        ps.setString(2, p.getEmail());
        ps.setString(3, p.getPhoneNumber());
        ps.setInt(4, p.getAge());
        ps.execute();
        connection.commit();
        SingleConnection.close(ps);
    
    }

}
