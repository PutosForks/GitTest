package com.example.mfe.controller;

import com.example.mfe.domain.Template;
import com.example.mfe.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    TemplateService templateService;

    @RequestMapping(method = RequestMethod.GET)
    public String getTemplates(Model model, Pageable pageable) {
        Page<Template> templatePage = templateService.findAll(pageable);
        PageWrapper<Template> page = new PageWrapper<>(templatePage, "template");
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

    @DeleteMapping("{id}")
    public String deleteTemplate(@PathVariable Long id) {
        templateService.delete(id);
        return "redirect:/template";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveTemplate(Template template) {
        templateService.save(template);
        return "redirect:template";
    }


}
