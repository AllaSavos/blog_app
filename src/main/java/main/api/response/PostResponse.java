package main.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import main.model.Post;
import main.model.User;

@Setter
@Getter
public class PostResponse {
    @JsonProperty("count")
    private int count;
    @JsonProperty("posts")
    private Post posts;
    @JsonProperty("user")
    private User user;
    @JsonProperty("title")
    private String title;
    @JsonProperty("announce")
    private String announce;
    @JsonProperty("likeCount")
    private int likeCount;
    @JsonProperty("dislikeCount")
    private int dislikeCount;
    @JsonProperty("commentCount")
    private int commentCount;
    @JsonProperty("viewCount")
    private int viewCount;

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

