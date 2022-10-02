package main.controller;

import main.api.response.AuthResponse;
import main.api.response.InitResponse;
import main.api.response.SettingsResponse;
import main.service.AuthService;
import main.service.PostService;
import main.service.SettingsService;
import main.service.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiGeneralController {

    public InitResponse initResponse;
    public SettingsService settingsService;
    public AuthService authService;
    public PostService postService;
    public TagService tagService;

    public ApiGeneralController(InitResponse initResponse, SettingsService settingsService,
                                AuthService authService, PostService postService,
                                TagService tagService) {
        this.initResponse = initResponse;
        this.settingsService = settingsService;
        this.authService = authService;
        this.postService = postService;
        this.tagService = tagService;
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

    @GetMapping("/post")
    public PostService posts() {
        return postService;
    }

    @GetMapping("/tag")
    public TagService tags() {
        return tagService;
    }
}
