package com.app.controllers;

import com.app.Configuration;
import com.app.models.Staff;
import com.app.utils.database.StaffsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoang hung
 */
@WebServlet(name = "StaffsController", urlPatterns = {"/api/staffs"})
public class StaffsController extends  HttpServlet {
    public static final StaffsDAO dbContext = Configuration.staffs;

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dbContext.delete(req.getParameter("staffId"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String dob = req.getParameter("dob");
            double salaryScale = Double.parseDouble(req.getParameter("salaryScale"));
            String startDate = req.getParameter("startDate");
            int departmentId = Integer.parseInt(req.getParameter("departmentId"));
            int annualLeave = Integer.parseInt(req.getParameter("annualLeave"));
            int overtime = Integer.parseInt(req.getParameter("overtime"));
            
            dbContext.add(new Staff(name, dob, salaryScale, startDate, departmentId, annualLeave, overtime));
        } catch (NumberFormatException e) {
            Logger.getLogger(StaffsController.class.getName()).log(Level.SEVERE, null, e);
//            throw e;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        
//        if (req.getParameter("staff_id") == null) {
            out.print(dbContext.getAll());
//        } else {
//            out.print(dbContext.get((staff) -> staff.getId() == Integer.parseInt(req.getParameter("staff_id"))));
//        }
    }
}
