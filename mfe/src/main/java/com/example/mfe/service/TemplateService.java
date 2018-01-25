package com.example.mfe.service;

import com.example.mfe.component.Messages;
import com.example.mfe.domain.templates.Template;
import com.example.mfe.domain.templates.TemplateStatus;
import com.example.mfe.domain.templates.TemplateVer;
import com.example.mfe.domain.templates.TemplateVerStatus;
import com.example.mfe.enumeration.EnvironmentEnum;
import com.example.mfe.enumeration.MfeStatusEnum;
import com.example.mfe.repository.TemplateRepository;
import com.example.mfe.repository.TemplateStatusRepository;
import com.example.mfe.repository.TemplateVerRepository;
import com.example.mfe.repository.TemplateVerStatusRepository;
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
    TemplateVerRepository templateVerRepository;

    @Autowired
    TemplateStatusRepository templateStatusRepository;


    @Autowired
    TemplateVerStatusRepository templateVerStatusRepository;

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
        if (template.getId() == null && template.getDefaultTemplate()) {
            throw new TemplateExceptionClass(messages.get("template.defaultTemplate.unique"));
        }

        TemplateVer templateVer;
        TemplateStatus templateStatus;


        if (template.getId() == null) {
            templateRepository.save(template);

            // nastaven template statusu
            templateStatus = new TemplateStatus();
            templateStatus.setMfeStatus(MfeStatusEnum.EDITED);
            templateStatus.setEnvironment(EnvironmentEnum.MFE);
            templateStatusRepository.save(templateStatus);

            template.setTemplateStatus(templateStatus);


            // provazani s verzi
            templateVer = new TemplateVer();
            templateVer.setIdTemplate(template.getId());
            templateVerRepository.save(templateVer);
            template.setIdCurrentVer(templateVer);

            //zakladni stav verze
            TemplateVerStatus templateVerStatus = new TemplateVerStatus();
            templateVerStatus.setEnviroment(EnvironmentEnum.MFE);
            templateVerStatus.setStatus(MfeStatusEnum.EDITED);
            templateVerStatus.setId(templateVer.getIdTemplateVer());
            templateVerStatusRepository.save(templateVerStatus);
            //templateVer.setTemplateVerStatus();
            templateVerRepository.save(templateVer);




            templateRepository.save(template);
        } else {
            templateVer = templateRepository.getOne(template.getId()).getIdCurrentVer();
            templateStatus = templateRepository.getOne(template.getId()).getTemplateStatus();
            template.setIdCurrentVer(templateVer);
            template.setTemplateStatus(templateStatus);
            templateRepository.save(template);
        }
    }

    public void delete(Long id) {
        templateRepository.delete(id);
    }

}