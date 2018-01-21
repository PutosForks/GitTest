package com.example.mfe.service;

import com.example.mfe.component.Messages;
import com.example.mfe.domain.templates.Template;
import com.example.mfe.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
public class TemplateService {


    @Autowired
    TemplateRepository templateRepository;

    @Autowired
    Messages messages;


    public Page<Template> findById(Pageable pageable) {
        return templateRepository.findById(pageable);
    }

    public Template findOne(long id) {
        return templateRepository.findOne(id);
    }


    public Template findByShortName(String shortName) {
        return templateRepository.findByShortName(shortName);
    }

    public List<Template> findAll() {
        return templateRepository.findAll();
    }

    public Page<Template> findAll(Pageable pageable) {
        return templateRepository.findAll(pageable);
    }

    public boolean shortNameExists(Template template) {
        if (template.getId() == null && templateRepository.findByShortName(template.getShortName()) != null) {
            return true;
        }
        return false;
    }

    @ExceptionHandler(TemplateExceptionClass.class)
    public void save(Template template) {
        Template template1 = templateRepository.findOne(template.getId());
        if (template1.getDefaultTemplate() == "1" && template.getDefaultTemplate() == "0") {
            throw new TemplateExceptionClass(messages.get("template.defaultTemplate.unique"));
        }

        templateRepository.save(template);
    }

    public void delete(Long id) {
        templateRepository.delete(id);
    }

}