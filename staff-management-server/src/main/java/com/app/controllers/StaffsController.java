package com.app.controllers;

import com.app.Configuration;
import com.app.utils.database.StaffsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author hoang hung
 */
@WebServlet(name = "StaffsController", urlPatterns = {"/api/staffs"})
public class StaffsController extends  HttpServlet {
    public static final StaffsDAO dbContext = Configuration.staffs;

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // PrintWriter out = resp.getWriter();
        
        // try {
        //     String name = req.getParameter("name");
        //     String dob = req.getParameter("dob");
        //     String 
        // }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        
        if (req.getParameter("staff_id") == null) {
            out.print(dbContext.getAll());
        } else {
            out.print(dbContext.get((staff) -> staff.getId() == Integer.parseInt(req.getParameter("staff_id"))));
        }
    }
}
