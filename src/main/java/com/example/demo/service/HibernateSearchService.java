package com.example.demo.service;

import com.example.demo.model.Player;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.lucene.search.Query;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class HibernateSearchService {
    private final EntityManager entityManager;
    @Autowired
    public HibernateSearchService(final EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }
    @PostConstruct
    public void initializeHibernateSearch() {
        try{
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            fullTextEntityManager.createIndexer().startAndWait();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public List searchPlayerByName(String match){
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(this.entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Player.class)
                .get();
        //Basic query example
        /*Query query = queryBuilder
                .keyword()
                .onField("name")
                .matching(match)
                .createQuery();
        */

        //Fuzzy Query

        /*Query query = queryBuilder
                .keyword()
                .fuzzy()
                .withEditDistanceUpTo(2)
                .withPrefixLength(0)
                .onField("name")
                .matching(match)
                .createQuery();
        */
        //WildcardQuery
        /*Query query = queryBuilder
                .keyword()
                .wildcard()
                .onField("name")
                .matching(match+"*")
                .createQuery();
        */

        Query query = queryBuilder
                .keyword()
                .wildcard()
                .onFields("name", "username")
                .matching(match+"*")
                .createQuery();

        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, Player.class);

        return jpaQuery.getResultList();

    }


}
