package com.amazon.marchack.chain.example;

import com.amazon.marchack.chain.Request;
import com.amazon.marchack.chain.SimpleChain;

public class MyChain {

	public static void main(String[] args) {
		Request request = new Request();
		
		SimpleChain chain1 = new SimpleChain();
		chain1.add(new MyChainable("ModuleA"));
		chain1.add(new MyChainable("ModuleB"));
		System.out.println("chain1: " + chain1.execute(request));
		
		SimpleChain chain2 = new SimpleChain();
		chain2.add(new MyChainable("ModuleB"));
		chain2.add(new MyChainable("ModuleA"));
		System.out.println("chain2: " + chain2.execute(request));
	}
}
