package com.colorapp.color.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colorapp.color.data.ColorData;

@Service
public class ColorServiceImpl implements IColor {
	
	@Autowired
	ColorData colorData;
	
	@Override
	public Map<String, String> getColor() {
		return colorData.getData();
	}

	@Override
	public boolean add(String color, String rgb) {
		colorData.saveColor(color, rgb);
		return true;
	}

}
