package com.amazon.marchack.chain;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class SimpleChain {
	private final Set<Chainable> chain = new LinkedHashSet<>();
	
	public boolean add(Chainable chainable) {
		return chain.add(chainable);
	}
	
	public Optional<Output> execute(Request request) {
		Optional<Output> previousOutput = Optional.empty(); 
		for (Chainable c : chain) {
			previousOutput = c.process(request, previousOutput);
		}
		return previousOutput;
	}
}
