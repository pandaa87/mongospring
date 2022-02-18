package it.mongo.repository;

import it.mongo.model.DataTestItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IMongoRepository extends MongoRepository<DataTestItem, String> {

    @Query("{nome:'?0'}")
    DataTestItem findItemByName(String name);

    @Query(value="{categoria:'?0'}", fields="{'nome' : 1, 'anni' : 1, 'categoria' : 1}")
    List<DataTestItem> findAll(String category);

    public long count();
}
