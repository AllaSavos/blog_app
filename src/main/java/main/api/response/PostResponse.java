package main.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import main.model.Post;
import main.model.User;

import java.util.List;

@Setter
@Getter
public class PostResponse {
    @JsonProperty("count")
    private int count;
    @JsonProperty("posts")
    private List<PostResponseAdditional> posts;



}
/*{
        "count": 390,
        "posts": [
        {
        "id": 345,
        "timestamp": 1592338706,
        "user":
        {
        "id": 88,
        "name": "Дмитрий Петров"
        },
        "title": "Заголовок поста",
        "announce": "Текст анонса поста без HTML-тэгов",
        "likeCount": 36,
        "dislikeCount": 3,
        "commentCount": 15,
        "viewCount": 55
        },
        {...}
        ]
        }*/

