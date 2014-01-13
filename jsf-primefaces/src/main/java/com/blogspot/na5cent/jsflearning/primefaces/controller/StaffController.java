/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.jsflearning.primefaces.controller;

import com.blogspot.na5cent.jsflearning.primefaces.model.Staff;
import com.blogspot.na5cent.jsflearning.primefaces.util.JSFRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jittagornp
 */
@SessionScoped
@ManagedBean
public class StaffController implements Serializable {

    private List<Staff> staffs = null;
    private Staff newStaff = null;

    @PostConstruct
    public void postContruct() {
        staffs = new ArrayList<>();
        staffs.add(new Staff("jittagorn pitakmetagoon", "redcrow", "bangkok thailand"));
    }

    public Staff getNewStaff() {
        return newStaff;
    }

    public void setNewStaff(Staff newStaff) {
        this.newStaff = newStaff;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public void onAddStaff() {
        if (!newStaff.getUsername().isEmpty()) {
            staffs.add(newStaff);
        }
    }

    public void createStaff() {
        if (newStaff == null || !newStaff.getUsername().isEmpty()) {
            newStaff = new Staff();
        }
    }

    public void onSelectStaff() {
        String username = JSFRequest.requestString("username");
        int indexOf = staffs.indexOf(new Staff(username));

        if (indexOf != -1) {
            newStaff = staffs.get(indexOf);
        }
    }

    public void onDelete() {
        staffs.remove(newStaff);
    }
}
