package com.example.demo.config;

import com.example.demo.service.HibernateSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Configuration
public class HibernateSearchConfig {
    private final EntityManagerFactory entityManager;

    @Autowired
    public HibernateSearchConfig(EntityManagerFactory entityManager){
        this.entityManager = entityManager;

    }

    @Bean
    HibernateSearchService hibernateSearchInit(){
        HibernateSearchService hibernateSearchService = new HibernateSearchService(this.entityManager);
        hibernateSearchService.initializeHibernateSearch();
        return hibernateSearchService;
    }

}
