package com.example.demo;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// Comment/uncomment whichever method you want to test
			// Update ids in the below methods if needed to avoid null errors

			createUser(appDAO);
			// findUser(appDAO);
			// deleteUser(appDAO);
			// findProfilePicture(appDAO);
			// deleteProfilePicture(appDAO);

			// createUserWithPosts(appDAO);
			// findUserWithPosts(appDAO);
			// findPostsForUser(appDAO);
			// findUserWithPostsJoinFetch(appDAO);
			// updateUser(appDAO);
			// updatePost(appDAO);
			// deletePost(appDAO);
			// createPostAndComments(appDAO);
			// getPostAndReviews(appDAO);
			// deletePostAndComments(appDAO);

			// createPostAndTags(appDAO);
			// findPostAndTags(appDAO);
			// findTagAndPosts(appDAO);
			// addPostsForTag(appDAO);
			// deleteTag(appDAO);
		};
	}

	private void createUser(AppDAO appDAO) {
		User tempUser = new User("Iva", "Ivanova");
		ProfilePicture tempProfilePicture = new ProfilePicture("http://my-cool-pics.com/fwefwed");

		tempUser.setProfilePicture(tempProfilePicture);

		System.out.println("NEW USER: " + tempUser);

		// because we set CascadeType.ALL both user and profile_picture will be saved
		appDAO.save(tempUser);
	}

	private void findUser(AppDAO appDAO) {
		// update the id to existing one
		int id = 1;
		User user = appDAO.findUserById(id);

		System.out.println("USER: " + user);
		System.out.println("USER PROFILE: " + user.getProfilePicture());
	}

	private void deleteUser(AppDAO appDAO) {
		int id = 1;
		appDAO.deleteUserById(id);

		System.out.println("USER DELETED");
	}

	private void findProfilePicture(AppDAO appDAO) {
		int id = 2;

		ProfilePicture profilePicture = appDAO.findUserPictureById(id);
		System.out.println("PROFILE" + profilePicture);
		System.out.println("PROFILE USER" + profilePicture.getUser());
	}

	private void deleteProfilePicture(AppDAO appDAO) {
		int id = 3;

		appDAO.deleteProfilePictureById(id);

		System.out.println("PROFILE PICTURE DELETED");
	}

	private void createUserWithPosts(AppDAO appDAO) {
		User user = new User("Elena", "Petrova");

		ProfilePicture profilePicture = new ProfilePicture("http://my-cool-pics.com/twerwer");
		user.setProfilePicture(profilePicture);

		Post post1 = new Post("Post 1 title");
		Post post2 = new Post("Post 2 title");
		user.add(post1);
		user.add(post2);

		System.out.println("USER POSTS: " + user.getPosts());

		// because CascadeType.PERSIST the posts will be also saved
		appDAO.save(user);
	}

	private void findUserWithPosts(AppDAO appDAO) {
		int id = 4;

		User user = appDAO.findUserById(id);
		System.out.println("USER: " + user);
		System.out.println("USER POSTS: " + user.getPosts());
	}

	private void findPostsForUser(AppDAO appDAO) {
		int id = 4;

		User user = appDAO.findUserById(id);
		System.out.println("USER: " + user);

		List<Post> posts = appDAO.findPostsByUserId(id);
		// associate the objects
		user.setPosts(posts);

		System.out.println("USER POSTS: " + user.getPosts());
	}

	private void findUserWithPostsJoinFetch(AppDAO appDAO) {
		int id = 4;

		User user = appDAO.findUserByIdJoinFetch(id);
		System.out.println("USER: " + user);
		System.out.println("USER POSTS: " + user.getPosts());
	}

	private void updateUser(AppDAO appDAO) {
		int id = 4;

		User user = appDAO.findUserById(id);
		user.setLastName("Dimitrova");
		appDAO.updateUser(user);

		System.out.println("USER UPDATED");
	}

	private void updatePost(AppDAO appDAO) {
		int id = 1;

		Post post = appDAO.findPostById(id);
		post.setTitle("Updated title");
		appDAO.updatePost(post);

		System.out.println("POST UPDATED");
	}

	private void deletePost(AppDAO appDAO) {
		int id = 3;

		appDAO.deletePostById(id);

		System.out.println("POST DELETED");
	}

	private void createPostAndComments(AppDAO appDAO) {
		Post post = new Post("Post 21");
		post.addComment(new Comment("Comment 1 for post 21"));
		post.addComment(new Comment("Comment 2 for post 21"));
		post.addComment(new Comment("Comment 3 for post 21"));

		System.out.println("POST: " + post);
		System.out.println("POST COMMENTS: " + post.getComments());

		appDAO.savePost(post);
	}

	private void getPostAndReviews(AppDAO appDAO) {
		int id = 1;

		Post post = appDAO.findPostAndCommentsByPostId(id);
		System.out.println("POST: " + post);
		System.out.println("POST COMMENTS: " + post.getComments());
	}

	private void deletePostAndComments(AppDAO appDAO) {
		int id = 1;

		// because CascadeType.ALL, we will delete the post and its comments
		appDAO.deletePostById(id);

		System.out.println("POST AND COMMENTS DELETED");
	}

	private void createPostAndTags(AppDAO appDAO) {
		Post post = new Post("Latest post");

		Tag tag1 = new Tag("Tech");
		Tag tag2 = new Tag("News");

		post.addTag(tag1);
		post.addTag(tag2);

		System.out.println("POST: " + post);
		System.out.println("POST TAGS: " + post.getTags());

		appDAO.savePost(post);
	}

	private void findPostAndTags(AppDAO appDAO) {
		int id = 1;

		Post post = appDAO.findPostAndTagsByPostId(id);

		System.out.println("POST: " + post);
		System.out.println("POST TAGS: " + post.getTags());
	}

	private void findTagAndPosts(AppDAO appDAO) {
		int id = 2;

		Tag tag = appDAO.findTagAndPostsByTagId(id);

		System.out.println("TAG: " + tag);
		System.out.println("TAG POSTS: " + tag.getPosts());
	}

	private void addPostsForTag(AppDAO appDAO) {
		int id = 2;

		Tag tag = appDAO.findTagAndPostsByTagId(id);

		Post post1 = new Post("First post for a tag");
		Post post2 = new Post("Second post for a tag");

		tag.addPost(post1);
		tag.addPost(post2);

		System.out.println("TAG: " + tag);
		System.out.println("TAG POSTS: " + tag.getPosts());

		appDAO.updateTag(tag);
	}

	private void deleteTag(AppDAO appDAO) {
		int id = 1;

		appDAO.deleteTagById(id);

		System.out.println("TAG DELETED");
	}
}
