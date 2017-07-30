/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Joni
 */
public class Sanatutkimus {
    private ArrayList<String> sanat;
    
    public Sanatutkimus(String tiedostonimi)  {
        this.sanat = new ArrayList<String>();
        try {
            Scanner lukija = new Scanner(new File(tiedostonimi), "UTF-8");
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                this.sanat.add(rivi);                
            }
        } catch (Exception e) {
            System.out.println("virhe sanojen lukemisessa!");
        }
    }
    public int sanojenMaara(){
         return this.sanat.size();       
    }
    public boolean onkoSanaa(String sana)throws Exception{
        for(String san : sanat){
            if (san.equals(sana)){
                return true;
            }
        }
        return false;
    }
    public int laskeSanat(int pituus){
        int maara = 0;
        try{
            for(String san : sanat){
                if (san.length()== pituus){
                    maara++;
                }
            }
        }catch(Exception e){
            
        }
        
        return maara;
    }
    public void pituustilasto(){
        int i = 1;
        while(i<31){
            System.out.println(i +" " + laskeSanat(i) );
            i++;
        }
    }
    public int laskeKirjaimet(char kirjain){
        int maara = 0;
        try{
            for(String san : sanat){
                int currentIndex = 0;

                while(true) {
                    if(san.indexOf(kirjain, currentIndex) == -1) {
                        break;
                    } else {
                        currentIndex = san.indexOf(kirjain, currentIndex) +1;
                        maara++;
                       
             
                    }
                }
            }
        }catch(Exception e){
            
        }
        
        return maara;
    }
    public void kirjaintilasto(){
        String kirjaimet = "abcdefghijklmnopqrstuvwxyzåäö";
        int i = 0;
        while (i< kirjaimet.length()){
            System.out.println(kirjaimet.charAt(i) + " " + laskeKirjaimet(kirjaimet.charAt(i)));
            i++;
        }
    }
    public ArrayList<String> haePituudella(int pituus){
        ArrayList<String> lista = new ArrayList<String>();
        for(String san : sanat){
            if (san.length()== pituus){
                 lista.add(san);
            }
        }
        return lista;
    }
    public ArrayList<String> haeOsalla(String osa){
        ArrayList<String> lista = new ArrayList<String>();
        for(String san : sanat){
            if (san.contains(osa)){
                 lista.add(san);
            }
        }
        return lista;
    }
    public ArrayList<String> haePalindromit(){
        ArrayList<String> lista = new ArrayList<String>();
        try{
            for(String sana : this.sanat){
                boolean onPalindromi = true;
                for(int i = 0; i < sana.length(); i++) {
                    if(sana.charAt(i) != sana.charAt(sana.length() - 1 - i)) {
                        onPalindromi = false;
                    }
                }
                if(onPalindromi) {
                    lista.add(sana);
                }
            }    
        }catch(Exception e){
            
        }
        
        return lista;       
    }
    public ArrayList<String> haeRistikkoon(String pohja){
            ArrayList<String> lista = new ArrayList<String>();
            for(String sana : this.sanat) {
                boolean onko = true;
                if (sana.length() == pohja.length()) {
                for (int i = 0; i < pohja.length(); i++) {
                    if (pohja.charAt(i) != sana.charAt(i) && pohja.charAt(i) != '?') {
                        onko = false;
                        break;
                    }
                }
                if (onko == true) {
                    lista.add(sana);
                }
                
                }
            }       
             return lista;
     }
}

