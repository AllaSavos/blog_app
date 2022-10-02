package main.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("photo")
    private String photo;
    @JsonProperty("email")
    private String email;
    @JsonProperty("moderation")
    private boolean moderation;
    @JsonProperty("moderationCount")
    private int moderationCount;
    @JsonProperty("settings")
    private boolean settings;
}
/*  {   "result": true,
        "user": {
        "id": 576,
        "name": "Дмитрий Петров",
        "photo": "/avatars/ab/cd/ef/52461.jpg",
        "email": "petrov@petroff.ru",
        "moderation": true,
        "moderationCount": 56,
        "settings": true
        }}*/