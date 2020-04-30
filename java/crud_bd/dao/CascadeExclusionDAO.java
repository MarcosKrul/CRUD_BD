/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author marco
 */
public abstract class CascadeExclusionDAO {
    
    public static void cascadeExclusion (Integer id, Connection connection) throws SQLException {
        
        String sql_car    = "delete from car where id_foreign = "+id;
        String sql_person = "delete from people where id_person = "+id;
        PreparedStatement ps = connection.prepareStatement(sql_car);
        ps.executeUpdate();
        connection.commit();
        ps = connection.prepareStatement(sql_person);
        ps.executeUpdate();
        connection.commit();
    
    }
    
}
