package main.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    @JsonProperty("result")
    private boolean result;
    @JsonProperty("user")
    private UserResponse userResponse;
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

