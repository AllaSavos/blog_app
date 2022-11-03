package main.api.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponseAdditional {

    private int id;

    @JsonIgnore
    private boolean active;

    private long timestamp;

    @JsonIgnoreProperties({"email", "photo", "moderation", "moderationCount", "settings"})
    private UserResponse user;

    private String title;

    @JsonIgnore
    private String text;

    private String announce;
    private int likeCount;
    private int dislikeCount;
    private int commentCount;
    private int viewCount;
}
