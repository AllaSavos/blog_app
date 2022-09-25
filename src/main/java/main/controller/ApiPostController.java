package main.controller;

import main.model.Post;
import main.model.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiPostController {

    @Autowired
    private PostRepository postRepository;

    @DeleteMapping("/api/post")
    public void deleteList() {
        postRepository.deleteAll();
    }

    @PostMapping("/api/post")
    public int add(Post post) {
        Post newPost = postRepository.save(post);
        return newPost.getId();
    }

    @DeleteMapping("/api/post/{id}")
    public ResponseEntity<?> deleteId(@PathVariable int id) {
        postRepository.deleteById(id);
        if (!postRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(postRepository, HttpStatus.OK);
    }
}
