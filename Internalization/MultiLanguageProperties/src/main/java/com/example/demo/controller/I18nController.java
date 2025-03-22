package com.example.demo.controller;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class I18nController {
    private final MessageSource messageSource;

    public I18nController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // Example 1: Detect language from Accept-Language header
    @GetMapping("/greet")
    public String greet(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("greeting", null, locale);
    }

    // Example 2: Manually pass language via URL (e.g., /farewell?lang=fr)
    @GetMapping("/farewell")
    public String farewell(@RequestParam(name = "lang", defaultValue = "en") String lang) {
        Locale locale = Locale.forLanguageTag(lang);
        return messageSource.getMessage("farewell", null, locale);
    }
}
