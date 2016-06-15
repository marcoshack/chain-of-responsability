package com.amazon.marchack.chain.example;

import java.util.Objects;
import java.util.Optional;

import com.amazon.marchack.chain.Chainable;
import com.amazon.marchack.chain.Output;
import com.amazon.marchack.chain.Request;

public class MyChainable implements Chainable {

	private final String id;
	
	public MyChainable(String id) {
		this.id = Objects.requireNonNull(id, "id cannot be null");
	}
	
	@Override
	public Optional<Output> process(Request request, Optional<Output> previousOutput) {
		Output output = new Output(previousOutput);
		output.add(id+".value", previousOutput.isPresent() ? "I'm NOT the first" : "I'm the first");
		return Optional.of(output);
	}
	
	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyChainable other = (MyChainable) obj;
		return id.equals(other.getId());
	}
}
