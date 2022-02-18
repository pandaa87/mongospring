package it.mongo.repository;

import it.mongo.model.DataTestItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class CustomMongoRepositoryImpl implements ICustomMongoRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public boolean updateItemAnni(String name, float anni) {
        Query query = new Query(Criteria.where("nome").is(name));
        Update update = new Update();
        update.set("anni", anni);

        return mongoTemplate.updateFirst(query, update, DataTestItem.class)==null? Boolean.FALSE : Boolean.TRUE;


    }
}
