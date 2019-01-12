/*/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

/**
 *
 * @author FCC
 */
public class pro2 {
    public String word;
    int lineno;

    public pro2(String word, int lineno) {
        this.word = word;
        this.lineno = lineno;
    }

    public pro2() {
    }
    

    @Override
    public String toString() {
        return "pro{" + "word=" + word + ", lineno=" + lineno + '}';
    }
    
    
    
}

 
