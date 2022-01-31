package pl.Warehouse.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Locale;

@Entity(name="tproduct")
public class Product  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float weight;


    public Product(String name, float weight) {
        this.name = name.toUpperCase();
        this.weight = weight;
    }

    public Product() {}

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("Products{")
                .append("name = ")
                .append(this.name)
                .append(", weight = ")
                .append(this.weight + "}");
        return stringBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
