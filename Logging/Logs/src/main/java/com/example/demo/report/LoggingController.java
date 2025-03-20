package com.example.demo.report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class LoggingController {
    private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @GetMapping("/info")
    public String infoLog() {
        logger.info("INFO log: This is an informational message.");
        return "Check the logs for an INFO message!";
    }

    @GetMapping("/debug")
    public String debugLog() {
        logger.debug("DEBUG log: This is useful for debugging.");
        return "Check the logs for a DEBUG message!";
    }

    @GetMapping("/warn")
    public String warnLog() {
        logger.warn("WARN log: This is a warning message.");
        return "Check the logs for a WARNING message!";
    }

    @GetMapping("/error")
    public String errorLog() {
        logger.error("ERROR log: Something went wrong!");
        return "Check the logs for an ERROR message!";
    }

    @GetMapping("/simulate-exception")
    public String simulateException() {
        try {
            int result = 10 / 0; // This will cause an exception
        } catch (Exception e) {
            logger.error("Exception occurred: ", e);
        }
        return "Simulated exception logged!";
    }
}
