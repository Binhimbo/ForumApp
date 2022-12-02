package com.vhds.restfulwebservices.forumpost;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ForumPostResource {

	private ForumPostDaoService service;

	public ForumPostResource(ForumPostDaoService service) {
		this.service = service;
	}

	@GetMapping("/forumPosts")
	public List<ForumPost> retrieveAllPosts() {
		return service.findAll();
	}

	@GetMapping("/forumPosts/{id}")
	public ForumPost retrievePost(@PathVariable int id) {
		ForumPost forumPost = service.findOne(id);

		if (forumPost == null)
			throw new PostNotFoundException("id:" + id);

		return forumPost;
	}

	@PostMapping("/forumPosts")
	public ResponseEntity<Object> createPost(@RequestBody ForumPost forumPost) {
		ForumPost savedPost = service.save(forumPost);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
