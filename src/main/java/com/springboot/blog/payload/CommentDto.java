package com.springboot.blog.payload;

import com.springboot.blog.entity.Post;

public class CommentDto {
	private long id;
	private String name;
	private String email;
	private String body;
	private Post post;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public CommentDto(long id, String name, String email, String body, Post post) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.body = body;
		this.post = post;
	}
	public CommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
