package lk.ac.cmb.ucsc.euphoria.main.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.persistence.EntityManagerFactory;

@org.springframework.context.annotation.Configuration
public class HibernateUtil {
//    private static SessionFactory sessionFactory;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean
    @Primary
    public SessionFactory getSessionFactory(){
        if (entityManagerFactory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("No Session Factory found for Hibernate");
        }
        return entityManagerFactory.unwrap(SessionFactory.class);
    }
}
