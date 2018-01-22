package com.example.mfe.repository;

import com.example.mfe.domain.templates.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TemplateRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    TemplateRepository templateRepository;

    @Test
    public void whenFindByShortName_thenReturnEmployee() {

        String shortName = "templtexxx";

        Template t = new Template();
        t.setName("templtexxx");
        t.setShortName(shortName);
        t.setDefaultTemplate(0);
        t.setDescription("0");
        t.setValid(0);
        entityManager.persist(t);
        entityManager.flush();

        // when
        Template found = templateRepository.findByShortName(t.getShortName());

        // then
        assertThat(found.getShortName()).isEqualTo(t.getName());


    }

}



