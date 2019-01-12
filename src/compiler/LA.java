/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

/**
 *
 * @author FCC
 */
public class LA   {
    
    String temp;
ArrayList Operator ;
ArrayList punctuator ;
ArrayList<pro2> wordcontainer ;
ArrayList datatypes;
ArrayList keywords;
ArrayList Accessmodifier;
Boolean flag=false;
Boolean flag2=false;



File f;
Tokensets ts=new Tokensets();  
ArrayList<String> filecontentarray1=new ArrayList<>();
ArrayList<Tokensets> token=new ArrayList<>();
pro2 pro=new pro2();
rigix re=new rigix();
  Pattern p0=Pattern.compile("(([+-]?)([0-9]+))");
       Matcher m0;//=p0.matcher(word);
   

    public LA() {
        this.Accessmodifier = new ArrayList<String> ();
        this.keywords = new ArrayList<String> ();
        this.datatypes = new ArrayList<String> ();
        this.f = new File("code1.txt");
        this.temp="";
        this.Operator = new ArrayList<String>();
        this.punctuator = new ArrayList<String>();
        this.wordcontainer = new ArrayList<pro2>();
    }
 void  dec() throws FileNotFoundException {
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
          punctuator.add(":");
          punctuator.add(",");
          
          
          token(punctuator,Operator);
          
          
    }
 
  void token(ArrayList punctuator,ArrayList<String> Operator) throws FileNotFoundException{
       Scanner filecontent=new Scanner(f);
      int count=0;
      while(filecontent.hasNext()){
          count++;
          
        filecontentarray1=new ArrayList<>();
             String[]    filecontentarray=filecontent.nextLine().split("");
             
             for (int i = 0; i < filecontentarray.length; i++) {
                filecontentarray1.add(filecontentarray[i]);
             }
             
             for (int i = 0; i < filecontentarray1.size(); i++) {
              if (ispunctuator(filecontentarray1.get(i))) {
                   if (!temp.equals("")) {
                       
                       pro.word=temp;
                       pro.lineno=count;
                       wordcontainer.add(pro);
                       temp="";
                       pro=new pro2();
                       temp=filecontentarray1.get(i);
                       
                       pro.word=temp;
                       pro.lineno=count;
                       wordcontainer.add(pro);
                       temp="";
                       pro=new pro2();
                   } else {
                       temp+=filecontentarray1.get(i);
                       
                       pro.word=temp;
                       pro.lineno=count;
                       wordcontainer.add(pro);
                       temp="";
                       pro=new pro2();
//                    
                   }
               }
              
              
               else if(isoperator(filecontentarray1.get(i))){
                       if(!temp.equals("")){
              
                           pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                    temp+=filecontentarray1.get(i);
                    if((i+1)<filecontentarray1.size()){
                    if(filecontentarray1.get(i+1).equals("=")){
                        temp+=filecontentarray1.get(++i);
              
                        pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                    }else{
              
                        pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                    }
                    }else{
              
                     pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();   
                    }
               }else{
                     temp+=filecontentarray1.get(i);
                    if((i+1)<filecontentarray1.size()){
                    if(filecontentarray1.get(i+1).equals("=")){
                        temp+=filecontentarray1.get(++i);
              
                        pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                    }else{
              
                        pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                    }
                    }else{
              
                     pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();   
                    }      
                       }
           
               }//operator complte
              
              else if(iscommint(filecontentarray1.get(i))){
                  if(!temp.equals("")){
              
                     pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                    temp+=filecontentarray1.get(i);
                    if((i+1)<filecontentarray1.size() && filecontentarray1.get(i+1).equals("/")){
                        for (int j = i+1; j <filecontentarray1.size(); j++) {
                            temp+=filecontentarray1.get(j);
                            i=j;
                        }

                    pro.word=temp;
                    pro.lineno=count;
                   // wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                        
                    }else{
              
                        pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                    }
                    
                    
                  }else{
                    temp+=filecontentarray1.get(i);
                    if((i+1)<filecontentarray1.size() && filecontentarray1.get(i+1).equals("/")){
                        for (int j = i+1; j <filecontentarray1.size(); j++) {
                            temp+=filecontentarray1.get(j);
                            i=j;
                        }
              
                        pro.word=temp;
                    pro.lineno=count;
                   // wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                        
                    }else{
              
                        pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                    }   
                  }
              }//COMMENTS BHI COMPLETE HAIN
              
            else if (filecontentarray1.get(i).equals(" ")) {
            if(!temp.equals("")){
                    pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    
                     pro=new pro2();}
                   
            }
            
            else if(issinglequotes(filecontentarray1.get(i))){
            if(!temp.equals("")){
                    pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
            temp+=  filecontentarray1.get(i);
               
                if((i+1)<filecontentarray1.size()){
                           String r=filecontentarray1.get(i+1);
                           temp+=  filecontentarray1.get(++i);
                           if((i+1)<filecontentarray1.size()){
                                                      temp+=  filecontentarray1.get(++i);
                                                      if((i+1)<filecontentarray1.size() && r.equals("\\")){
                                                           temp+=  filecontentarray1.get(++i);
                                                                pro.word=temp;
                                        pro.lineno=count;
                                        wordcontainer.add(pro);
                                         temp="";
                                         pro=new pro2(); 
                                                      }else{
                    pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2(); 
                                                      }
    
                           }else{
                     pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                           }

                }else{
                     pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                }
            }
            else{
                   temp+=  filecontentarray1.get(i);
               
                if((i+1)<filecontentarray1.size()){
                           String r=filecontentarray1.get(i+1);
                           temp+=  filecontentarray1.get(++i);
                           if((i+1)<filecontentarray1.size()){
                                                      temp+=  filecontentarray1.get(++i);
                                                      if((i+1)<filecontentarray1.size() && r.equals("\\")){
                                                           temp+=  filecontentarray1.get(++i);
                                                                pro.word=temp;
                                        pro.lineno=count;
                                        wordcontainer.add(pro);
                                         temp="";
                                         pro=new pro2(); 
                                                      }else{
                    pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2(); 
                                                      }
    
                           }else{
                     pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                           }

                }else{
                     pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                }
            }
            }
            
//            //SINGLE qoutes complete hoa
            
            else if(isdoublequotes(filecontentarray1.get(i))){
               int j;
               if(!temp.equals("")){
                   pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                                   pro=new pro2();

                temp+=filecontentarray1.get(i);
                  for (j = i+1; j <filecontentarray1.size() ; j++) {
                      if(filecontentarray1.get(j).equals("\"")){
                          temp+=filecontentarray1.get(j);
                          i=j;
                          break;
                      }else if(filecontentarray1.get(j).equals("\\")){
                          if((j+1)<filecontentarray1.size()){
                             temp+=filecontentarray1.get(j);
                             temp+=filecontentarray1.get(++j);
                          }else{
                              temp+=filecontentarray1.get(j);
                                i=j;
                                break;
                          }
                      }
                          
                      
                      else{
                              temp+=filecontentarray1.get(j);
                          }
                      
                  }   
                    pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    i=j;
                    pro=new pro2();
                  
                  }else{
                    temp+=filecontentarray1.get(i);
                  for (j = i+1; j <filecontentarray1.size() ; j++) {
                      if(filecontentarray1.get(j).equals("\"")){
                          temp+=filecontentarray1.get(j);
                          i=j;
                          break;
                      }else if(filecontentarray1.get(j).equals("\\")){
                          if((j+1)<filecontentarray1.size()){
                             temp+=filecontentarray1.get(j);
                             temp+=filecontentarray1.get(++j);
                          }else{
                              temp+=filecontentarray1.get(j);
                                i=j;
                                break;
                          }
                      }
                          
                      
                      else{
                              temp+=filecontentarray1.get(j);
                          }
                      
                  }   
                    pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    i=j;
                    pro=new pro2();
                  
               }
            }           
            //doubleqoutes complete  hai
//            
            
            else if(isbackslash(filecontentarray1.get(i))){
                if(!temp.equals("")){
            
                    pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                    temp+=filecontentarray1.get(i);
                    if((i+1)<filecontentarray1.size()){
                        temp+=filecontentarray1.get(++i);
            
                        pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                    }else{
            
                         pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                    }
                }else{
                    temp+=filecontentarray1.get(i);
                    if((i+1)<filecontentarray1.size()){
                        temp+=filecontentarray1.get(++i);
            
                        pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                    }else{
            
                         pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                }
            }
            }//BACK SLASH COMPLETE
                        
            else if(isminusoperator(filecontentarray1.get(i))){
                 
                if(!temp.equals("")){
            
                    pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                    temp+=filecontentarray1.get(i);
                    if((i+1) < filecontentarray1.size()) 
                        if( filecontentarray1.get(i+1).equals("-") || filecontentarray1.get(i+1).equals("=")||filecontentarray1.get(i+1).equals(">")){
                        temp+=filecontentarray1.get(++i);
                         
                      pro.word=temp;
                        pro.lineno=count;
                        wordcontainer.add(pro);
                        pro=new pro2();
                        temp="";}else{
            
                               pro.word=temp;
                        pro.lineno=count;
                        wordcontainer.add(pro);
                        pro=new pro2();
                        temp="";
                            
                    }else{
            
                        pro.word=temp;
                        pro.lineno=count;
                        wordcontainer.add(pro);
                        pro=new pro2();
                        temp="";
                    }
                        
                }else{
                    temp+=filecontentarray1.get(i);
                    if((i+1) < filecontentarray1.size()){ 
                        if(filecontentarray1.get(i+1).equals("-") || filecontentarray1.get(i+1).equals("=")||filecontentarray1.get(i+1).equals(">")){
                        temp+=filecontentarray1.get(++i);
            
                        pro.word=temp;
                        pro.lineno=count;
                        wordcontainer.add(pro);
                        pro=new pro2();
                       temp="";
                        }else{
            
                         pro.word=temp;
                        pro.lineno=count;
                        wordcontainer.add(pro);
                        pro=new pro2();
                       temp="";
                        }
                    }else{
            
                        pro.word=temp;
                        pro.lineno=count;
                        wordcontainer.add(pro);
                        pro=new pro2();
                        temp="";
                    }
                }
                
            }//minus KA KAAM FINISH
//            
//            
//            
            
            
            else if(isplusoperator(filecontentarray1.get(i))){
                 
                if(!temp.equals("")){
            
                    pro.word=temp;
                    pro.lineno=count;
                    wordcontainer.add(pro);
                    temp="";
                    pro=new pro2();
                    temp+=filecontentarray1.get(i);
                    if((i+1) < filecontentarray1.size()) 
                        if( filecontentarray1.get(i+1).equals("+") || filecontentarray1.get(i+1).equals("=")){
                        temp+=filecontentarray1.get(++i);
            
                        pro.word=temp;
                        pro.lineno=count;
                        wordcontainer.add(pro);
                        pro=new pro2();
                        temp="";}else{
            
                               pro.word=temp;
                        pro.lineno=count;
                        wordcontainer.add(pro);
                        pro=new pro2();
                        temp="";
                            
                    }else{
            
                        pro.word=temp;
                        pro.lineno=count;
                        wordcontainer.add(pro);
                        pro=new pro2();
                        temp="";
                    }
                        
                }else{
                    temp+=filecontentarray1.get(i);
                    if((i+1) < filecontentarray1.size()){ 
                        if(filecontentarray1.get(i+1).equals("+") || filecontentarray1.get(i+1).equals("=")){
                        temp+=filecontentarray1.get(++i);
            
                        pro.word=temp;
                        pro.lineno=count;
                        wordcontainer.add(pro);
                        pro=new pro2();
                       temp="";
                        }else{
            
                         pro.word=temp;
                        pro.lineno=count;
                        wordcontainer.add(pro);
                        pro=new pro2();
                       temp="";
                        }
                    }else{
            
                        pro.word=temp;
                        pro.lineno=count;
                        wordcontainer.add(pro);
                        pro=new pro2();
                        temp="";
                    }
                }
//                
            }//PLUS KA KAAM FINISH
//            
            
            
            else if(isANDORoperator(filecontentarray1.get(i))){
                if(!temp.equals("")){
            
                pro.word=temp;
                pro.lineno=count;
                   wordcontainer.add(pro);
                
                    temp="";
                    pro=new pro2();
                    temp+=filecontentarray1.get(i);
                    if((i+1)<filecontentarray1.size() && filecontentarray1.get(i+1).equals(filecontentarray1.get(i))){
                        temp+=filecontentarray1.get(++i);
            
                       pro.word=temp;
                pro.lineno=count;
                   wordcontainer.add(pro);
                
                        temp="";
                pro=new pro2();        
                    }else{
            
                        pro.word=temp;
                pro.lineno=count;
                   wordcontainer.add(pro);
                pro=new pro2();
                        temp="";
                    }
                }else{
                    temp+=filecontentarray1.get(i);
                     if((i+1)<filecontentarray1.size() && filecontentarray1.get(i+1).equals(filecontentarray1.get(i))){
                        temp+=filecontentarray1.get(++i);
            
                        pro.word=temp;
                pro.lineno=count;
                   wordcontainer.add(pro);
                pro=new pro2();
                        temp="";
                        
                    }else{
            
                         pro.word=temp;
                pro.lineno=count;
                   wordcontainer.add(pro);
                pro=new pro2();
                        temp="";
                    }
                }
                    
                
            }//AND OR COMPLETE 
            
            
          
            else if(isdot(filecontentarray1.get(i))){
               if((i+1)<filecontentarray1.size() && isdigit(filecontentarray1.get(i-1)) &&isdigit(filecontentarray1.get(i+1))){
              temp+=filecontentarray1.get(i++);
                while((i+1)<=filecontentarray1.size()){
                    if(!isdigit(filecontentarray1.get(i)) && !filecontentarray1.get(i).equals("e") || filecontentarray1.get(i).equals(" ")||isdoublequotes(filecontentarray1.get(i))||issinglequotes(filecontentarray1.get(i))||iscommint(filecontentarray1.get(i))||isANDORoperator(filecontentarray1.get(i)) || isoperator(filecontentarray1.get(i)) || ispunctuator(filecontentarray1.get(i))){
                    if(isplusoperator(filecontentarray1.get(i)) && flag2==false || isminusoperator(filecontentarray1.get(i)) && flag2==false){
                        flag2=true;
                        temp+=filecontentarray1.get(i);
                        i++;
                    } 
                        else{
                                i--;
                                
                        break;}
                    }else{
                        if(filecontentarray1.get(i).equals("e")){
                     if(flag==true){
                         i--;
                         break;
                     }else{
                         flag=true;
                        temp+=filecontentarray1.get(i);
                     
                        i++;
                     }    
                   }else{
                        temp+=filecontentarray1.get(i);
                        i++;
                        }
                        
                    }
                }
                                    
                                        pro.word=temp;
                                        pro.lineno=count;
                                        wordcontainer.add(pro);
                                        pro=new pro2();
                                        temp="";
                                            flag=false;
            }
               else{
                                         pro.word=temp;
                                        pro.lineno=count;
                                        wordcontainer.add(pro);
                                        pro=new pro2();
                                        temp="";
                                       temp= filecontentarray1.get(i);
                                       pro.word=temp;
                                        pro.lineno=count;
                                        wordcontainer.add(pro);
                                        pro=new pro2();
                                        temp="";
               }
            }

            else{
                temp+=filecontentarray1.get(i);///////////////////////////////////////////
              
            }
                   
                   
              
             }
      }
      pro=new pro2();
      pro.word="$";
      pro.lineno=count+1;
      wordcontainer.add(pro);
     // wordcontainer.forEach(System.out::println);
    this.fun();
   
  }  
 Boolean  ispunctuator(String var){return punctuator.contains(var); }
 Boolean  isoperator(String var){return Operator.contains(var);}
 Boolean issinglequotes(String var){return var.equals("'");}
 Boolean isdoublequotes(String var){return var.equals("\"");}
 Boolean isbackslash(String var){return var.equals("\\");}
 Boolean isminusoperator(String var){return var.equals("-");}
Boolean isplusoperator(String var){return var.equals("+");}
Boolean isANDORoperator(String var){return var.equals("&") || var.equals("|");}
Boolean iscommint(String var){return var.equals("/");} 
Boolean isdot(String var){return var.equals(".");} 
Boolean isdigit(String var){ m0= p0.matcher(var);        return m0.matches();
}

void fun(){
    String g;
    System.out.println(wordcontainer.size());
    for (int i = 0; i < wordcontainer.size(); i++) {
        g=wordcontainer.get(i).word;
       ts.cp= re.RG(g);
            
       ts.cv=wordcontainer.get(i).word;
       ts.lineno=wordcontainer.get(i).lineno;
       token.add(ts);
       ts=new Tokensets();
    }
    for (int i = 0; i < token.size(); i++) {
        
    
    System.out.println(token.get(i));
}}

}

   