package com.fbytes.mutatingtest;

import java.lang.reflect.Modifier;

public class MutatingTest {

	String s0="reflections test";
	String s1="reflections test";
	String s2="reflections test";
	String s3=new String("reflections test");
	
	int i1=1;
	int i2=2;
	
	
	public static void main(String[] args){
		
		MutatingTest mutatingTest=new MutatingTest();

		System.out.println("=>Pass1");
		mutatingTest.stringMutationTest();
		
		System.out.println();		
		System.out.println("=>Pass2");
		
		mutatingTest.s1=mutatingTest.s0;
		mutatingTest.s2=mutatingTest.s0;
		System.out.println("Interning s3");
		mutatingTest.s3=mutatingTest.s3.intern();
		mutatingTest.s1=mutatingTest.s1.intern();
		mutatingTest.s2=mutatingTest.s2.intern();
		
		mutatingTest.stringMutationTest();
		
		
		System.out.println();		
		System.out.println("=>Pass3");
		mutatingTest.s1=new String("reflections test");
		mutatingTest.s2=new String("reflections test");
		mutatingTest.s3=new String("reflections test");
		mutatingTest.s3=mutatingTest.s3.intern();
		mutatingTest.s1=mutatingTest.s1.intern();
		mutatingTest.s2=mutatingTest.s2.intern();
		
		
		mutatingTest.stringMutationTest();
		
	}

	
	void stringMutationTest(){
		
		System.out.println("=>stringMutationTest");
	
		System.out.println("s1==s2: "+String.valueOf(s1==s2));
		System.out.println("s1==s3: "+String.valueOf(s1==s3));

		System.out.println("Mutating strings....");
		Mutator.stringMutator(s1,"infections test");
		

		System.out.println("s1==s2: "+String.valueOf(s1==s2));
		System.out.println("s1: " + s1);	
		System.out.println("s2: " + s2);
		System.out.println("s3: " + s3);
		
		System.out.println();
		
/*
		System.out.println("Interning s3");
		s3=s3.intern();
		Mutator.stringMutator(s1,"infections test");
		System.out.println("Now s3: "+ s3);
*/		

	}
	
	
	void intMutationTest(){
		System.out.println("=>intMutationTest");
		System.out.println("i1="+String.valueOf(i1));
		Mutator.intMutator(i1, 3);
		System.out.println("Now i1="+String.valueOf(i1));		
	}
}
