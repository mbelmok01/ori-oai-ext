/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.orioai.ext.physalis.beans;

/**
 *
 * @author Mohamed
 */
public class DoctoralSchool {
    private String FDIP_MENTION;
    private String FD_FDIP_CODE;
    
    
    public void DoctoralSchool(){
        
    }
    
    public String getFDIP_MENTION() {
        return FDIP_MENTION;
    }

    public void setFDIP_MENTION(String FDIP_MENTION) {
        this.FDIP_MENTION = FDIP_MENTION;
    }

    public String getFD_FDIP_CODE() {
        return FD_FDIP_CODE;
    }

    public void setFD_FDIP_CODE(String FD_FDIP_CODE) {
        this.FD_FDIP_CODE = FD_FDIP_CODE;
    }
    
}
