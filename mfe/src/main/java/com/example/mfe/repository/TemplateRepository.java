package com.example.mfe.repository;

import com.example.mfe.domain.templates.Template;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long> {

    Page<Template> findById(Pageable pagable);

    Template findByShortName(String shortName);

    List<Template> findAll();

    Page<Template> findAll(Pageable pageable);


}
