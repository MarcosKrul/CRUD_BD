/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_bd.dao;

import crud_bd.classes.Car;
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
public abstract class InnerJoinDAO {
    
    public static List<Car> allCars (Integer id_person, Connection connection) throws SQLException {
    
        Car c;
        List<Car> list = new ArrayList<>();
        String sql = "select * from car inner join people on car.id_foreign = people.id_person where id_person = "+id_person;
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultado = ps.executeQuery();
        
        while(resultado.next()){
            c = new Car();
            c.setModel(resultado.getString("model"));
            c.setBrand(resultado.getString("brand"));
            c.setLicensePlate(resultado.getString("licenseplate"));
            c.setColor(resultado.getString("color"));
            c.setId_car(resultado.getInt("id_car"));
            c.setId_foreign(resultado.getInt("id_foreign"));
            list.add(c);
        }
        
        if(list.isEmpty()) return null;
        return list;
        
    }
    
}
