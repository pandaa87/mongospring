package it.mongo.service;

import com.mongodb.client.result.UpdateResult;
import it.mongo.model.DataTestItem;

import java.util.List;

public interface IMongoService {

    List<DataTestItem> showAllDataTestItems();

    DataTestItem insertData(DataTestItem data);

    void deleteAll();

    DataTestItem getByName(String nome);

    List<DataTestItem> getByCategoria(String categoria);

    UpdateResult updateAnniByNome(String nome, int anni);

    String generateRandomDocument();
}
