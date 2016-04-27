package com.fbytes.mutatingtest;

import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Set;

public class Mutator {

	
	static void stringMutator(String pString,String pNewValue) {
		
			/*
			java.lang.reflect.Field[] tFiledsList=pString.getClass().getDeclaredFields();
			System.out.println("FieldsCount: "+String.valueOf(tFiledsList.length));
			for (java.lang.reflect.Field tCurField : tFiledsList){
				StringBuilder strBuilder=new StringBuilder();
				strBuilder.append("Name:").append(tCurField.getName()).append("   Type:").append(tCurField.getType()). 
						append("   Modifiers:").append(Modifier.toString(tCurField.getModifiers()));

				System.out.println(strBuilder.toString());
			}
			*/
			
			java.lang.reflect.Field tStrValueField;
			try {
				tStrValueField = pString.getClass().getDeclaredField("value");
				tStrValueField.setAccessible(true);
				
				char[] tStrVal=(char[]) tStrValueField.get(pString);
				tStrValueField.set(pString, pNewValue.toCharArray());
				
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	

	}
	
	static void intMutator(int pInt,int pNewValue) {
		

		pInt=pNewValue;
		
		//Map.Entry <Thread, StackTraceElement []> entry: 
		Set<Map.Entry<Thread, StackTraceElement[]>> tTraceStackSet= Thread.getAllStackTraces().entrySet ();
		
		System.out.println("tTraceStackSet contains "+ tTraceStackSet.size()+ " elements");
		for (Map.Entry<Thread, StackTraceElement[]> traceElement : tTraceStackSet){
			
			System.out.println(new StringBuilder().append("Thread: ").append(traceElement.getKey().getName()));
			for (StackTraceElement tTraceElement : traceElement.getValue()){
				System.out.println(new StringBuilder().append("File: ").append(tTraceElement.getFileName()).append("  Line: ").append(tTraceElement.getLineNumber()).
						append("  toString:").append(tTraceElement.toString()));
			}
			System.out.println();
		}
		
		
		
		

}
	
}
