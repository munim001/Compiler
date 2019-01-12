/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

/**
 *
 * @author DeLL
 */
public class Temp {
    public String Name;
    public String type,paralist;
    public String Am;
    public Boolean Static;
    public String Category;
    public String Extends;
    public String Impliment;
    public Boolean Assigned;

    public String getParalist() {
        return paralist;
    }
     public int Scope;

    public Temp() {
        this.Name = "";
        this.type = "->void";
        this.Am = "public";
        this.Static = false;
        this.Category = "general";
        this.Extends = "";
        this.Impliment = "";
        this.Assigned = false;
        this.Scope = 0;
    }

    public Temp(String Name, String type, Boolean Static, String Category, String Extends, String Impliment, String Type, String AM, Boolean Assigned, int Scope) {
        this.Name = Name;
        this.type = type;
        this.Static = Static;
        this.Category = Category;
        this.Extends = Extends;
        this.Impliment = Impliment;
        this.Assigned = Assigned;
        this.Scope = Scope;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAm() {
        return Am;
    }

    public void setAm(String Am) {
        this.Am = Am;
    }

    public Boolean getStatic() {
        return Static;
    }

    public void setStatic(Boolean Static) {
        this.Static = Static;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getExtends() {
        return Extends;
    }

    public void setExtends(String Extends) {
        this.Extends = Extends;
    }

    public String getImpliment() {
        return Impliment;
    }

    public void setImpliment(String Impliment) {
        this.Impliment = Impliment;
    }


    public Boolean getAssigned() {
        return Assigned;
    }

    public void setAssigned(Boolean Assigned) {
        this.Assigned = Assigned;
    }

    public int getScope() {
        return Scope;
    }

    public void setScope(int Scope) {
        this.Scope = Scope;
    }
     
     
    
}


