package pl.Warehouse.models;

import java.io.Serializable;
import java.util.Locale;

public class Product  {
    private String name;
    private float weight;

    public Product(String name, float weight) {
        this.name = name.toUpperCase();
        this.weight = weight;
    }

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
