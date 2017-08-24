package com.dzx.app.entity;

import java.util.List;

public class Blog {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column blog.id
	 * @mbg.generated  Wed Aug 23 16:32:34 CST 2017
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column blog.author_id
	 * @mbg.generated  Wed Aug 23 16:32:34 CST 2017
	 */
	private Integer authorId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column blog.title
	 * @mbg.generated  Wed Aug 23 16:32:34 CST 2017
	 */
	private String title;
	
	private Author author;
	private List<Post> posts;

	
	
	public Blog(Integer id) {
		super();
		this.id = id;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column blog.id
	 * @return  the value of blog.id
	 * @mbg.generated  Wed Aug 23 16:32:34 CST 2017
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column blog.id
	 * @param id  the value for blog.id
	 * @mbg.generated  Wed Aug 23 16:32:34 CST 2017
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column blog.author_id
	 * @return  the value of blog.author_id
	 * @mbg.generated  Wed Aug 23 16:32:34 CST 2017
	 */
	public Integer getAuthorId() {
		return authorId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column blog.author_id
	 * @param authorId  the value for blog.author_id
	 * @mbg.generated  Wed Aug 23 16:32:34 CST 2017
	 */
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column blog.title
	 * @return  the value of blog.title
	 * @mbg.generated  Wed Aug 23 16:32:34 CST 2017
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column blog.title
	 * @param title  the value for blog.title
	 * @mbg.generated  Wed Aug 23 16:32:34 CST 2017
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}