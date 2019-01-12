/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import com.sun.corba.se.impl.orbutil.ORBConstants;
import java.text.Normalizer;
import java.util.ArrayList;

/**
 *
 * @author FCC
 */
public class Systexanalyzer {
ArrayList<Tokensets> token;
String g;
ArrayList <String> SST_Selection,MST_selection,E6_selection,E8_selection,E1_selection,constant,OE_Selection,AE_Selection,ROP_Selection,exp_Selection,T_Selection;
int i;   

Systexanalyzer(ArrayList<Tokensets> token) {
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
//return Class_St();

//return for_st();//////////////////////////////////////////
//   return     OE();/////////////////////////////////////
   return DO_While_st();
//   return Declearation();//////////////////////////////
 //   return Function_call();

    }
Boolean OE(){
    if(OE_Selection.contains(token.get(i).cp)){
        if(AE())
            if(OEdesh())
                return true;
    }
    
        return false;  } 
Boolean OEdesh(){
    
    
      ArrayList<String> q3=new ArrayList<>();
    q3.add(":"); q3.add(")");q3.add("$");q3.add("]");
    q3.add(";");
     if(token.get(i).cp.equals("ANDOR")){
         i++;
        if(AE())
            if(OEdesh())
                return true;
    }   else{
        if(q3.contains(token.get(i).cp))
            return true;
    } 
   
    
    return false;  } 
Boolean AE(){
    if(OE_Selection.contains(token.get(i).cp)){
   
        if(ROP())
            if(AEdesh())
                return true;
    }
        return false;  } 
Boolean AEdesh(){
     ArrayList<String> q2=new ArrayList<>();
    q2.add(":");q2.add(")"); /*q2.add("ANDOR");*/q2.add("$");
    q2.add(";");q2.add("]");
   
    if(token.get(i).cp.equals("ANDOR")){
        i++;
        if(ROP())
            if(AEdesh())
                return true;
    }   else{
        if(q2.contains(token.get(i).cp))
            return true;
    } 
   
        return false;  } 
Boolean ROP(){
    if(OE_Selection.contains(token.get(i).cp)){

        if(exp()){
            if(ROPdesh())
        
                return true;}
    }
        return false;  } 
Boolean ROPdesh(){
     ArrayList<String> q1=new ArrayList<>();
    q1.add("]");q1.add(":");q1.add(")");q1.add("ANDOR");q1.add("$");  q1.add(";");
   
    if(token.get(i).cp.equals("ROP")){
        i++;
        if(exp())
            if(ROPdesh())
                return true;
    }   else{
        if(q1.contains(token.get(i).cp))
            return true;
    } 
    return false;  } 
Boolean exp(){
     if(OE_Selection.contains(token.get(i).cp)){

        if(T()){
            if(expdesh())
                return true;}
    }
    
        return false;  } 
Boolean expdesh(){
    ArrayList<String> q=new ArrayList<>();
    q.add(":");q.add(")");q.add("]");q.add("ROP");q.add("ANDOR");q.add("$");  q.add(";");
    if(token.get(i).cp.equals("PM")){

    i++;

        if(T())////////////////
            if(expdesh())
                return true;
    }   else{
        if(q.contains(token.get(i).cp))
            return true;
    }
    
        return false;  } 
Boolean T(){
    if(OE_Selection.contains(token.get(i).cp)){
        if(F()){
            if(Tdesh()){
                return true;}
        }}    
        return false;  } 
Boolean Tdesh(){
    ArrayList<String> q4=new ArrayList<>();
    q4.add(":");q4.add("PM");q4.add(")");q4.add("]");q4.add("ROP");q4.add("ANDOR");q4.add("$");  q4.add(";");
    if(token.get(i).cp.equals("MDM")){
        i++;
        if(F())
            if(Tdesh())
                return true;
    }   else{
        if(q4.contains(token.get(i).cp))
            return true;
    }
        return false;  }
Boolean F(){
    
String s=token.get(i).cp;
    
 if(s.equals("ID")){
    i++;
    if(E1())
        if(E6())
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
    if((OE()))
        if((token.get(i).cp.equals(")")))
            i++;
        return true;
        }
else if((token.get(i).cp.equals("!"))){
    i++;
    if((F()))
        
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
        if(OE()){
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
         if(exp()){
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
//////////////////////////////////////////////////////////////////////////////////
Boolean Const() 
{
    if(constant.contains(token.get(i).cp)){i++;return true;}   
   return false; 
}
////////////////////////////////////////////////////////////////////////////////////
Boolean DO_While_st() 
{
    if(token.get(i).cp.equals("do")){
        i++;
        if(M1())
     if(token.get(i).cp.equals("while")){
         i++;
         if(token.get(i).cp.equals("(")){
             i++;
             if(OE())
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
           if(SST())
               if(MST())
                   return true;}
       else if(token.get(i).cp.equals("}")){
           return true;
       }
    
 return false;   
}
Boolean While_st() 
{
    if(token.get(i).cp.equals("while")){
        i++;
         if(token.get(i).cp.equals("(")){
             i++;
             if(OE()){
                 if(token.get(i).cp.equals(")")){
                     i++;
                     if(while_body()){
                         return true;
                
                 }}}}}
    
 return false;   
}
boolean SST(){
    
    if(if_st()){return true;}
   else if(While_st()){return true;}
    else if(for_st()){return true;}
    else if(DO_While_st()){return true;}
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
           if(OE()){
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
boolean while_body(){

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
           if(SST()){
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
         
         if(OE()){
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
        if(OE()){
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
                     if(OE()){
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
boolean for_st() {
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
            if(while_body()){
            return true;}
            }}
            }
                    
            }
                  
            }  
    }}
    return false;
    }
boolean if_sst(){
    if(if_st()){return true;}
   else if(While_st()){return true;}
    else if(for_st()){return true;}
    else if(DO_While_st()){return true;}
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
        if(exp()){
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
boolean if_st() {
    
    if(token.get(i).cp.equals("if")){
        i++;
        if(token.get(i).cp.equals("(")){
            i++;
            if(OE()){
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
                          if(exp()){
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
if(OE()){
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
    if(OE()){
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
                   if(OE()){
                       if(token.get(i).cp.equals(";")){
                       i++;
                       return true;}}
              }}
         
         }        else if(token.get(i).cp.equals("ID")){
         i++;
         if(Dec1()){
              if(token.get(i).cp.equals("=")){
              i++;
                   if(OE()){
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
                   if(OE()){
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
    if(exp()){
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
         if(token.get(i).cp.equals("abstract")||token.get(i).cp.equals("static")||token.get(i).cp.equals("final")){
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
             i++;
             if(if_mst()){
                 if(R()){
                     if(token.get(i).cp.equals("}")){
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
         if(OE()){
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
        i++;
        if(token.get(i).cp.equals("ID"))
    i++;
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
        }
    }else if(token.get(i).cp.equals("DT")||token.get(i).cp.equals("ID")||token.get(i).cp.equals("string")){
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
                    i++;
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
          i++;
          return true;
      }else if(token.get(i).cp.equals("class")){
          return true;
          
      }
    return false;
  }
  boolean C1(){
      
      if(token.get(i).cp.equals("extends")||token.get(i).cp.equals("impliments")){
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
                i++;
                if(token.get(i).cp.equals("ID")){
                    i++;
                    if(C1()){
                        if(token.get(i).cp.equals("{"))
                            i++;
                        if(class_body()){
                            if(token.get(i).cp.equals("}")){
                                i++;
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

    