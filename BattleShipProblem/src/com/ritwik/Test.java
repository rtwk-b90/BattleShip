package com.ritwik;

import java.util.Arrays;
import java.util.List;

public class Test {

	 public static void main(String[] args)  
	   {  
	     String s="";
	     System.out.println("length="+s.length());
	     while (s.length()>1){
	    	 
	    	 
	    	 String m= s.substring(0, s.indexOf(" "));
	    	 s=s.substring(s.indexOf(" "));
	    	 System.out.println("length_mod="+s.length());
	    	 System.out.println("m="+m);
	    	 System.out.println("s="+s);
	    	 
	    	 
	     }
	    	  
	      }  
	       
	   }  


