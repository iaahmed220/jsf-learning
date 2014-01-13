/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.jsflearning.primefaces.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author jittagornp
 */
public class JSFNotification {

    public static void notifyClient(FacesMessage.Severity severity, String title, String content) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, title, content));
    }
}
