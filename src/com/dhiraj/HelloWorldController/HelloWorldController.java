package com.dhiraj.HelloWorldController;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/firstPage")
public class HelloWorldController {
	
	
	
	
	@RequestMapping("/{country}/{place}")
	public ModelAndView helloWorld(@PathVariable Map<String, String> params) {
		String country =params.get("country");
		String place =params.get("place");
		 ModelAndView model = new ModelAndView("HelloWorldPage");
		 model.addObject("msg", "Hello From "+ country+ " I am from "+ place);
		return model;
		}


	@RequestMapping("/country/{place}")
	public ModelAndView next( @PathVariable("place") String place) {
		 ModelAndView model = new ModelAndView("hello");
		 model.addObject("msg", "Hello From....... "+  " I am from "+ place);
		return model;
		}
	
	@RequestMapping("/form")
	public ModelAndView form() {
		
		return new ModelAndView("form");
	}
	
	@RequestMapping("/submit")
	public ModelAndView form(@RequestParam Map<String, String > variable) {
		String name=variable.get("name");
		String address= variable.get("address");
		
		System.out.println(name + address);
		
		ModelAndView model=new ModelAndView("received");
		model.addObject("name",name);
		model.addObject("address",address);
		return model;
	}
	
	
}
