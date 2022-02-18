package it.mongo.service;

import it.mongo.model.DataTestItem;
import it.mongo.repository.ICustomMongoRepository;
import it.mongo.repository.IMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoServiceImpl implements IMongoService {

    @Autowired
    IMongoRepository mongoRepo;

    @Autowired
    ICustomMongoRepository customRepo;

    @Override
    public List<DataTestItem> showAllDataTestItems() {
        return mongoRepo.findAll();
    }

    @Override
    public boolean insertData(DataTestItem data) {
        mongoRepo.save(data);
        return true;
    }

    @Override
    public boolean deleteAll() {
        mongoRepo.deleteAll();
        return true;
    }

    @Override
    public DataTestItem getByName(String nome) {
        return mongoRepo.findItemByName(nome);
    }

    @Override
    public List<DataTestItem> getByCategoria(String categoria) {
        return mongoRepo.findAll(categoria);
    }

    @Override
    public boolean updateAnniByNome(String nome, int anni) {
        return customRepo.updateItemAnni(nome,anni);
    }


}
