package lv.test.app.dao;

import lv.test.app.validator.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Offer {

	private int id;

	@Size(max = 100, min = 5, message = "Name size is not valid")
	private String name;

	@NotNull
	//@Pattern(regexp = ".*\\@.*\\..*", message = "Email address is not valid")
	@ValidEmail(min = 6, message = "Not valid")
	private String email;

	@Size(max = 255, min = 10, message = "Text size is not valid")
	private String text;

	public Offer() {

	}

	public Offer(String name, String email, String text) {
		this.name = name;
		this.email = email;
		this.text = text;
	}



	public Offer(int id, String name, String email, String text) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email
				+ ", text=" + text + "]";
	}

}
