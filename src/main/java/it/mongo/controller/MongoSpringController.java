package it.mongo.controller;

import io.swagger.annotations.Api;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import it.mongo.model.DataTestItem;
import it.mongo.service.IMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongo")
@Api(value = "Mongo Spring Catalog API", tags = "mongoSpringCatalog")
public class MongoSpringController {

    @Autowired
    IMongoService service;

    @CrossOrigin(origins = "*")
    @GetMapping("/showAllDataTestItems")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "allData", response = List.class)})
    public List<DataTestItem> showAllDataTestItems() {
        return service.showAllDataTestItems();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/insertData")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "insert Data", response = boolean.class)})
    public boolean insertData(@RequestBody DataTestItem data) {
        return service.insertData(data);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteAll")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "delete All Data", response = boolean.class)})
    public boolean deleteAll() {
        return service.deleteAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getByName")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "getByName", response = DataTestItem.class)})
    public DataTestItem getByName(String nome) {
        return service.getByName(nome);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getByCategoria")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "getByCategoria", response = List.class)})
    public List<DataTestItem> getByCategoria(String categoria) {
        return service.getByCategoria(categoria);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/updateAnniByNome")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "updateAnniByNome", response = boolean.class)})
    public boolean updateAnniByNome(@RequestParam String nome, @RequestParam int anni) {
        return service.updateAnniByNome(nome,anni);
    }

}
