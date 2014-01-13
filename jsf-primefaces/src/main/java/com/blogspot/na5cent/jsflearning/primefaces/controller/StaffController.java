/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.jsflearning.primefaces.controller;

import com.blogspot.na5cent.jsflearning.primefaces.model.Staff;
import com.blogspot.na5cent.jsflearning.primefaces.util.JSFNotification;
import com.blogspot.na5cent.jsflearning.primefaces.util.JSFRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
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
    public void postContruct() { //call after constructor callecd
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
        if (staffs == null) {
            staffs = new ArrayList<>();
        }
        
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public void onAddStaff() {
        if (isValid()) {
            try {
                staffs.add(newStaff);
                JSFNotification.notifyClient(FacesMessage.SEVERITY_INFO, "add staff", "success.");
            } catch (Exception ex) {
                JSFNotification.notifyClient(FacesMessage.SEVERITY_ERROR, "add staff", "fail because : " + ex.getMessage() + ".");
            }
        }
    }

    private boolean isValid() {
        return !newStaff.getUsername().isEmpty();
    }

    public void createStaff() {
        if (isEmptyStaff()) {
            newStaff = new Staff();
        }
    }

    private boolean isEmptyStaff() {
        return newStaff == null || !newStaff.getUsername().isEmpty();
    }

    public void onSelectStaff() {
        String username = JSFRequest.requestString("username");
        int indexOf = staffs.indexOf(new Staff(username));

        if (indexOf != -1) { //found staff
            newStaff = staffs.get(indexOf);
        }
    }

    public void onDelete() {
        try {
            staffs.remove(newStaff);
            JSFNotification.notifyClient(FacesMessage.SEVERITY_INFO, "delete staff", "success.");
        } catch (Exception ex) {
            JSFNotification.notifyClient(FacesMessage.SEVERITY_ERROR, "delete staff", "fail because : " + ex.getMessage() + ".");
        }
    }
}
