package com.colorapp.color.service;

import java.util.Map;

public interface IColor {
	
	Map<String,String> getColor();
	boolean add(String color, String rgb);

}
