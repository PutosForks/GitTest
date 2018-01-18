package com.example.mfe.service;

import com.example.mfe.domain.Template;
import com.example.mfe.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TemplateService extends JpaRepository<Template, Long> {

    Page<Template> findById(Pageable pageable);

    Template findOne(long id);


}
