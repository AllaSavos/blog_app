package main.service;

import lombok.extern.slf4j.Slf4j;
import main.api.response.*;
import main.model.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PostService {
    PostResponse postResponse = new PostResponse();
    PostResponseAdditional postResponseAdditional = new PostResponseAdditional();

    private PostRepository postRepository;

   /* public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }*/
    public PostResponse getPostResponse() {
        postResponse.setCount(375);
        postResponseAdditional.setDislikeCount(877);
        postResponseAdditional.setUser(new UserResponse());

        return postResponse;
    }
    /*public List<Post> getVisiblePosts(int offset, int limit, String mode) {
        return postRepository.getVisiblePosts(offset, limit, mode);
    }*/


}



   /* */



