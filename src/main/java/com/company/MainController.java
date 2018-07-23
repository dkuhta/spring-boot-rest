package com.company;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

    private static final Map<String, String> VERSION;

    static {
        VERSION = new HashMap<>();
        VERSION.put("version", "1.0");
    }

    @Value("${version}")
    private String version;

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public Map<String, String> version() {
        return VERSION;
    }

    @RequestMapping(value = "/transactiontypes", method = RequestMethod.GET)
    public Object getSupportedTransactionTypes() {
        return null;
    }

    @RequestMapping(value = "/execute", method = RequestMethod.POST)
    public Object greeting(@RequestBody Object ipRequest) {
        return null;
    }
}
