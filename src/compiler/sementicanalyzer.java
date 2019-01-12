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
public class sementicanalyzer {
        String T1,T2,T3,T4,T5,T6;
String CC="";
int CS=0;

    ArrayList<Tokensets> token;
String g;
ArrayList <String> SST_Selection,MST_selection,E6_selection,E8_selection,E1_selection,constant,OE_Selection,AE_Selection,ROP_Selection,exp_Selection,T_Selection;
int i;   
Temp Temp=new Temp();
ClassesDefine cd;
FuncClassAttribute FC;
SymbolTable sm=new SymbolTable();
sementicanalyzer(ArrayList<Tokensets> token) {
        this.token=token;
        this.OE_Selection = new ArrayList();
        this.constant = new ArrayList();
        this.AE_Selection = new ArrayList();
        this.ROP_Selection = new ArrayList();
        this.exp_Selection = new ArrayList();
        this.T_Selection = new ArrayList();
        this.E1_selection=new ArrayList();;
        this.E8_selection=new ArrayList();
        this.E6_selection=new ArrayList();
        this.SST_Selection=new ArrayList();
        this.MST_selection=new ArrayList();;


        i=0;   
    }
boolean SelectionSet(){
this.OE_Selection.add(":");this.OE_Selection.add("ID");this.OE_Selection.add("(");this.OE_Selection.add("!");this.OE_Selection.add("incdec");this.OE_Selection.add("stringcons");this.OE_Selection.add("floatcons");this.OE_Selection.add("doublecons");this.OE_Selection.add("intcons");this.OE_Selection.add("charcons");this.OE_Selection.add("boolcons");this.OE_Selection.add("this");this.OE_Selection.add("super");
this.constant.add("stringcons");this.constant.add("floatcons");this.constant.add("intcons");this.constant.add("charcons");this.constant.add("boolcons");
this.E1_selection.add(",");this.E1_selection.add(":");this.E1_selection.add("=");this.E1_selection.add(";");this.E1_selection.add("MDM");this.E1_selection.add("(");this.E1_selection.add("PM");this.E1_selection.add("ROP");this.E1_selection.add("ANDOR");this.E1_selection.add("$");this.E1_selection.add(")");this.E1_selection.add("]");this.E1_selection.add("[");
this.E8_selection.add(",");this.E8_selection.add(":");this.E8_selection.add("=");this.E8_selection.add(";");this.E8_selection.add("MDM");this.E8_selection.add("PM");this.E8_selection.add("ROP");this.E8_selection.add("ANDOR");this.E8_selection.add("$");this.E8_selection.add(")");this.E8_selection.add("]");this.E8_selection.add("[");
this.E6_selection.add(",");this.E6_selection.add(":");this.E6_selection.add("=");this.E6_selection.add(";");this.E6_selection.add("PM");this.E6_selection.add("MDM");this.E6_selection.add("ROP");this.E6_selection.add("ANDOR");this.E6_selection.add("$");this.E6_selection.add(")");this.E6_selection.add("]");this.E6_selection.add("[");
this.SST_Selection.add("return");this.SST_Selection.add("if");this.SST_Selection.add("while");this.SST_Selection.add("for");this.SST_Selection.add("do");this.SST_Selection.add("switch");this.SST_Selection.add("break");this.SST_Selection.add("contineu");this.SST_Selection.add("incdec");this.SST_Selection.add("this");this.SST_Selection.add("super");this.SST_Selection.add("ID");this.SST_Selection.add("DT");


//   return While_st();
  // return if_st();
//  return Assignment();///////////////////////////////////
// return func_st();
//return switch_st();///////////////////////////////////////
return Class_St();

//return for_st();//////////////////////////////////////////
//   return     OE();/////////////////////////////////////
//   return DO_While_st();
//   return Declearation();//////////////////////////////
 //   return Function_call();

    }
Boolean OE(int s,String cc,String T6){
    if(OE_Selection.contains(token.get(i).cp)){
        if(AE(s,cc,T5))
            if(OEdesh(s,cc,T5,T6))
                return true;
    }
    
        return false;  } 
Boolean OEdesh(int s,String cc,String T5,String T6){
    
    
      ArrayList<String> q3=new ArrayList<>();
    q3.add(":"); q3.add(")");q3.add("$");q3.add("]");
    q3.add(";");
     if(token.get(i).cp.equals("ANDOR")){
         i++;
         String temp=T5;
        if(AE(s,cc,T5))
            if(OEdesh(s,cc,T5,T6))
                return true;
    }   else{
        if(q3.contains(token.get(i).cp))
            return true;
    } 
   
    
    return false;  } 
Boolean AE(int s,String cc,String T5){
    if(OE_Selection.contains(token.get(i).cp)){
   
        if(ROP(s,cc,T4))
            if(AEdesh(s,cc,T3,T5))
                return true;
    }
        return false;  } 
Boolean AEdesh(int s,String cc,String T4,String T5){
     ArrayList<String> q2=new ArrayList<>();
    q2.add(":");q2.add(")"); /*q2.add("ANDOR");*/q2.add("$");
    q2.add(";");q2.add("]");
   
    if(token.get(i).cp.equals("ANDOR")){
        i++;
        String temp=T4;
        if(ROP(s,cc,T4))
            if(AEdesh(s,cc,T4,T5))
                return true;
    }   else{
        if(q2.contains(token.get(i).cp))
            return true;
    } 
   
        return false;  } 
Boolean ROP(int s,String cc,String T4){
    if(OE_Selection.contains(token.get(i).cp)){

        if(exp(s,cc,T3)){
            if(ROPdesh(s,cc,T3,T4))
        
                return true;}
    }
        return false;  } 
Boolean ROPdesh(int s,String cc,String T3,String T4){
     ArrayList<String> q1=new ArrayList<>();
    q1.add("]");q1.add(":");q1.add(")");q1.add("ANDOR");q1.add("$");  q1.add(";");
   
    if(token.get(i).cp.equals("ROP")){
        i++;
        String temp=T3;
        if(exp(s,cc,T3))
            if(ROPdesh(s,cc,T3,T4))
                return true;
    }   else{
        if(q1.contains(token.get(i).cp))
            return true;
    } 
    return false;  } 
Boolean exp(int s,String cc,String T3){
     if(OE_Selection.contains(token.get(i).cp)){

        if(T(s,cc,T2)){
            if(expdesh(s,cc,T2,T3))
                return true;}
    }
    
        return false;  } 
Boolean expdesh(int s,String cc,String T2,String T3){
    ArrayList<String> q=new ArrayList<>();
    q.add(":");q.add(")");q.add("]");q.add("ROP");q.add("ANDOR");q.add("$");  q.add(";");
    if(token.get(i).cp.equals("PM")){

    i++;
    String temp=T2;
        if(T(s,cc,T2))
            if(expdesh(s,cc,T2,T3))
                return true;
    }   else{
        if(q.contains(token.get(i).cp))
            return true;
    }
    
        return false;  } 
Boolean T(int s,String cc,String T2){
    if(OE_Selection.contains(token.get(i).cp)){
        if(F(s,cc,T1)){
            if(Tdesh(s,cc,T1,T2)){
                return true;}
        }}    
        return false;  } 
Boolean Tdesh(int s,String cc,String T1,String T2){
    ArrayList<String> q4=new ArrayList<>();
    q4.add(":");q4.add("PM");q4.add(")");q4.add("]");q4.add("ROP");q4.add("ANDOR");q4.add("$");  q4.add(";");
    if(token.get(i).cp.equals("MDM")){
        i++;
            String temp=T1;

        if(F(s,cc,T1))
            if(Tdesh(s,cc,T1,T2))
                return true;
    }   else{
        if(q4.contains(token.get(i).cp))
            return true;
    }
        return false;  }
Boolean F(int S,String cc,String T1){
    
String s=token.get(i).cp;
    
 if(s.equals("ID")){

     i++;
  if(E8())
            return true;
}
    
else {
     if(token.get(i).cp.equals("incdec")){
    i++;
    if(token.get(i).cp.equals("ID")){
        i++;
    if(E1())
        if(E6())
    
        return true;
        }}
else if((token.get(i).cp.equals("("))){
    i++;
    if((OE(CS,CC,T1)))
        if((token.get(i).cp.equals(")")))
            i++;
        return true;
        }
else if((token.get(i).cp.equals("!"))){
    i++;
    if((F(CS,CC,T1)))
        
        return true;
        }
else if(Const()){
        return true;
        }
 else if((token.get(i).cp.equals("this"))  || (token.get(i).cp.equals("super"))){
    i++;
    if(token.get(i).cp.equals("->"))
        i++;
 
    if(token.get(i).cp.equals("ID"))
        i++;
        if(E8())
        return true;
        }
 }
//i++;}
        return false;  } 
Boolean E1()
{
    if(token.get(i).cp.equals("->")){
        i++;
        if(token.get(i).cp.equals("ID")){
            i++;
            if(E1())
                return true;
        }
    }else if(token.get(i).cp.equals("[")){
        
        i++;
        if(OE(CS,CC,T6)){
            if(token.get(i).cp.equals("]")){
                i++;
                if(A_2()){
                    if(E3()){
                        return true;
                    }
                }
            }
        }
    }else if(token.get(i).cp.equals("incdec")){
        i++;
        return true;
    }
    else{if(E1_selection.contains(token.get(i).cp))return true;}
        return false;  
}
Boolean A_2()
{
     if(token.get(i).cp.equals("["))
     {
         i++;
         if(exp(CS,CC,T3)){
             if(token.get(i).cp.equals("]")){
         i++;
         return true;
     }
         }
     }
     else{if(E1_selection.contains(token.get(i).cp)|| (token.get(i).cp.equals("->")))return true;}
        return false;
} 
Boolean E3()
{
       if(token.get(i).cp.equals("->")){
           i++;
           if(token.get(i).cp.equals("ID")){
               i++;
               if(E1()){
           return true;
       }}}
       else{if(E1_selection.contains(token.get(i).cp))return true;}
        return false; 
} 
Boolean ARG()
{
       if(token.get(i).cp.equals("ID")){
           i++;
           if(E1()){
               if(E6()){
           if(E4()){
               return true;}}}}
       else if(Const()){
                      if(E4()){

                   return true;
                      }               }
       else{if((token.get(i).cp.equals(")")))return true;}
        return false;
} 
Boolean E4()
{
       if(token.get(i).cp.equals(",")){
           i++;
              if(token.get(i).cp.equals("ID")){
i++;
       if(E1()){
           if(E6()){
               if(E4()){

           return true;}}}}
       else if(Const()){
            if(E4()){

           return true;}    
           }
       
       
       }
       else{if(token.get(i).cp.equals(")"))return true;}
        return false; 
} 
Boolean E6()////////////////////////////////////////////////////
{
        if(token.get(i).cp.equals("(")){
            i++;
            if(ARG()){
                if(token.get(i).cp.equals(")")){
                    i++;
            return true;}}}
        
        
        else{
            g=token.get(i).cp; 
            if(E6_selection.contains(g)){
            return true; }
        }
        return false; 
} 
Boolean E8()//////////////////////////////////////////////////
{
    if(E1_selection.contains(token.get(i).cp)){
        if(E1()){
            return true;
        }
    }
    else if(token.get(i).cp.equals("(")){
        i++;
        if(ARG()){
            if(token.get(i).cp.equals(")")){
                
            }
        }
        
    }
    
      
          
      return false;
} 
    Boolean Const() 
{
    if(constant.contains(token.get(i).cp)){i++;return true;}   
   return false; 
} 
//////////////////////////////////////////////////////////////////////////////////

Boolean DO_While_st(int CS,String CC) 
{
    if(token.get(i).cp.equals("do")){
        i++;
        if(M1())
     if(token.get(i).cp.equals("while")){
         i++;
         if(token.get(i).cp.equals("(")){
             i++;
             if(OE(CS,CC,T6))
                 if(token.get(i).cp.equals(")")){
                     i++;
                if(token.get(i).cp.equals(";")){
                    i++;
                        return true;
               }
                 }}}}
    
 return false;   
}
Boolean M1() 
{   
 if(token.get(i).cp.equals(";")){i++;return true;}
 else if(token.get(i).cp.equals("{")){i++;if(MST())if(token.get(i).cp.equals("}"))i++;return true;}
 return false;   
}
Boolean MST() 
{
       if(SST_Selection.contains(token.get(i).cp)){
           if(SST(CS,CC))
               if(MST())
                   return true;}
       else if(token.get(i).cp.equals("}")){
           return true;
       }
    
 return false;   
}
Boolean While_st(int CS,String CC) 
{
    if(token.get(i).cp.equals("while")){
        i++;
         if(token.get(i).cp.equals("(")){
             i++;
             if(OE(CS,CC,T6)){
                 if(token.get(i).cp.equals(")")){
                     i++;
                     if(while_body(CS,CC)){
                         return true;
                
                 }}}}}
    
 return false;   
}
boolean SST(int CS,String CC){
    
    if(if_st(CS,CC)){return true;}
   else if(While_st(CS,CC)){return true;}
    else if(for_st(CS,CC)){return true;}
    else if(DO_While_st(CS,CC)){return true;}
    else if(switch_st()){return true;}
    else if(token.get(i).cp.equals("incdec")){
        i++;
        if(token.get(i).cp.equals("ID")){
            i++;
        if(E1()){
            if(token.get(i).cp.equals(";")){
            return true;}}}
    }
       else if(token.get(i).cp.equals("break")){
       i++;
       if(token.get(i).cp.equals(";")){
           
       
           i++;
      return true;
       }
       }
         else if(token.get(i).cp.equals("contineu")){
       i++;
       if(token.get(i).cp.equals(";")){
           i++;
       return true;}
       }
         
         else if(token.get(i).cp.equals("return")){
       i++;
           if(OE(CS,CC,T6)){
               if(token.get(i).cp.equals(";")){
                   i++;
               
       return true;}}
         }      
         
  else if(token.get(i).cp.equals("this")){
       i++;
       if(token.get(i).cp.equals("->")){
           i++;
       if(token.get(i).cp.equals("ID")){
           i++;
           if(E1()){
              if(E6()){
                   if(sst1()){
                   return true;
              }
             }
           }
       }
      }
  }
       else if(token.get(i).cp.equals("super")){
       i++;
       if(token.get(i).cp.equals("->")){
           i++;
       if(token.get(i).cp.equals("ID")){
           i++;
         //  if(E1()){
           //    if(E6()){
                 if(sst1()){

                   return true;
             // }
              // }
           }
       }
      }
       
       }
       else if(token.get(i).cp.equals("ID")){
           i++;
           if(sst1()){
               return true;
           }
       }
       else if(token.get(i).cp.equals("DT")){
           i++;
           if(DEC0()){
               return true;
           }
       }
  
    return false;
    
}
boolean sst1(){
    if(token.get(i).cp.equals("incdec")){
        i++;
        if(token.get(i).cp.equals(";")){
            i++;
    return true;}
        
    }else if(E1()){
        if(sst2()){
            return true;
        }
        
    }else if(token.get(i).cp.equals("ID")){
        i++;
        if(Dec1()){
            if(Dec2()){
                if(Dec3()){
                    return true;
                }
            }
        }
    }
    return false;
}
boolean sst2(){
    if(token.get(i).cp.equals("=")){
        i++;
        if(Dec5()){
            if(token.get(i).cp.equals(";")){
                i++;
    return true;}
        }
    }else if(FC1()){
        if(token.get(i).cp.equals(";")){
            i++;
            return true;
        }
        
    }
    return false;
}
boolean while_body(int CS,String CC){

        if(token.get(i).cp.equals(";")){
            i++;
            return true;}
       else if(token.get(i).cp.equals("{")){
            i++;
            if(MST())
                if(token.get(i).cp.equals("}")){
                                i++;
            return true;}}
       else if(SST_Selection.contains(token.get(i).cp)){
           if(SST(CS,CC)){
           return true;}
       }
          


    return false;
    
}
boolean Dec1() {
        if(token.get(i).cp.equals("[")){
        i++;
                if(token.get(i).cp.equals("]")){
                i++;
                if(DEC4()){
                    return true;
                }
                }
        }else if((token.get(i).cp.equals(";"))||(token.get(i).cp.equals("="))||(token.get(i).cp.equals(","))){
            return true;
            
        }
    return false;
    }
boolean Dec2() {
        if(token.get(i).cp.equals("=")){
            i++;
            if(Dec5()){
                return true;
            }
        }else if(token.get(i).cp.equals(";")||token.get(i).cp.equals(",")){
            return true;
            
        }
        
        
    return false;
    }
boolean Dec3() {
         if(token.get(i).cp.equals(";")){
             i++;
             return true;
         }else if(token.get(i).cp.equals(",")){
             i++;
             if(DEC0()){
                 return true;
             }
                     
         }
         
    return false;
    }
boolean Dec5() {
         
         if(OE(CS,CC,T6)){
             return true;
         }else if(token.get(i).cp.equals("{")){
             i++;
             if(D1()){
                 if(token.get(i).cp.equals("}"))
             i++;
                 return true;
                     }
         }else if(token.get(i).cp.equals("new")){
             i++;
             if(token.get(i).cp.equals("ID")||token.get(i).cp.equals("DT")||token.get(i).cp.equals("string")){
                 i++;
                 if(D2()){
                     return true;
                 }
             }
         }
         
    return false;
    }
boolean Function_call(){
            if(token.get(i).cp.equals("ID"))
            {
                i++;
                         if(E1()){
                             if(FC1()){
                                 return true;
                             }
                         }

            }
         
         
         return false;
         
     }
boolean FC1() {
         
         if(token.get(i).cp.equals("("))
         {
             i++;
             if(ARG()){
             if(token.get(i).cp.equals(")"))
             {       i++;
return true;             
             }
             }
         }
         
    return false;
    }
boolean DEC0() {
        if(token.get(i).cp.equals("ID")){
            i++;
            if(Dec1()){
                if(Dec2()){
                    if(Dec3()){
                        return true;
                    }
                }
            }
        }
        
        
    return false;
    }
boolean Switch_body(){
    if(token.get(i).cp.equals("{")){
        i++;
        if(Case()){
            if(Default()){
                if(token.get(i).cp.equals("}")){
                    i++;
                    return true;
            }}
            
        }
        
    }
    return false;
    
}
boolean Case(){
    if(token.get(i).cp.equals("case")){
        i++;
        if(OE(CS,CC,T6)){
        if(token.get(i).cp.equals(":")){
            i++;
            if(if_mst()){
                if(token.get(i).cp.equals("break")){
                    i++;
                    if(token.get(i).cp.equals(";")){
                        i++;
                        if(Case()){
                            return true;
                        }
                    }
                }
            }
        }}
    }else if(token.get(i).cp.equals("default")||token.get(i).cp.equals("}")){
        return true;
        
    }
    
    
    return false;
    
}
boolean Default(){
    if(token.get(i).cp.equals("default")){
        i++;
        if(token.get(i).cp.equals(":")){
            i++;
            if(if_mst()){
                return true;
            }
        }
    }else if(token.get(i).cp.equals("}")){
        return true;
    }
    return false;
    
}
boolean switch_st() {
        
        if(token.get(i).cp.equals("switch")){
            i++;
                 if(token.get(i).cp.equals("(")){
                     i++;
                     if(OE(CS,CC,T6)){
                         if(token.get(i).cp.equals(")"))
                             i++;
                         if(Switch_body()){
                             return true;
                         }
                     }
                 }
   
        }
        
    return false;
    }
boolean for_st(int CS,String CC) {
    if(token.get(i).cp.equals("for")){
        i++;
    if(token.get(i).cp.equals("(")){
        i++;
            if(f1()) {
            if(f2()){
            if(token.get(i).cp.equals(";")){
            i++;
            if(f3()){
            if(token.get(i).cp.equals(")")){
            i++;
            if(while_body(CS,CC)){
            return true;}
            }}
            }
                    
            }
                  
            }  
    }}
    return false;
    }
boolean if_sst(){
    if(if_st(CS,CC)){return true;}
    else if(While_st(CS,CC)){return true;}
    else if(for_st(CS,CC)){return true;}
    else if(DO_While_st(CS,CC)){return true;}
    else if(switch_st()){return true;}
    else if(token.get(i).cp.equals("incdec")){
        i++;
        if(token.get(i).cp.equals("ID")){
            i++;
        if(E1()){
            if(token.get(i).cp.equals(";")){
                i++;
            return true;}}
        
        }
    }
       
       
  else if(token.get(i).cp.equals("this")){
       i++;
       if(token.get(i).cp.equals("->")){
           i++;
       if(token.get(i).cp.equals("ID")){
           i++;
           if(E10())
           //if(E1()){
             //  if(E6()){
                   return true;
               //}
           //}
       }
      }
  }
       else if(token.get(i).cp.equals("super")){
       i++;
       if(token.get(i).cp.equals("->")){
           i++;
       if(token.get(i).cp.equals("ID")){
           i++;
           if(E10()){
              
          // if(E1()){
            //   if(E6()){
                   return true;
             //  }
           //}
           }
           
       }
      }
       
       }
       else if(token.get(i).cp.equals("ID")){
           i++;
           if(sst1()){
               return true;
           }
       }
       else if(token.get(i).cp.equals("DT")){
           i++;
           if(DEC0()){
               return true;
           }
       }
  
   
    
    
    return false;
    
}

boolean E10(){
    if(token.get(i).cp.equals("incdec")){
        i++;
        if(token.get(i).cp.equals(";")){
        i++;
    
        return true;
    }
    }
    if(token.get(i).cp.equals(";")){
        i++;
        return true;
    }
    if(token.get(i).cp.equals("->")){
        i++;
        if(token.get(i).cp.equals("ID")){
            i++;
            if(sst1()){
               return true;
            }
        }
    }
     if(token.get(i).cp.equals("[")){
        i++;
        if(exp(CS,CC,T3)){
            if(token.get(i).cp.equals("]")){
               
            i++;
            if(A_2()){
                if(E3()){
            
                    if(sst1()){
               return true;
            }
        }}
    }
     }
     }
    else if(E1_selection.contains(token.get(i))){
        return true;
    }
    
    return false;
}
boolean if_mst(){
    if(if_sst()){
        if(if_mst()){
            return true;
        }
    }
    else if(token.get(i).cp.equals("}")||token.get(i).cp.equals("break")){
    return true;
            
        }
    return false;
    
}
boolean Oelse(){
    if(token.get(i).cp.equals("else")){
        i++;
        if(if_body()){
            return true;
            
        }
    }/*else if(token.get(i).cp.equals("$")){
    return true;
    
    }*/
    return false;
    
}
boolean if_body(){
    if(if_sst()){
        return true;
    }else if(token.get(i).cp.equals(";")){
        i++;
        return true;
    }else if(token.get(i).cp.equals("{")){
        i++;
        if(if_mst()){
            if(token.get(i).cp.equals("}")){
                i++;
                return true;
            }
        }
    }
    
    return false;
       
   }
boolean if_st(int CS,String CC) {
    
    if(token.get(i).cp.equals("if")){
        i++;
        if(token.get(i).cp.equals("(")){
            i++;
            if(OE(CS,CC,T6)){
                if(token.get(i).cp.equals(")")){
                    i++;
                    if(if_body()){
                        if(Oelse()){
                            return true;
                        }
                    }
                }
            }
        }
    }
    
    return false;
    }
boolean DEC4() {
         if(token.get(i).cp.equals("[")){
                    i++;
                            if(token.get(i).cp.equals("]")){
i++;

return true;}
                }else if(token.get(i).cp.equals(";")||token.get(i).cp.equals(",")||token.get(i).cp.equals("=")){
                return true;
                }

        
    return false;
         
         
    }
boolean D1() {
       if(constant.contains(token.get(i).cp)){
           if(Array_1D()){
               return true;
           }
       }else if((token.get(i).cp).equals("(")){
           if(Array_2D()){
               return true;
           }
           
       }
       else if((token.get(i).cp).equals("}")){
           return true;
       }  
    return false;
    }
boolean D2() {
                             if(token.get(i).cp.equals("(")){
                          i++;
                          if(ARG()){
                              if(token.get(i).cp.equals(")")){
                                  i++;
                                  return true;

                              }
                              
                          }
                             }else if(token.get(i).cp.equals("[")){
                                 
i++;
                          if(exp(CS,CC,T3)){
                              if(token.get(i).cp.equals("]")){
                                  i++;
                                  if(D10()){
                                  return true;
                                  }
                              }
                          
                             }
        
                             }
    return false;
    }
boolean Declearation(){
    if(token.get(i).cp.equals("ID")||token.get(i).cp.equals("DT")||token.get(i).cp.equals("string")){
        i++;
        if(DEC0()){
            return true;
        }
    }else if(token.get(i).cp.equals("ID")){
        i++;
        if(DEC0()){
            return true;
        }
}
return false;
}
boolean f1() {
         if(token.get(i).cp.equals("ID")){
         i++;
         if(f4()){
         return true;}
         }
else if(token.get(i).cp.equals(";")){
         i++;
                 return true;}
 else if(token.get(i).cp.equals("DT")){
i++;
if(token.get(i).cp.equals("ID")){
i++;
if(Dec1()){
if(token.get(i).cp.equals("=")){
i++;
if(OE(CS,CC,T6)){
if(token.get(i).cp.equals(";"))
i++;
return true;}
}}}
}
//////else if(Assignment()){
//////             return true;
//////         }else if(Declearation()){
//////             return true;
//////         }
     return false;}
boolean f2() {
    if(OE_Selection.contains(token.get(i).cp)){
    if(OE(CS,CC,T6)){
    return true;}
    
    }
    else if(token.get(i).cp.equals(";")){
        return true;
    }
    
         
          return false;
     }
boolean f3() {
         if(token.get(i).cp.equals("ID")){
         i++;
         if(f5()){
         return true;}
         }
         else if(token.get(i).cp.equals("incdec")){
         i++;
         if(token.get(i).cp.equals("ID")){
         i++;
         if(E1()){
         return true;}}
         }else if(token.get(i).cp.equals(")")){
             return true;
         }
    
     return false;}
boolean f4() {
         if(E1_selection.contains(token.get(i).cp)){
         if(E1()){
              if(token.get(i).cp.equals("=")){
              i++;
                   if(OE(CS,CC,T6)){
                       if(token.get(i).cp.equals(";")){
                       i++;
                       return true;}}
              }}
         
         }        else if(token.get(i).cp.equals("ID")){
         i++;
         if(Dec1()){
              if(token.get(i).cp.equals("=")){
              i++;
                   if(OE(CS,CC,T6)){
                       if(token.get(i).cp.equals(";")){
                       i++;
                       return true;}}
              }}
         }
         return false;
     }
boolean f5() {
         if(token.get(i).cp.equals("incdec")){
         i++;
         return true;}
         else if(E1_selection.contains(token.get(i).cp)){
         if(E1()){
              if(token.get(i).cp.equals("=")){
              i++;
                   if(OE(CS,CC,T6)){
                       return true;}
         }}}
        return false;
}
boolean Assignment(){
if(token.get(i).cp.equals("ID")){
    i++;
    if(E1()){
        if(token.get(i).cp.equals("=")){
            i++;
            if(Dec5()){
                if(token.get(i).cp.equals(";"))
                    i++;
                return true;
            }
        }
    }
}else if(token.get(i).cp.equals("this")){
    i++;
//    if(token.get(i).cp.equals("ID")){
    if(E1()){
        if(token.get(i).cp.equals("=")){
            i++;
            if(Dec5()){
                if(token.get(i).cp.equals(";"))
                    i++;
                return true;
            }
        }
    }
}else if(token.get(i).cp.equals("super")){
    i++;
//    if(token.get(i).cp.equals("ID")){
    if(E1()){
        if(token.get(i).cp.equals("=")){
            i++;
            if(Dec5()){
                if(token.get(i).cp.equals(";"))
                    i++;
                return true;
            }
        }
    }
}
  //       }
         
         return false;
         
     }
boolean D10() {
    if(token.get(i).cp.equals("["))
    {   i++;
    if(exp(CS,CC,T3)){
        if(token.get(i).cp.equals("]")){
            i++;
            return true;
        }
    }
    
    }else if(token.get(i).cp.equals(";")||token.get(i).cp.equals(",")){
        return true;
    }
        
        
        return false;
    }
private boolean Array_1D() {
if(Const()){
    if(G11()){
        return true;
}}
    return false;

    }
private boolean Array_2D() {
    if(token.get(i).cp.equals("(")){
        i++;
        if(Array_1D()){
            if(token.get(i).cp.equals(")")){
                i++;
                if(G12()){
                    return true;
                }
            }
            
        }
    }
        
        return false;
    }
private boolean G11() {
   if(token.get(i).cp.equals(",")){
       i++;
if(Const()){
    if(G11()){
    return true;
    }
       }
   }else if(token.get(i).cp.equals("}")||token.get(i).cp.equals(")")){
       return true;
   }
        
        
        return false;
    }
private boolean G12() {
  if(token.get(i).cp.equals(",")){
      i++;
         if(token.get(i).cp.equals("(")){
        i++;
        if(Array_1D()){
            if(token.get(i).cp.equals(")")){
                i++;
                if(G12()){
                    return true;
                }
            }
            
        }
    }
  }else if(token.get(i).cp.equals("}")||token.get(i).cp.equals(")")){
      return true;
  }
        return false;
    }
boolean SF() {
    if(token.get(i).cp.equals("final")){
                Temp.setCategory(token.get(i).cv);
      i++;
             return true;
    }
   else if(token.get(i).cp.equals("static")){
           Temp.setStatic(true);
  i++;
             return true;
}
       else  if(token.get(i).cp.equals("abstract")){
            Temp.setCategory(token.get(i).cv);
             i++;
             return true;
         }else if(token.get(i).cp.equals("void")||token.get(i).cp.equals("string")||token.get(i).cp.equals("DT")||token.get(i).cp.equals("ID")){
             return true;
         }
         
         
    return false;
    }
boolean func_parameter()

{
         if(token.get(i).cp.equals("DT")||token.get(i).cp.equals("ID")){
           Temp.setType(token.get(i).cv+Temp.getType());
             i++;
             if(F1()){
                 if(token.get(i).cp.equals("ID")){
                     i++;
                     if(F3()){
                         return true;
                     }
                 }
             }
         }else if(token.get(i).cp.equals(")")){
             
             return true;
         }
    return false;
    }
boolean F3(){
         if(token.get(i).cp.equals(",")){
             i++;
             if(F6()){
                 return true;
                 
             }
         }else if(token.get(i).cp.equals(")")){
             return true;
         }
         
    return false;
    
}
boolean F6(){
          if(token.get(i).cp.equals("DT")||token.get(i).cp.equals("ID")){
        Temp.setType(token.get(i).cv+","+Temp.getType());

              i++;
             if(F1()){
                 if(token.get(i).cp.equals("ID")){
                     i++;
                     if(F3()){
                         return true;
                     }
                 }
             }
         }else if((token.get(i).cp.equals(")"))){
         return true;
             
         }
         
    return false;
         
     }
boolean func_body() {
         
         if(token.get(i).cp.equals("{")){
             sm.CreateScope();
             i++;
             if(if_mst()){
                 if(R()){
                     if(token.get(i).cp.equals("}")){
                         sm.DestroyScope();
                         i++;
                         return true;
                     }
                 }
             }
                     }else if(token.get(i).cp.equals(";")){
         i++;
         return true;
     }
    return false;
    }
boolean R(){

         if((token.get(i).cp.equals("return"))){
         i++;
         if(OE(CS,CC,T6)){
             if((token.get(i).cp.equals(";"))){
                 i++;
                 return true;
             }
         }
     }else if((token.get(i).cp.equals("}"))){
       //  i++;
       return true;
     }
         
     
         
         return false;
         
     }
boolean Accessmodifier(){
      
      if(token.get(i).cp.equals("Accessmodifier")){
          Temp.setAm(token.get(i).cv);
          
          i++;
          
          return true;
      }else if(token.get(i).cp.equals("static")||token.get(i).cp.equals("final")||token.get(i).cp.equals("abstract")||token.get(i).cp.equals("void")||token.get(i).cp.equals("String")||token.get(i).cp.equals("ID")||token.get(i).cp.equals("DT")||token.get(i).cp.equals("class")){
          return true;
      }
    return false;
      
  } 
boolean F1(){
      
      if(token.get(i).cp.equals("[")){
          i++;
          if(token.get(i).cp.equals("]")){
            i++;

              if(F2()){
                  return true;
              }
          }
      }else if(token.get(i).cp.equals("ID") || token.get(i).cp.equals("=")||token.get(i).cp.equals("(")){
          return true;
          
      }
    return false;
  }
boolean F2(){
      
      if(token.get(i).cp.equals("[")){
          i++;
          if(token.get(i).cp.equals("]")){
              i++;
                  return true;
          }
      }else if(token.get(i).cp.equals("ID")){
          return true;
          
      }
    return false;
  }
boolean return_type() {
   
    if(token.get(i).cp.equals("void")){
        Temp.setType("->"+token.get(i).cv);
        
        i++;
        if(token.get(i).cp.equals("ID"))
    i++;
        if(token.get(i).cp.equals("(")){
            i++;
            if(func_parameter()){
                if(token.get(i).cp.equals(")")){
                    i++;
                    if(func_body()){
                        FC=new FuncClassAttribute(Temp.getName(),Temp.getType(),Temp.getAm(),Temp.getStatic(),Temp.getCategory(),Temp.getAssigned());
                        System.out.println( FC.toString());
                        return true;
                        
                    }
                }
            }
        }
    }else if(token.get(i).cp.equals("DT")||token.get(i).cp.equals("ID")||token.get(i).cp.equals("string")){
        Temp.setType("->"+token.get(i).cv);

        i++;
        
        if(token.get(i).cp.equals("ID")){
            i++;
            if(CS1()){
                return true;
            }
            
        }
        
    }
    
    return false;
      
      
      
    }

boolean CS1(){
    if(token.get(i).cp.equals("[")||token.get(i).cp.equals("=")||token.get(i).cp.equals(";")||token.get(i).cp.equals(",")){
      if(Dec1()){
          if(Dec2()){
              if(Dec3()){
                  return true;
              }
          }
      }  
    }else if(token.get(i).cp.equals("(")){
        i++;
        if(func_parameter()){
            if(token.get(i).cp.equals(")")){
                i++;
                if(func_body()){
               FC=new FuncClassAttribute(Temp.getName(),Temp.getType(),Temp.getAm(),Temp.getStatic(),Temp.getCategory(),Temp.getAssigned());
                    System.out.println(FC.toString());
                    return true;
                }
            }
        }
        
    }
 return false;   
}

boolean func_st(){
if(token.get(i).cp.equals("Accessmodifier")||token.get(i).cp.equals("static")||token.get(i).cp.equals("final")||token.get(i).cp.equals("abstract")||token.get(i).cp.equals("void")||token.get(i).cp.equals("String")||token.get(i).cp.equals("ID")||token.get(i).cp.equals("DT")){
    if(Accessmodifier()){
        
        if(SF()){
            if(return_type()){
                
                
                if(token.get(i).cp.equals("ID")){
                    
                    Temp.setName(token.get(i).cv);
                    i++;
                    if(token.get(i).cp.equals("(")){
                        i++;
                        if(func_parameter()){
                     String B= sm.Funclookup(Temp.getName(),Temp.type,cd.Name);
                            if(B==null){
                                System.out.println("Redeclearation");
                                return false;
                            }
                            if(token.get(i).cp.equals(")")){
                                i++;
                                if(func_body()){
                                    
                                    return true;
                                }
                            }
                        }
                    }
                    
                }
                
            }
        }
    }
}
        
        
        return false;
        
    } 
     

   boolean constructor(){
       
       if(token.get(i).cp.equals("Accessmodifier")||token.get(i).cp.equals("ID")){
           if(token.get(i).cp.equals("ID")){
               i++;
               if(token.get(i).cp.equals("(")){
                   i++;
                   if(func_parameter()){
                       if(token.get(i).cp.equals(")")){
                           i++;
                           if(Cons_body()){
                               return true;
                               
                           }
                       }
                   }
               }
           }
       }
       
    return false;
       
   }

  boolean  Cons_body(){
        if(token.get(i).cp.equals("{")){
             i++;
             if(if_mst()){
                     if(token.get(i).cp.equals("}")){
                         i++;
                         return true;
                     }
                 }
                     }else if(token.get(i).cp.equals(";")){
         i++;
         return true;
     }
    return false;
  }
  
  boolean CF(){
      if(token.get(i).cp.equals("abstract")||token.get(i).cp.equals("final")){
          Temp.setCategory(token.get(i).cv);
          i++;
          return true;
      }else if(token.get(i).cp.equals("class")){
          return true;
          
      }
    return false;
  }
  boolean C1(){
      if(token.get(i).cp.equals("impliments")){
      Temp.setImpliment(token.get(i).cv);
          i++;
      
      if(token.get(i).cp.equals("ID")){
          i++;
          return true;
      }
      
      }
      else  if(token.get(i).cp.equals("extends")){
               Temp.setExtends(token.get(i).cv);

      i++;
      
      if(token.get(i).cp.equals("ID")){
          i++;
          return true;
      }
      
      
      }else if(token.get(i).cp.equals("{")){
          return true;
      }
      
    return false;
      
  }
  
  
  boolean C3(){
    if(token.get(i).cp.equals("(")){
        i++;
        if(func_parameter()){
            if(token.get(i).cp.equals(")")){
                i++;
                if(func_body()){
                    return true;
                }
            }
        }
    }else if(token.get(i).cp.equals("=")||token.get(i).cp.equals(";")||token.get(i).cp.equals(",")){
        if(Dec2()){
            if(Dec3()){
                return true;
            }
        }
        
        
    }else if(token.get(i).cp.equals(";")||token.get(i).cp.equals(",")){
        return true;
    }
    return false;
  }
  
  boolean C2(){
if(token.get(i).cp.equals("ID")){
    i++;
if(C3()){
    return true;
}
}else if(token.get(i).cp.equals("=")){
    i++;
    if(Dec5()){
        if(token.get(i).cp.equals(";")){
            i++;
            return true;
        }
    }
    
}else if(token.get(i).cp.equals(";")||token.get(i).cp.equals(",")||token.get(i).cp.equals("(")){
    if(C3()){
        return true;
        
    }
}   
      
      
    return false;
      
  }
  boolean class_mst(){
if(token.get(i).cp.equals("Accessmodifier")||token.get(i).cp.equals("static")||token.get(i).cp.equals("final")||token.get(i).cp.equals("abstract")||token.get(i).cp.equals("void")||token.get(i).cp.equals("DT")||token.get(i).cp.equals("ID")||token.get(i).cp.equals("string")){

      if(Accessmodifier()){
          if(SF()){
              if(return_type()){
                  return true;
              
          }
      }          
      }
}
      
    return false;
      
  }
  boolean class_body(){
      if(token.get(i).cp.equals("Accessmodifier")||token.get(i).cp.equals("static")||token.get(i).cp.equals("final")||token.get(i).cp.equals("abstract")||token.get(i).cp.equals("void")||token.get(i).cp.equals("DT")||token.get(i).cp.equals("ID")||token.get(i).cp.equals("string")||token.get(i).cp.equals("class")){
            if(class_mst()){
                if(class_body()){
                    return true;
                }
            }
      }else if(token.get(i).cp.equals("}")||token.get(i).cp.equals("$")){
          return true;
      }
      
      
    
        return false;
  }
 
boolean Class_St(){
    if(token.get(i).cp.equals("Accessmodifier")||token.get(i).cp.equals("abstract")||token.get(i).cp.equals("final")||token.get(i).cp.equals("class")){
    if(Accessmodifier()){
        
        if(CF()){
            if(token.get(i).cp.equals("class")){
                Temp.setType(token.get(i).cv);
                i++;
                if(token.get(i).cp.equals("ID")){
                    Temp.setName(token.get(i).cv);
                    for (int j = 0; j < sm.ClassAttribute.size(); j++) {
                        sm.ClassAttribute.get(j).Name.equals(token.get(i).cv);
                        System.out.println("REDECLEARATION");
                        return false;
                     
                        
                    }
                    i++;
                    if(C1()){
                        if(token.get(i).cp.equals("{"))
                            sm.CreateScope();
                            i++;
                        if(class_body()){
                            if(token.get(i).cp.equals("}")){
                                sm.DestroyScope();
                                i++;
     cd=new ClassesDefine(Temp.getName(),Temp.getType(), Temp.getAm(),Temp.getCategory(),Temp.getExtends(), Temp.getImpliment());
     sm.ClassAttribute.add(cd);
     System.out.println( cd.toString());
                    
                    if(Class_St()){
                    return true;
                            }
                        }
                        }
                    }
                }
            }
        }
    }    
    }else if(token.get(i).cp.equals("$")){
        return true;
        
    }
    
    return false;
}
}
    

