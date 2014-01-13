/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.jsflearning.primefaces.util;

import javax.faces.context.FacesContext;

/**
 *
 * @author jittagornp
 */
public class JSFRequest {

    public static String requestString(String parameterName) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(parameterName);
    }
}
