package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostFinder {

  private List<Post> posts;

  public PostFinder(List<Post> posts) {
    if (!proofOfPosts(posts)) {
      throw new IllegalArgumentException("Some of post parameters is/are wrong!");
    }
    this.posts = posts;
  }

  public List<Post> findPostsFor(String user) {
    List<Post> result = new ArrayList<>();
    for (Post post :posts) {
      if (post.getOwner().equals(user) && post.getPublishedAt().isBefore(LocalDate.now())) {
        result.add(post);
      }
    }
    if (result.size() <= 0) {
      throw new IllegalStateException("No such post found!");
    }
    return result;
  }

  private boolean proofOfPosts(List<Post> listOfPosts) {
    for (Post post : listOfPosts) {
      if (post.getContent().isEmpty() || post.getTitle().isEmpty() ) {
        return false;
      }
    }
    return true;
  }

  public List<Post> getPosts() {
    return posts;
  }
}
