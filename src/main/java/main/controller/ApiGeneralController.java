package main.controller;

import main.api.response.*;
import main.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiGeneralController {

    public InitResponse initResponse;
    public SettingsService settingsService;
    public AuthService authService;

    public TagService tagService;

    public CalendarService calendarService;

    public ApiGeneralController(InitResponse initResponse, SettingsService settingsService,
                                AuthService authService, TagService tagService, CalendarService calendarService) {
        this.initResponse = initResponse;
        this.settingsService = settingsService;
        this.authService = authService;
        this.tagService = tagService;
        this.calendarService = calendarService;
    }

    @GetMapping("/settings")
    public SettingsResponse settings() {
        return settingsService.getGlobalSettings();
    }

    @GetMapping("/init")
    public InitResponse init() {
        return initResponse;
    }

    @GetMapping("/auth/check")
    public AuthResponse auth() {
        return authService.getAuthResponse();
    }


    @GetMapping("/tag")
    public TagResponse tags() {
        return tagService.getTagResponse();
    }

    @GetMapping("/calendar")
    public CalendarResponse calendar() {
        return calendarService.getCalendarResponse();
    }
}
