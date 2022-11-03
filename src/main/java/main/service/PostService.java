package main.service;

import main.api.response.PostResponse;
import main.api.response.PostResponseAdditional;
import main.api.response.UserResponse;
import main.model.Post;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    PostResponse postResponse = new PostResponse();
    PostResponseAdditional postResponseAdditional = new PostResponseAdditional();

    public PostResponse getPostResponse() {
        postResponse.setCount(375);
        postResponseAdditional.setDislikeCount(877);
        postResponseAdditional.setUser(new UserResponse());

        return postResponse;
    }
}
