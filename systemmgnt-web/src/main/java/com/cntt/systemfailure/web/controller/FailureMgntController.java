package com.cntt.systemfailure.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( value = "/failuremgnt/" )
public class FailureMgntController {

    @RequestMapping( value = "myfailuremgnt" )
    public String my() {
        return "failuremgnt/myfailuremgnt";
    }
}
