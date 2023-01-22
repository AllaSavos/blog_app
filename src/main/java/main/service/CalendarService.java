package main.service;

import main.api.response.CalendarResponse;
import main.model.Post;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.Year;
import java.util.Collections;

@Service
public class CalendarService {
    CalendarResponse calendarResponse = new CalendarResponse();

    public CalendarResponse getCalendarResponse() {
        calendarResponse.setYears(Collections.singletonList("1111"));
        calendarResponse.setPosts(new Post().getAuthor().getPosts());
        return calendarResponse;
    }
}
