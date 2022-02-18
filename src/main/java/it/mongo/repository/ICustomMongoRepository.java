package it.mongo.repository;

import com.mongodb.client.result.UpdateResult;

public interface ICustomMongoRepository {
    UpdateResult updateItemAnni(String itemName, float anni);
}
