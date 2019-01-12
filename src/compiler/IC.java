/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author DeLL
 */
public class IC {
    
    BufferedWriter writer;
    int labelCounter;
    int varCounter;

    public IC(String fileName) throws IOException {
        this.writer = new BufferedWriter(new FileWriter(fileName));
        this.writer.write("");
        this.labelCounter = 0;
        this.varCounter = 0;
    }

String CreateLabel(){
  
    return "L"+(++this.labelCounter)+":\n";
    
}    

String CreateVarl(){
    
    return "T"+(++this.varCounter)+":\n";
}
}
