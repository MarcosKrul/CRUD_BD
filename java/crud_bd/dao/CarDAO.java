/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_bd.dao;

import crud_bd.classes.Car;
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
public class CarDAO {

    private Connection connection;

    public CarDAO() {
        connection = SingleConnection.getConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public void addCar(Car c) throws SQLException {

        String sql = "insert into car (model,brand,licenseplate,color,id_foreign) values (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, c.getModel());
        ps.setString(2, c.getBrand());
        ps.setString(3, c.getLicensePlate());
        ps.setString(4, c.getColor());
        ps.setInt(5, c.getId_foreign());
        ps.execute();
        connection.commit();
        SingleConnection.close(ps);

    }

    public void deleteCar(Integer id) throws SQLException {

        String sql = "delete from car where id_car = " + id;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.execute();
        connection.commit();
        SingleConnection.close(ps);

    }

    public Car carSearch(Integer id) throws SQLException {

        Car c = null;
        String sql = "select * from car where id_foreign = " + id;
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultado = ps.executeQuery();

        while (resultado.next()) {
            c = new Car();
            c.setModel(resultado.getString("model"));
            c.setBrand(resultado.getString("brand"));
            c.setLicensePlate(resultado.getString("licenseplate"));
            c.setColor(resultado.getString("color"));
            c.setId_foreign(resultado.getInt("id_foreign"));
            c.setId_car(resultado.getInt("id_car"));
        }
        
        SingleConnection.close(resultado, ps);
        return c;

    }

    public List<Car> returnAllCars(boolean one_person, Integer id) throws SQLException {

        List<Car> list = new ArrayList<>();
        Car c;
        String sql = "select * from car";
        sql += one_person? " where id_foreign = "+id : "";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultado = ps.executeQuery();

        while (resultado.next()) {
            c = new Car();
            c.setModel(resultado.getString("model"));
            c.setBrand(resultado.getString("brand"));
            c.setLicensePlate(resultado.getString("licenseplate"));
            c.setColor(resultado.getString("color"));
            c.setId_foreign(resultado.getInt("id_foreign"));
            c.setId_car(resultado.getInt("id_car"));
            list.add(c);
        }

        SingleConnection.close(resultado, ps);
        if (list.isEmpty()) {
            return null;
        }
        return list;

    }

    public void updateCar(Car c) throws SQLException {

        String sql = "update car set model=?,brand=?,licenseplate=?,color=?,id_foreign=?"
                + "where id_car = " + c.getId_car();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, c.getModel());
        ps.setString(2, c.getBrand());
        ps.setString(3, c.getLicensePlate());
        ps.setString(4, c.getColor());
        ps.setInt(5, c.getId_foreign());
        ps.execute();
        connection.commit();
        SingleConnection.close(ps);

    }

}
