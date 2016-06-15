package com.amazon.marchack.chain;

import java.util.HashMap;
import java.util.Map;

public class Request {
	private final Map<String, String> params = new HashMap<>();

	public Map<String, String> getParams() {
		return params;
	}
}
