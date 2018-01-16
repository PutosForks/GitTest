package com.example.baseball.controller;

import com.example.baseball.domain.Template;
import com.example.baseball.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    TemplateService templateService;

    @RequestMapping(method = RequestMethod.GET)
    public String getTemplates(Model model, Pageable pageable) {
        Page<Template> templatePage = templateService.findAll(pageable);
        PageWrapper<Template> page = new PageWrapper<Template>(templatePage, "template/templates");
        model.addAttribute("page", page);
        model.addAttribute("templates", page.getContent());

        return "template/templates";
    }

    @GetMapping("new")
    public String newTemplate(Model model) {
        model.addAttribute("template", new Template());
        return "template/new";
    }

    @GetMapping("edit/{id}")
    public String editTemplate(Model model, @PathVariable Long id) {
        Template t = templateService.findOne(id);
        model.addAttribute("template", templateService.findOne(id));
        return "template/new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveTemplate(Model model, Pageable pageable, Template template) {
        templateService.save(template);
        PageWrapper<Template> page = new PageWrapper<Template>
                (templateService.findAll(pageable), "template/templates");
        model.addAttribute("page", page);
        return "template/templates";
    }


}
