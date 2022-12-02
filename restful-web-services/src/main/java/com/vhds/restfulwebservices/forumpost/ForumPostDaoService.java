package com.vhds.restfulwebservices.forumpost;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class ForumPostDaoService {

	private static List<ForumPost> posts = new ArrayList<>();

	private static int postsCount = 0;
	static {
		posts.add(new ForumPost(++postsCount, "deserunt dolore consequat", "Work", "clarification", true,
				"Quis pariatur esse laborum est velit velit cillum non velit. Aute dolor esse voluptate cillum amet ut."));
		posts.add(new ForumPost(++postsCount, "proident qui dolor", "Pets", "doubt", false,
				"Aute officia aute aute excepteur laboris voluptate ut officia. Consectetur ad fugiat qui adipisicing et amet consectetur ad veniam ea deserunt consectetur ut dolore."));
		posts.add(new ForumPost(++postsCount, "mollit consequat ut", "Hobbies", "suggestion", true,
				"In irure magna minim in velit ex excepteur. Pariatur officia sunt labore commodo id reprehenderit duis Lorem non ea exercitation sit mollit aliquip."));
		posts.add(new ForumPost(++postsCount, "Lorem proident tempor", "Work", "doubt", true,
				"Veniam ullamco incididunt sunt velit dolore nostrud velit ullamco cupidatat voluptate id labore cillum sit. Aute dolore aliquip enim laborum ex."));
		posts.add(new ForumPost(++postsCount, "minim labore excepteur", "Work", "doubt", true,
				"Occaecat velit et cillum minim cillum quis aliquip Lorem enim deserunt. Veniam labore velit consectetur anim do minim fugiat ex."));
	}

	public List<ForumPost> findAll() {
		return posts;
	}

	public ForumPost findOne(int id) {
		Predicate<? super ForumPost> predicate = post -> post.getId() == id;
		return posts.stream().filter(predicate).findFirst().orElse(null);
	}

	public ForumPost save(ForumPost forumPost) {
		forumPost.setId(++postsCount);
		posts.add(forumPost);
		return forumPost;
	}
}
