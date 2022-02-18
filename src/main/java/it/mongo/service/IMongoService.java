package it.mongo.service;

import it.mongo.model.DataTestItem;

import java.util.List;

public interface IMongoService {

    List<DataTestItem> showAllDataTestItems();

    boolean insertData(DataTestItem data);

    boolean deleteAll();

    DataTestItem getByName(String nome);

    List<DataTestItem> getByCategoria(String categoria);

    boolean updateAnniByNome(String nome, int anni);
}
