package main.service;

import main.api.response.PostResponse;
import main.model.Post;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    PostResponse postResponse = new PostResponse();

    public PostResponse getPostResponse() {
        postResponse.setCount(375);
        postResponse.setPosts(postResponse.getPosts());
        postResponse.setUser(postResponse.getUser());
        postResponse.setTitle(postResponse.getTitle());
        postResponse.setAnnounce(postResponse.getAnnounce());
        postResponse.setLikeCount(postResponse.getLikeCount());
        postResponse.setDislikeCount(postResponse.getDislikeCount());
        postResponse.setCommentCount(postResponse.getCommentCount());
        postResponse.setViewCount(postResponse.getViewCount());
        return postResponse;
    }
}
