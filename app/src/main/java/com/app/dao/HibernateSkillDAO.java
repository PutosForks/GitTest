package com.app.dao;

import com.app.daoUtils.HibernateDAO;
import com.app.model.Skill;

public class HibernateSkillDAO extends HibernateDAO<Skill, Long>
        implements SkillDAO {

    public HibernateSkillDAO() {
        super(Skill.class);
    }

}
