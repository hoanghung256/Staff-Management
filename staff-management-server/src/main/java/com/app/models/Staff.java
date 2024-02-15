package com.app.models;

import com.app.Configuration;

/**
 *
 * @author hoang hung
 */
public class Staff {
    private int id;
    private String name;
    private String dob;
    private double salaryScale;
    private String startDate;
    private int departmentId;
    private int anuualLeave;
    private int overtime;

    public Staff() {
    }
    
    public Staff(int id, String name, String dob, double salaryScale, String startDate, int departmentId, int anuualLeave, int overtime) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.salaryScale = salaryScale;
        this.startDate = startDate;
        this.departmentId = departmentId;
        this.anuualLeave = anuualLeave;
        this.overtime = overtime;
    }
    
    public Staff(String name, String dob, double salaryScale, String startDate, int departmentId, int anuualLeave, int overtime) {
        this.name = name;
        this.dob = dob;
        this.salaryScale = salaryScale;
        this.startDate = startDate;
        this.departmentId = departmentId;
        this.anuualLeave = anuualLeave;
        this.overtime = overtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getSalaryScale() {
        return salaryScale;
    }

    public void setSalaryScale(double salaryScale) {
        this.salaryScale = salaryScale;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getAnuualLeave() {
        return anuualLeave;
    }

    public void setAnuualLeave(int anuualLeave) {
        this.anuualLeave = anuualLeave;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    @Override
    public String toString() {
        return Configuration.gson.toJson(this);
    }
}
