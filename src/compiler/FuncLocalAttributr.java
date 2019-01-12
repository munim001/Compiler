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
class FuncLocalAttributr {
      public String Name;
    public String Type;
    public int Scope;
    public Boolean Assigned;

    public FuncLocalAttributr(String Name, String Type, int Scope, Boolean Assigned) {
        this.Name = Name;
        this.Type = Type;
        this.Scope = Scope;
        this.Assigned = Assigned;
    }

    
    

}
