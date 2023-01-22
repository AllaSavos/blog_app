package main.controller;


import main.api.response.PostResponse;
import main.model.repositories.PostRepository;
import main.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;




@Controller
@RequestMapping("/api")
public class ApiPostController {


    private PostRepository postRepository;


    public final PostService postService;

    public ApiPostController(PostService postService) {
        this.postService = postService;
    }

    public PostResponse posts(){
        return postService.getPostResponse();
    }


   /* @GetMapping("/post")
    public PostService posts() {
        return (PostService) postService.getVisiblePosts(0, 10, mode); }*/


    /*@GetMapping(value = "/post",  params = {"offset", "limit", "mode"})
    public ResponseEntity<?> posts(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                   @RequestParam(value = "limit", defaultValue = "10") int limit,
                                   @RequestParam(value = "mode") String mode) {
        return new ResponseEntity<>(postService.getVisiblePosts(offset, limit, mode), HttpStatus.OK);
    }
    @GetMapping(value = "/api/post", params = {"offset", "limit", "mode"})
    public ResponseEntity<?> get(@RequestParam(value = "offset") int offset,
                                           @RequestParam(value = "limit") int limit,
                                           @RequestParam(value = "mode") String mode) {
        return postService.getPostResponse(offset, limit, mode);
    }*/


}
