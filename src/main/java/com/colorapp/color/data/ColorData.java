package com.colorapp.color.data;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public class ColorData {

	private static Map<String, String>  data = new HashMap<>();

	@PostConstruct
	private void createStaticData() {
		data.put("Red", "255,0,0");
		data.put("Lime", "0,255,0");
		data.put("Blue", "0,0,255");
		data.put("Yellow", "255,255,0");
		data.put("Cyan", "0,255,255");
		data.put("Magenta", "255,0,255");
		data.put("Silver", "192,192,192");
		data.put("Gray", "128,128,128");
		data.put("Maroon", "128,0,0");
		data.put("Olive", "128,128,0");
	}

	public Map<String, String> getData() {
		return data;
	}
	
	public void saveColor(String name, String rgb) {
		data.put(name, rgb);
	}

	@PreDestroy
	public void clearStaticData() {
		data = null;
	}

}
