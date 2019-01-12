/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author DeLL
 */
public class SymbolTable {
    
      Stack<Integer> S=new Stack();
     int CS=0;
    
    ArrayList<ClassesDefine> ClassAttribute=new ArrayList(); 

    public SymbolTable() {
    }

 
    

    
    
            
public  String IDlookup(String name,int CS,String CC){
    for (int i = 0; i < ClassAttribute.size(); i++) {
      
            if(ClassAttribute.get(i).Name.equals(CC)){
      for (int j = 0; j < ClassAttribute.get(i).FunctionAttribute.size(); j++) {
      if(ClassAttribute.get(i).FunctionAttribute.get(j).Name.equals(name)){
          for (int k = 0; k < S.size(); k++) {
          if(S.get(k)==CS || S.get(k)<CS){
                            return ClassAttribute.get(i).FunctionAttribute.get(j).Type;
          }
          }
          }

          }
                for (int j = 0; j < ClassAttribute.get(i).ClassFunctionAttribute.size(); j++) {
           if(ClassAttribute.get(i).ClassFunctionAttribute.get(j).Name.equals(name))
   {
       return ClassAttribute.get(i).ClassFunctionAttribute.get(j).Type;
   }             
                }
      }
  }
    
         return null;
}
public String Funclookup(String name,String ParameterList,String CC){
    for (int i = 0; i < ClassAttribute.size(); i++) {
        
    
    if(ClassAttribute.get(i).Name.equals(CC)){
                  for (int j = 0; j < ClassAttribute.get(i).ClassFunctionAttribute.size(); j++) {
           if(ClassAttribute.get(i).ClassFunctionAttribute.get(j).Name.equals(name) 
                   && ClassAttribute.get(i).ClassFunctionAttribute.get(j).Type.equals(ParameterList))
   {
       
    String temp[] =  ClassAttribute.get(i).ClassFunctionAttribute.get(j).Type.split(">");
    return temp[1];
   }        
                  }
    }
        }
        return null;
    
}
public String Compatibility(String Operator,String Type1){

if(Operator.equals("!")&&Type1.equals("Boolean")){
    return Type1;
    
}
return null;
}

public String Compatibility(String Operator,String Type1,String Type2){

    if(Type1.equals(Type2)){
       
    return Type1;
}
    
    return null;
    
}public boolean Insert(String ClassName,String name,String Type,int CS,Boolean Assigned,String AM,Boolean Static,String Category){
   int temp =0 ;
            for (int i = 0; i < this.ClassAttribute.size(); i++) {
                 temp=i;
                if (this.ClassAttribute.get(i).Name.equals(ClassName)) {
                   temp=i;
                    for (int j = 0; j < ClassAttribute.get(i).ClassFunctionAttribute.size(); j++) {
                        
                    
                    if(ClassAttribute.get(i).ClassFunctionAttribute.get(j).Name.equals(name) 
                            &&ClassAttribute.get(i).ClassFunctionAttribute.get(j).Type.equals(Type)){
                        return false;
                    } 
                }
                    for (int j = 0; j < ClassAttribute.get(temp).FunctionAttribute.size(); j++) {
                        
                    
                 if(ClassAttribute.get(temp).FunctionAttribute.get(j).Name.equals(name) 
                            &&ClassAttribute.get(temp).FunctionAttribute.get(j).Type.equals(Type))
       
                 {
                     return false;
                 }
                     }
                }
            }
    if(CS>0){
        this.ClassAttribute.get(temp).FunctionAttribute.add(new FuncLocalAttributr(name,Type,CS,Assigned));
    }
    else
      this.ClassAttribute.get(temp).ClassFunctionAttribute.add(new FuncClassAttribute(name,Type,AM,Static,Category,Assigned));
                return true;
    
}

public void  CreateScope()
{
    CS++;
    S.push(CS);
}

public void  DestroyScope()
{
    S.pop();
//    CS--;
}
    
}
