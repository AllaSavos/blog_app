package main.controller;

import main.model.repositories.PostRepository;
import main.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/api")
public class ApiPostController {

    //@Autowired
    //private PostRepository postRepository;

    /*public PostService postService;

    public ApiPostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public PostService posts() {
        return postService.getPostResponse();
    }*/

}
