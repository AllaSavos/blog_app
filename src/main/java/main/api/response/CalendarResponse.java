package main.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import main.model.Post;

import java.util.List;
import java.util.Map;


@Getter
@Setter

public class CalendarResponse {

    @JsonProperty("years")
    private List<String> years;

    @JsonProperty("posts")
    private List<Post> posts;




}
