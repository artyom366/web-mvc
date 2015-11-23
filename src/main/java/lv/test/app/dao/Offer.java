package lv.test.app.dao;

import lv.test.app.validator.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Offer {

	private int id;

	@Size(max = 255, min = 10, message = "Text size is not valid")
	private String text;

	private User user;

	public Offer() {
        this.user = new User();
	}

	public Offer(int id, String text, User user) {
		this.id = id;
		this.text = text;
		this.user = user;
	}

    public String getUserName() {
        return user.getUserName();
    }

    public void setUserName(String userName) {
        this.user.setUserName(userName);
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
