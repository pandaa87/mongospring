package it.mongo.model;

import com.mongodb.lang.Nullable;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document("DataTestItem")
@Data
@Builder
public class DataTestItem {
    @Id
    public String id;

    private String nome;
    private int anni;
    private String categoria;
    @Nullable
    private Boolean male;
}
