package main.service;

import main.api.response.TagResponse;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    TagResponse tagResponse = new TagResponse();

    public TagResponse getTagResponse() {
        tagResponse.setName("Java");
        tagResponse.setWeight(1.0);
        tagResponse.setName("Spring");
        tagResponse.setWeight(0.36);
        return tagResponse;
    }
}
