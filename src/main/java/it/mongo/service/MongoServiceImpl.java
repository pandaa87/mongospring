package it.mongo.service;

import com.mongodb.client.result.UpdateResult;
import it.mongo.model.DataTestItem;
import it.mongo.repository.ICustomMongoRepository;
import it.mongo.repository.IMongoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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
    public DataTestItem insertData(DataTestItem data) {
        return mongoRepo.save(data);
    }

    @Override
    public void deleteAll() {
        mongoRepo.deleteAll();
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
    public UpdateResult updateAnniByNome(String nome, int anni) {
        return customRepo.updateItemAnni(nome,anni);
    }

    @Override
    public String generateRandomDocument() {
        log.info("Data creation started...");
        mongoRepo.save(DataTestItem.builder().id("id1").nome("nome1").anni(21).categoria("categoria1").build());
        mongoRepo.save(DataTestItem.builder().id("id2").nome("nome2").anni(15).categoria("categoria1").build());
        mongoRepo.save(DataTestItem.builder().id("id3").nome("nome3").anni(34).categoria("categoria2").build());
        mongoRepo.save(DataTestItem.builder().id("id4").nome("nome4").anni(21).categoria("categoria2").build());
        mongoRepo.save(DataTestItem.builder().id("id5").nome("nome5").anni(22).categoria("categoria2").build());
        mongoRepo.save(DataTestItem.builder().id("id6").nome("nome6").anni(23).categoria("categoria2").build());
        mongoRepo.save(DataTestItem.builder().id("id7").nome("nome7").anni(24).categoria("categoria2").build());
        mongoRepo.save(DataTestItem.builder().id("id8").nome("nome8").anni(25).categoria("categoria2").build());
        log.info("Data creation complete...");
        return "Creation complete";
    }


}
