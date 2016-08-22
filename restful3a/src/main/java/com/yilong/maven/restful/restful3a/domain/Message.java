package com.yilong.maven.restful.restful3a.domain;

//POJO/domain object to stand for the resource
//no any annotation!!!
public class Message {
	String name;
	String text;

	public Message(String name, String text)
	{
		this.name = name;
		this.text = text;
	}


	public String getName() {
		return name;
	}
	//use constructor, not using setter
	/*public void setName(String name) {
		this.name = name;
	}*/
	public String getText() {
		return text;
	}
	/*public void setText(String text) {
		this.text = text;
	}*/


}
