package com.app.utils.database;

import com.app.models.Staff;
import com.app.utils.Formatter;
import com.app.utils.SQLDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
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
                res.add(new Staff(
                        rs.getInt("staff_id"), 
                        rs.getNString("name"),
                        Formatter.convertTimeStampToString(rs.getTimestamp("dob")),
                        rs.getDouble("salary_scale"), 
                        Formatter.convertTimeStampToString(rs.getTimestamp("start_date")),
                        rs.getInt("department_id"),
                        rs.getInt("annual_leave"),
                        rs.getInt("over_time")
                    )
                );
            }
        } catch (SQLException | ParseException e) {
            Logger.getLogger(StaffsDAO.class.getName()).log(Level.SEVERE, null, e);
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
                            Formatter.convertTimeStampToString(rs.getTimestamp("dob")),
                            rs.getDouble("salary_scale"), 
                            Formatter.convertTimeStampToString(rs.getTimestamp("start_date")),
                            rs.getInt("department_id"),
                            rs.getInt("annual_leave"),
                            rs.getInt("over_time")
                        );
                if (criteria.test(s)) {
                    res.add(s);
                }
            }
        } catch (SQLException | ParseException e) {
            Logger.getLogger(StaffsDAO.class.getName()).log(Level.SEVERE, null, e);
        }
          
        return res;
    }
    
    public void add(Staff s) {
        executePreparedStatement("INSERT INTO " + table + " (name, dob, salary_scale, start_date, department_id, annual_leave, over_time) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)", 
                s.getName(), s.getDob(), s.getSalaryScale(), s.getStartDate(), s.getDepartmentId(), s.getAnuualLeave(), s.getOvertime());
    }
    
    public void delete(String id) {
        executePreparedStatement("DELETE FROM " + table + "WHERE staff_id=?", id);
    }
}
