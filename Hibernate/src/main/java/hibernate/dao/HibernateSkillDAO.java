package hibernate.dao;

import hibernate.daoUtils.HibernateDAO;
import hibernate.model.Skill;

public class HibernateSkillDAO extends HibernateDAO<Skill, Long>
        implements SkillDAO {

    public HibernateSkillDAO() {
        super(Skill.class);
    }

}
