package com.example.mfe.controller;

import com.example.mfe.component.Messages;
import com.example.mfe.domain.templates.Template;
import com.example.mfe.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    TemplateService templateService;

    @Autowired
    Messages messages;

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
    public String saveTemplate(@Valid @ModelAttribute Template template, BindingResult bindingResult) {
        if (templateService.shortNameExists(template)) {
            bindingResult.rejectValue("shortName", "shortName", messages.get("template.shortName.exists"));
        }
        if (bindingResult.hasErrors()) return "template/new";
        templateService.save(template);
        return "redirect:template";
    }


}
