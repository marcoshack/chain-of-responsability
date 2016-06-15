package com.amazon.marchack.chain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class Output {
	private final Map<String, String> data = new HashMap<>();
	
	public Output(Optional<Output> previous) {
		if (previous.isPresent()) {
			data.putAll(previous.get().getData());
		}
	}
	
	public String add(String key, String value) {
		return data.put(key, value);
	}
	
	public String get(String key) {
		return data.get(key);
	}
	
	public Map<String, String> getData() {
		return data;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Iterator<Entry<String, String>> iter = data.entrySet().iterator();
		while (iter.hasNext()) {
		    Entry<String, String> entry = iter.next();
		    sb.append(entry.getKey());
		    sb.append('=').append('"');
		    sb.append(entry.getValue());
		    sb.append('"');
		    if (iter.hasNext()) {
		        sb.append(',').append(' ');
		    }
		}
		return sb.toString();
	}
}
