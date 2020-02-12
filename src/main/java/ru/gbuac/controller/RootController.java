package ru.gbuac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/")
    public String root() {
        return "redirect:login";
    }

    @GetMapping(value = "/admin/quests")
    public String quests() {
        return "admin/quests";
    }

    @GetMapping(value = "/admin/quest")
    public String edit() {
        return "admin/quest";
    }

    @GetMapping(value = "/my-quests")
    public String myQuests() {
        return "my-quests";
    }

    @GetMapping(value = "/my-quest")
    public String myQuest() {
        return "my-quest";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/new-document")
    public String newDocument() {
        return "new-document";
    }

    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/template")
    public String template() {
        return "template";
    }

    @GetMapping(value = "/agree-document")
    public String agreeDocument() { return "agree-document"; }

    @GetMapping(value = "/agree-template")
    public String agreeTemplate() { return "agree-template"; }

    @GetMapping(value = "/temp-list")
    public String tempList() { return "temp-list"; }

    @GetMapping(value = "/all")
    public String all() { return "all"; }

    @GetMapping(value = "/in-work")
    public String inWork() { return "in-work"; }

    @GetMapping(value = "/agreement")
    public String agreement() { return "agreement"; }

    @GetMapping(value = "/agreed")
    public String agreed() { return "agreed"; }

    @GetMapping(value = "/registered")
    public String registered() { return "registered"; }

    @GetMapping(value = "/distribution")
    public String distribution() { return "distribution"; }

    @GetMapping(value = "/distributed")
    public String distributed() { return "distributed"; }
}
