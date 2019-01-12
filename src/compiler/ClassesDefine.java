/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.util.ArrayList;

/**
 *
 * @author DeLL
 */
public class ClassesDefine {
      public String Name;
    public String type;
    public String Am;
    public Boolean Static;
    public String Category;
    public String Extends;
    public String Impliment;

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAm(String Am) {
        this.Am = Am;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public void setExtends(String Extends) {
        this.Extends = Extends;
    }

    public void setImpliment(String Impliment) {
        this.Impliment = Impliment;
    }
    
    ArrayList<FuncClassAttribute> ClassFunctionAttribute; 
    ArrayList<FuncLocalAttributr> FunctionAttribute; 

    public ClassesDefine(String Name, String type, String Am,  String Category, String Extends, String Impliment) {
        this.Name = Name;
        this.type = type;
        this.Am = Am;
        this.Static = Static;
        this.Category = Category;
        this.Extends = Extends;
        this.Impliment = Impliment;
        this.ClassFunctionAttribute = new ArrayList();
        this.FunctionAttribute = new ArrayList();
    }

    @Override
    public String toString() {
        return "ClassesDefine{" + "Name=" + Name + ", type=" + type + ", Am=" + Am + ", Static=" + Static + ", Category=" + Category + ", Extends=" + Extends + ", Impliment=" + Impliment + '}';
    }


    

}
