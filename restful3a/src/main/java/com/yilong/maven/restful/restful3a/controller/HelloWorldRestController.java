package com.yilong.maven.restful.restful3a.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yilong.maven.restful.restful3a.domain.Message;

@RestController
public class HelloWorldRestController {
	
	@RequestMapping("/")   //this is the "welcome page". It is not restful
	public String welcome()
	{
		return "welcome to restful3a demo";
	}
	//this is restful URI
	@RequestMapping(value="/hello/{player}", produces = {"Application/json"}) // MediaType.APPLICATION_JSON} ==>MediaType.Application_JSON is not a constant
	//if specifing Produce (json here), we can still add .json in the URI. But, if adding .xml, not working anymore
	//@Get
	//@Produces("Application/json") //with @RestController, "Produces" should be included inside the @RequestMapping
	//@ResponseBody  //===>@RestController is a convenience annotation that means you no longer need to specify @ResponseBody annotation on your methods.
	public Message message(@PathVariable String player)
	{
		return new Message(player, "Hello ppp" + player);
	}

}

/*When you annotate a method/a controller with @ResponseBody, Spring assists you with content negotiation, using the Accept HTTP request header and the produces attribute on your annotation.
 */
