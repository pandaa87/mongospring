package it.mongo;

import it.mongo.model.DataTestItem;
import it.mongo.repository.IMongoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
@PropertySource(value = {
        "classpath:application.yml"
})
@Slf4j
public class MongoSpringApplication implements CommandLineRunner{

    @Autowired
    IMongoRepository mongoRepo;

//    @Autowired
//    ICustomMongoRepository customRepo;
//
//    List<DataTestItem> itemList = new ArrayList<DataTestItem>();

    public static void main(String[] args) {
        SpringApplication.run(MongoSpringApplication.class, args);
    }

   public void run(String... args) {

       // Clean up any previous data
      // mongoRepo.deleteAll(); // Doesn't delete the collection

       log.info("-------------CREATE GROCERY ITEMS-------------------------------\n");

      // createDataTestItems();
   }
//
//        System.out.println("\n----------------SHOW ALL GROCERY ITEMS---------------------------\n");
//
//        showAllDataTestItems();
//
//        System.out.println("\n--------------GET ITEM BY NAME-----------------------------------\n");
//
//        getDataTestItemByName("XYZ Kodo Millet healthy1");
//
//        System.out.println("\n-----------GET ITEMS BY CATEGORY---------------------------------\n");
//
//        getItemsByCategory("millets1");
//
//        System.out.println("\n-----------UPDATE CATEGORY NAME OF ALL GROCERY ITEMS----------------\n");
//
//        updateCategoryName("millets1");
//
//        System.out.println("\n-----------UPDATE QUANTITY OF A GROCERY ITEM------------------------\n");
//
//        updateItemQuantity("XYZ Kodo Millet healthy5", 10);
//
//        System.out.println("\n----------DELETE A GROCERY ITEM----------------------------------\n");
//
//        deleteDataTestItem("Kodo Millet4");
//
//        System.out.println("\n------------FINAL COUNT OF GROCERY ITEMS-------------------------\n");
//
//        findCountOfDataTestItems();
//
//        System.out.println("\n-------------------THANK YOU---------------------------");
//
//    }
//
//    // CRUD operations
//
    //CREATE
    void createDataTestItems() {
        log.info("Data creation started...");

        mongoRepo.save(DataTestItem.builder().id("Kodo Millet1").nome("XYZ Kodo Millet healthy1").anni(21).categoria("millets1").build());
        mongoRepo.save(DataTestItem.builder().id("Kodo Millet2").nome("XYZ Kodo Millet healthy2").anni(22).categoria("millets2").build());
        mongoRepo.save(DataTestItem.builder().id("Kodo Millet3").nome("XYZ Kodo Millet healthy3").anni(23).categoria("millets3").build());
        mongoRepo.save(DataTestItem.builder().id("Kodo Millet4").nome("XYZ Kodo Millet healthy4").anni(24).categoria("millets4").build());
        mongoRepo.save(DataTestItem.builder().id("Kodo Millet5").nome("XYZ Kodo Millet healthy5").anni(25).categoria("millets5").build());
        mongoRepo.save(DataTestItem.builder().id("id1").nome("nome1").anni(21).categoria("categoria1").build());
        mongoRepo.save(DataTestItem.builder().id("id2").nome("nome2").anni(21).categoria("categoria1").build());
        mongoRepo.save(DataTestItem.builder().id("id3").nome("nome3").anni(21).categoria("categoria2").build());

        log.info("Data creation complete...");
    }
//
//    // READ
//    // 1. Show all the data
//    public void showAllDataTestItems() {
//
//        itemList = mongoRepo.findAll();
//
//        itemList.forEach(item -> System.out.println(getItemDetails(item)));
//    }
//
//    // 2. Get item by name
//    public void getDataTestItemByName(String name) {
//        System.out.println("Getting item by name: " + name);
//        DataTestItem item = mongoRepo.findItemByName(name);
//        System.out.println(getItemDetails(item));
//    }
//
//    // 3. Get name and items of a all items of a particular category
//    public void getItemsByCategory(String category) {
//        System.out.println("Getting items for the category " + category);
//        List<DataTestItem> list = mongoRepo.findAll(category);
//
//        list.forEach(item -> System.out.println("Name: " + item.getNome() + ", Quantity: " + item.getAnni()));
//    }
//
//    // 4. Get count of documents in the collection
//    public void findCountOfDataTestItems() {
//        long count = mongoRepo.count();
//        System.out.println("Number of documents in the collection = " + count);
//    }
//
//    // UPDATE APPROACH 1: Using MongoRepository
//    public void updateCategoryName(String category) {
//
//        // Change to this new value
//        String newCategory = "munchies";
//
//        // Find all the items with the category
//        List<DataTestItem> list = mongoRepo.findAll(category);
//
//        list.forEach(item -> {
//            // Update the category in each document
//            item.setCategoria(newCategory);
//        });
//
//        // Save all the items in database
//        List<DataTestItem> itemsUpdated = mongoRepo.saveAll(list);
//
//        if(itemsUpdated != null)
//            System.out.println("Successfully updated " + itemsUpdated.size() + " items.");
//    }
//
//
//    // UPDATE APPROACH 2: Using MongoTemplate
//    public void updateItemQuantity(String name, float newQuantity) {
//        System.out.println("Updating quantity for " + name);
//        customRepo.updateItemAnni(name, newQuantity);
//    }
//
//    // DELETE
//    public void deleteDataTestItem(String id) {
//        mongoRepo.deleteById(id);
//        System.out.println("Item with id " + id + " deleted...");
//    }
//    // Print details in readable form
//
//    public String getItemDetails(DataTestItem item) {
//
//        System.out.println(
//                "Item Name: " + item.getNome() +
//                        ", \nItem Quantity: " + item.getAnni() +
//                        ", \nItem Category: " + item.getCategoria()
//        );
//
//        return "";
//    }
    
}
