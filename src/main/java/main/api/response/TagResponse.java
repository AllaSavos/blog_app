package main.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagResponse {
    @JsonProperty("name")
    private String name;
    @JsonProperty("weight")
    private double weight;
}
