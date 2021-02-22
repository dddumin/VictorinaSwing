
package model;

import java.util.ArrayList;
import java.util.List;

public class Cipher {
    public Cipher() {       
    }
    
    private char caesarCipher(char c) {
        if (c >= 'a' && c < 'x' || c >= 'A' && c < 'X')
            return (char) (c + 3);
        if (c >= 'x' && c <= 'z' || c >= 'X' && c <= 'Z')
            return (char) (c - 23);
        return c;
    }

    public String caesarCipher(String s) {
        String a = "";
        for (int i = 0; i < s.length(); i++) {
            a += caesarCipher(s.charAt(i));
        }
        return a;
    }
    
    private char decryptionCaesar(char c){
        if(c>= 'a' + 3 && c < 'x' + 3 || c >= 'A' + 3 && c < 'X' + 3)
            return (char) (c-3);
        if (c >= 'x' - 23 && c <= 'z' - 23 || c >= 'X' - 23 && c <= 'Z' - 23)
            return (char) (c + 23);
        return c;
    }
        
    
    public String decryptionCipher(String s) {
        String a = "";
        for (int i = 0; i < s.length(); i++) {
            a += decryptionCaesar(s.charAt(i));
        }
        return a;
    }
    
    public List<String> caesarCipher(List<String> strings) {
        List<String> list = new ArrayList<>();         
         for (String string : strings) {                         
            String a = "";
            for (int i = 0; i < string.length(); i++) {
                a += caesarCipher(string.charAt(i));
            }
            list.add(a);
        }
        return list;
    }
     
     public List<String> decryptionCipher(List<String> strings) {
         List<String> list = new ArrayList<>();         
         for (String string : strings) {                         
            String a = "";
            for (int i = 0; i < string.length(); i++) {
                a += decryptionCaesar(string.charAt(i));
            }
            list.add(a);
        }
        return list;
    }
     
    public void caesarCipher(Data data){
        List<Result> results = data.getResults();        
        for (Result result : results) {
            result.setCorrectAnswer(this.caesarCipher(result.getCorrectAnswer()));
            result.setIncorrectAnswers(this.caesarCipher(result.getIncorrectAnswers()));
        }
    }
    
    public void decryptionCaesarCipher(Data data){
        List<Result> results = data.getResults();        
        for (Result result : results) {
            result.setCorrectAnswer(this.decryptionCipher(result.getCorrectAnswer()));
            result.setIncorrectAnswers(this.decryptionCipher(result.getIncorrectAnswers()));
        }
    }
}
