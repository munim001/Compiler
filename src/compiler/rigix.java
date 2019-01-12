/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

//import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.regex.*;
/**
 *
 * @author FCC
 */
public class rigix {
    ArrayList datatypes;
    ArrayList keywords;
    ArrayList Accessmodifier;
    ArrayList Operator;
    ArrayList punctuator;
    ArrayList AndORoperator;
    ArrayList incdec;
    ArrayList commint;
    ArrayList REFOP;
    ArrayList divide;

    public  rigix() {
        this.divide = new ArrayList<String> ();
        this.REFOP = new ArrayList<String> ();
        this.commint = new ArrayList<String> ();
        this.incdec = new ArrayList<String> ();
        this.AndORoperator = new ArrayList<String> ();
        this.punctuator = new ArrayList<String> ();
        this.Operator = new ArrayList<String> ();
        this.Accessmodifier = new ArrayList<String> ();
        this.keywords = new ArrayList<String> ();
        this.datatypes = new ArrayList<String> ();
        REFOP.add("->");
        divide.add("/");
        incdec.add("++");
        incdec.add("--");
        AndORoperator.add("&&");
        AndORoperator.add("||");
        datatypes.add("int");
        datatypes.add("char");
        datatypes.add("double");
        datatypes.add("float");
        keywords.add("string");
        keywords.add("break");
        keywords.add("class");
        keywords.add("contineu");
        keywords.add("do");
        keywords.add("else");
        keywords.add("false");
        keywords.add("for");
        keywords.add("if");
        keywords.add("interface");
        keywords.add("null");
        keywords.add("return");
        keywords.add("this");
        keywords.add("final");
        keywords.add("while");
        keywords.add("new");
        keywords.add("super");
                keywords.add("abstract");

                keywords.add("default");



       // keywords.add("true");
      //  keywords.add("false");
        keywords.add("switch");
        keywords.add("get");
        keywords.add("set");
        keywords.add("extends");
                keywords.add("impliments");

        keywords.add("static");
        keywords.add("case");
        keywords.add("void");
        Accessmodifier.add("private");
        Accessmodifier.add("public");
        Accessmodifier.add("protected");
        keywords.add("main");
         Operator.add("*");
          Operator.add("=");
          Operator.add("%");
          Operator.add("!");
          Operator.add("<");
          Operator.add(">");
          punctuator.add("->");/////////////////////////////
          punctuator.add("(");
          punctuator.add(")");
          punctuator.add("[");
          punctuator.add("]");
          punctuator.add("{");
          punctuator.add("}");
          punctuator.add(";");
          punctuator.add(",");
 

    }
    
    
 public String RG(String word ){
     Pattern p=Pattern.compile("( ([a-zA-Z]|[0-9])+|[a-zA-Z]([a-zA-Z]|[0-9])*)");
    Matcher m=p.matcher(word);
     Pattern p1=Pattern.compile("(([+-]?)([0-9]+))");
       Matcher m1=p1.matcher(word);
         Pattern p2=Pattern.compile("(([+-]?)([0-9]*)[.]([0-9]+)((e)([+-]?)([0-9]+))*)");
       Matcher m2=p2.matcher(word);
                 Pattern p3=Pattern.compile("\'(([a-zA-Z]|(\\\\[trnbf])|([\\\\|\"|\\']{2}))\')");
       Matcher m3=p3.matcher(word);
         Pattern p4=Pattern.compile("\"((([A-Za-z0-9]*)|(\\\\|\\[\\])|([!\"@{}#$%^&*()|_+-=,.<>?/ ]))*\")");
             Matcher m4=p4.matcher(word);
         
      
      if(keywords.contains(word)){
        return word;
    }
      
      
        else if(word.equals("false")){
        return "boolcons";
        
    }
    else if(word.equals("true")){
        return "boolcons";
        
    }
     
  
      else if(word.equals("$")){
        return "$";}
      else if(word.equals(":")){
        return ":";}
      
      else if(word.equals("-")){
        return "PM";}
      else if(word.equals("*")){
        return "MDM";}
      else if(word.equals("/")){
        return "MDM";}
      else if(word.equals("%")){
        return "MDM";}
      else if(word.equals("+")){
        return "PM";}
      else if(word.equals("=")){
        return "=";    }
      else if(word.equals("+=")){
        return "+=";    }
      else if(word.equals("-=")){
        return "-=";    }
      else if(word.equals("*=")){
        return "*=";    }
      else if(word.equals("/=")){
        return "/=";    }
      else if(word.equals("%=")){
        return "%=";    }
      else if(word.equals("!")){
        return "!";    }
        else if(word.equals("==")){
        return "ROP";    }
        else if(word.equals("!=")){
        return "ROP";    }
        else if(word.equals("<")){
        return "ROP";    }
              else if(word.equals(">")){
        return "ROP";    }
              else if(word.equals(">=")){
        return "ROP";    }
              else if(word.equals("<=")){
        return "ROP";    }
    else if(datatypes.contains(word)){
        return "DT";
        
    }
   
    else if(incdec.contains(word)){
        return "incdec";
        
    }
    else if(divide.contains(word)){
        return "divide";
        
    }
    else if(REFOP.contains(word)){
        return "->";
        
    }
    else if(AndORoperator.contains(word)){
        return "ANDOR";
        
    }
//     else if(Operator.contains(word)){
//        return "Operator";
//        
    //}
      else if(punctuator.contains(word)){
        return word;
        
    }
    
      else if(Accessmodifier.contains(word)){
        return "Accessmodifier";
        
    }
      
       
    else if (m.matches()){
    return "ID";
    }
    
   //integer 
    else if(m1.matches()){  
  
        
        return "intcons";
    }
    //float
         else if(m2.matches()){  
        
        return  "floatcons"; }
         //char
         else if(m3.matches()){ 
       
        return "charcons";}
         else if(m4.matches()){ 
      
        return "stringcons";}
         
         
         else {
                // System.out.println("Invalid");
                 return "invalid";
         }
     
 }
}
    
         
     
    

//     return null;
// 


 

