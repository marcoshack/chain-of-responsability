package com.amazon.marchack.chain;

import java.util.Optional;

public interface Chainable {
	public Optional<Output> process(Request request, Optional<Output> previousOutput);
}
