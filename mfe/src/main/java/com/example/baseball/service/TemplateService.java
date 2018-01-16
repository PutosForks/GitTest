package com.example.baseball.service;

import com.example.baseball.domain.Template;
import com.example.baseball.repository.TemplateRepository;
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
