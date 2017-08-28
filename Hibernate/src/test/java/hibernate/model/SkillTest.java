package hibernate.model;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

import static hibernate.util.HibernateUtil.getSession;
import static org.junit.Assert.assertTrue;

public class SkillTest {


    @Test
    public void skillTest() {
        Session session = getSession();

        try {
            session.beginTransaction();

            Skill skill = new Skill();
            skill.setName("Python");

            session.saveOrUpdate(skill);

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        }


        try {
            session = getSession();

            session.beginTransaction();

            List skills = session.createCriteria(Skill.class)
                    .add(Restrictions.like("name", "P%"))
                    .list();

            assertTrue("Has ore then one skill", skills.size() >= 0);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        }


    }
}
