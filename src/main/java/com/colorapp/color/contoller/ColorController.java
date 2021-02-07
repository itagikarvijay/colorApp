package com.colorapp.color.contoller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colorapp.color.service.IColor;

@RestController
@RequestMapping("/api/v1")
public class ColorController {

	@Autowired
	IColor color;
	
	@GetMapping("/colors")
	public ResponseEntity<?> getColors(){
		Optional<Map<String,String>> optData = Optional.of(color.getColor());
		if(optData.get().values().size() > 0 ) {
			return new ResponseEntity<>(color.getColor(),HttpStatus.OK);	
		}else {
			return new ResponseEntity<>("No Color list found.!",HttpStatus.OK);	
		}
	}
	
	@PostMapping("/color/{name}/{rgb}")
	public ResponseEntity<String> saveColor(@PathVariable String name, @PathVariable String rgb){
	
		if(color.add(name, rgb)){
			return new ResponseEntity<>("Color saved.!",HttpStatus.OK);	
		}else {
			return new ResponseEntity<>("Color could not save.!",HttpStatus.OK);
		}
	}
	
}
