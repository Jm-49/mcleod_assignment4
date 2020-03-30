package mcleod_problem2;

import java.io.File; import java.io.PrintWriter;
import java.util.HashMap; import java.util.Scanner;

public class DuplicateCounter {

	   private HashMap<String, Integer> wordCounter;
	   public DuplicateCounter(){
	       wordCounter = new HashMap<String, Integer>(); }

	   public void count(String dataFile){
	       wordCounter.clear();
	       try{
	           Scanner in = new Scanner(new File(dataFile));
	           String word;
	           while(in.hasNext()){
	               word = in.next();
	               word = cleanUp(word);
	               if(!word.equals("")) {
	                   if(wordCounter.get(word) == null)
	                       wordCounter.put(word, 1);
	                   else
	                       wordCounter.put(word, wordCounter.get(word) + 1);} }
	           in.close(); }
	       
	       catch(Exception fl){
	           System.out.println(fl.getMessage()); } }


	   public void write(String outputFile){
	       try{
	           PrintWriter out = new PrintWriter(new File(outputFile));
	           for(String word : wordCounter.keySet()){
	               out.println(word + " " + wordCounter.get(word)); }
	           out.close(); }
	       
	       catch(Exception fl){
	           System.out.println(fl.getMessage());} }

	   private String cleanUp(String word){
	       String str = "";
	       for(int i = 0; i < word.length(); i++){
	           char c = word.charAt(i);
	           if(Character.isAlphabetic(c))
	               str = str + c;
	       }
	       return str.toLowerCase().trim();
	   }
	}
