package com.app.utils.database;

import com.app.models.Staff;
import com.app.utils.SQLDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoang hung
 */
public class StaffsDAO extends SQLDatabase {
    private String table;
    
    public StaffsDAO(Connection connection) {
        super(connection);
    }
    
    public List<Staff> getAll() {
        List<Staff> res = new ArrayList<>();
        
        try {
            ResultSet rs = executeQueryPreparedStatement("SELECT * FROM " + table);
            
            while (rs.next()) {
                res.add(
                    new Staff(
                        rs.getInt("staff_id"), 
                        rs.getNString("name"),
                        rs.getTimestamp("dob").toString(),
                        rs.getDouble("salary_scale"), 
                        rs.getTimestamp("start_date").toString(),
                        rs.getInt("department_id"),
                        rs.getInt("annual_leave"),
                        rs.getInt("over_time")
                    )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public List<Staff> get(Predicate<Staff> criteria) {
        List<Staff> res = new ArrayList<>();
        
        try {
            ResultSet rs = executeQueryPreparedStatement("SELECT * FROM " + table);
            while (rs.next()) {
                Staff s = new Staff(
                            rs.getInt("staff_id"), 
                            rs.getNString("name"),
                            rs.getTimestamp("dob").toString(),
                            rs.getDouble("salary_scale"), 
                            rs.getTimestamp("start_date").toString(),
                            rs.getInt("department_id"),
                            rs.getInt("annual_leave"),
                            rs.getInt("over_time")
                        );
                if (criteria.test(s)) {
                    res.add(s);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return res;
    }
}
