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
class FuncClassAttribute {
       public String Name;
    public String Type;
    public String AM;
    public Boolean Static;
    public String Category;
    public Boolean Assigned;

    public FuncClassAttribute(String Name, String Type, String AM, Boolean Static, String Category, Boolean Assigned) {
        this.Name = Name;
        this.Type = Type;
        this.AM = AM;
        this.Static = Static;
        this.Category = Category;
        this.Assigned = Assigned;
    }

    @Override
    public String toString() {
        return "FuncClassAttribute{" + "Name=" + Name + ", Type=" + Type + ", AM=" + AM + ", Static=" + Static + ", Category=" + Category + ", Assigned=" + Assigned + '}';
    }


    

}
