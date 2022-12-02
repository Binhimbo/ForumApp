package com.vhds.restfulwebservices.forumpost;

public class ForumPost {
	private int id;
	private String title;
	private String threadCategory;
	private String postCategory;
	private boolean isPrivate;
	private String content;

	public ForumPost(int id, String title, String threadCategory, String postCategory, boolean isPrivate,
			String content) {
		super();
		this.id = id;
		this.title = title;
		this.threadCategory = threadCategory;
		this.postCategory = postCategory;
		this.isPrivate = isPrivate;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThreadCategory() {
		return threadCategory;
	}

	public void setThreadCategory(String threadCategory) {
		this.threadCategory = threadCategory;
	}

	public String getPostCategory() {
		return postCategory;
	}

	public void setPostCategory(String postCategory) {
		this.postCategory = postCategory;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ForumPost [id=" + id + ", title=" + title + ", threadCategory=" + threadCategory + ", postCategory="
				+ postCategory + ", isPrivate=" + isPrivate + ", content=" + content + "]";
	}

}
