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
public class SemanticAnalyzer {
    String T1,T2,T3,T4,T5,T6;
    
    ArrayList<Tokensets> token;
String g;
ArrayList <String> SST_Selection,MST_selection,E6_selection,E8_selection,E1_selection,constant,OE_Selection,AE_Selection,ROP_Selection,exp_Selection,T_Selection;
int i;   
SymbolTable St=new SymbolTable();
    
    
    SemanticAnalyzer(ArrayList<Tokensets> token) {
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
        this.T1="";
        this.T2="";
        this.T3="";
        this.T4="";
        this.T5="";
        this.T6="";
      // this.St=new SymbolTable();

        i=0;   
    }
boolean SelectionSet(){
this.OE_Selection.add(":");this.OE_Selection.add("ID");this.OE_Selection.add("(");this.OE_Selection.add("!");this.OE_Selection.add("incdec");this.OE_Selection.add("stringcons");this.OE_Selection.add("floatcons");this.OE_Selection.add("doublecons");this.OE_Selection.add("intcons");this.OE_Selection.add("charcons");this.OE_Selection.add("boolcons");this.OE_Selection.add("this");this.OE_Selection.add("super");
this.constant.add("stringcons");this.constant.add("floatcons");this.constant.add("intcons");this.constant.add("charcons");this.constant.add("boolcons");
this.E1_selection.add(",");this.E1_selection.add(":");this.E1_selection.add("=");this.E1_selection.add(";");this.E1_selection.add("MDM");this.E1_selection.add("(");this.E1_selection.add("PM");this.E1_selection.add("ROP");this.E1_selection.add("ANDOR");this.E1_selection.add("$");this.E1_selection.add(")");this.E1_selection.add("]");this.E1_selection.add("[");
this.E8_selection.add(",");this.E8_selection.add(":");this.E8_selection.add("=");this.E8_selection.add(";");this.E8_selection.add("MDM");this.E8_selection.add("PM");this.E8_selection.add("ROP");this.E8_selection.add("ANDOR");this.E8_selection.add("$");this.E8_selection.add(")");this.E8_selection.add("]");this.E8_selection.add("[");
this.E6_selection.add(",");this.E6_selection.add(":");this.E6_selection.add("=");this.E6_selection.add(";");this.E6_selection.add("PM");this.E6_selection.add("MDM");this.E6_selection.add("ROP");this.E6_selection.add("ANDOR");this.E6_selection.add("$");this.E6_selection.add(")");this.E6_selection.add("]");this.E6_selection.add("[");
this.SST_Selection.add("return");this.SST_Selection.add("if");this.SST_Selection.add("while");this.SST_Selection.add("for");this.SST_Selection.add("do");this.SST_Selection.add("switch");this.SST_Selection.add("break");this.SST_Selection.add("contineu");this.SST_Selection.add("incdec");this.SST_Selection.add("this");this.SST_Selection.add("super");this.SST_Selection.add("ID");this.SST_Selection.add("DT");
String cc="";
int s=0;

//   return While_st();
  // return if_st();
//  return Assignment();///////////////////////////////////
// return func_st();
//return switch_st();///////////////////////////////////////
//return Class_St();

//return for_st();//////////////////////////////////////////

   return     OE(0,"A",T6);/////////////////////////////////////
 //  return DO_While_st();
//   return Declearation();//////////////////////////////
 //   return Function_call();

    }
    
    
    
    
    
    
///////////////////////////////////////////////////////    
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
  //  if(E8())
            return true;
}
    
//else {
//     if(token.get(i).cp.equals("incdec")){
//    i++;
//    if(token.get(i).cp.equals("ID")){
//        i++;
//    if(E1())
//        if(E6())
//    
//        return true;
//        }}
//else if((token.get(i).cp.equals("("))){
//    i++;
//    if((OE()))
//        if((token.get(i).cp.equals(")")))
//            i++;
//        return true;
//        }
//else if((token.get(i).cp.equals("!"))){
//    i++;
//    if((F()))
//        
//        return true;
//        }
//else if(Const()){
//        return true;
//        }
// else if((token.get(i).cp.equals("this"))  || (token.get(i).cp.equals("super"))){
//    i++;
//    if(token.get(i).cp.equals("->"))
//        i++;
//    if(token.get(i).cp.equals("ID"))
//        i++;
//        if(E8())
//        return true;
//        }
// }
////i++;}
//        return false;  } 
//Boolean E1(int s,String cc)
//{
//    if(token.get(i).cp.equals("->")){
//        i++;
//        if(token.get(i).cp.equals("ID")){
//            i++;
//            if(E1())
//                return true;
//        }
//    }else if(token.get(i).cp.equals("[")){
//        
//        i++;
//        if(OE()){
//            if(token.get(i).cp.equals("]")){
//                i++;
//                if(A_2()){
//                    if(E3()){
//                        return true;
//                    }
//                }
//            }
//        }
//    }else if(token.get(i).cp.equals("incdec")){
//        i++;
//        return true;
//    }
//    else{if(E1_selection.contains(token.get(i).cp))return true;}
//        return false;  
//}
//Boolean A_2(int s,String cc)
//{
//     if(token.get(i).cp.equals("["))
//     {
//         i++;
//         if(exp()){
//             if(token.get(i).cp.equals("]")){
//         i++;
//         return true;
//     }
//         }
//     }
//     else{if(E1_selection.contains(token.get(i).cp)|| (token.get(i).cp.equals("->")))return true;}
//        return false;
//} 
//Boolean E3(int s,String cc)
//{
//       if(token.get(i).cp.equals("->")){
//           i++;
//           if(token.get(i).cp.equals("ID")){
//               i++;
//               if(E1()){
//           return true;
//       }}}
//       else{if(E1_selection.contains(token.get(i).cp))return true;}
//        return false; 
//} 
//Boolean ARG()
//{
//       if(token.get(i).cp.equals("ID")){
//           i++;
//           if(E1()){
//               if(E6()){
//           if(E4()){
//               return true;}}}}
//       else if(Const()){
//                      if(E4()){
//
//                   return true;
//                      }               }
//       else{if((token.get(i).cp.equals(")")))return true;}
//        return false;
//} 
//Boolean E4(int s,String cc)
//{
//       if(token.get(i).cp.equals(",")){
//           i++;
//              if(token.get(i).cp.equals("ID")){
//i++;
//       if(E1()){
//           if(E6()){
//               if(E4()){
//
//           return true;}}}}
//       else if(Const()){
//            if(E4()){
//
//           return true;}    
//           }
//       
//       
//       }
//       else{if(token.get(i).cp.equals(")"))return true;}
//        return false; 
//} 
//Boolean E6(int s,String cc)////////////////////////////////////////////////////
//{
//        if(token.get(i).cp.equals("(")){
//            i++;
//            if(ARG()){
//                if(token.get(i).cp.equals(")")){
//                    i++;
//            return true;}}}
//        
//        
//        else{
//            g=token.get(i).cp; 
//            if(E6_selection.contains(g)){
//            return true; }
//        }
//        return false; 
//} 
//Boolean E8(int s,String cc)//////////////////////////////////////////////////
//{
//    if(E1_selection.contains(token.get(i).cp)){
//        if(E1()){
//            return true;
//        }
//    }
//    else if(token.get(i).cp.equals("(")){
//        i++;
//        if(ARG()){
//            if(token.get(i).cp.equals(")")){
//                
//            }
//        }
//        
//    }
//    
//      
//          
//      return false;
//} 
//    Boolean Const() 
//{
//    if(constant.contains(token.get(i).cp)){i++;return true;}   
   return false; 
}





}
