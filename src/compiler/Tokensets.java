/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.util.ArrayList;

/**
 *
 * @author FCC
 */
public class Tokensets {
    
    String cp;
    String cv;
    int lineno;
 
    public Tokensets(String cp, String cv, int lineno) {
        this.cp = cp;
        this.cv = cv;
        this.lineno = lineno;
    }

    public Tokensets() {
    }
    
    
    

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public void setLineno(int lineno) {
        this.lineno = lineno;
    }

    public String getCp() {
        return cp;
    }

    public String getCv() {
        return cv;
    }

    public int getLineno() {
        return lineno;
    }

    @Override
    public String toString() {
        return "Tokensets{" + "classname=" + cp + ", classvalue=" + cv + ", linenumber=" + lineno + '}';
    }

    
    
    
}
