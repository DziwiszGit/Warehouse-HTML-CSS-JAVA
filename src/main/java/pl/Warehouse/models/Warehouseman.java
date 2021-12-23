package pl.Warehouse.models;

public class Warehouseman {
    private String name;
    private String surname;
    private int age;
    private Positions position;
    private boolean present;

    public Warehouseman(String name, String surname, int age, Positions position) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.position = position;
        this.present = false;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("Warehouseman{")
                .append("name = ")
                .append(this.name)
                .append(", surname = ")
                .append(this.surname)
                .append(", age = ")
                .append(this.age)
                .append(", postion = ")
                .append(this.position);
        if (this.present) {
            stringBuilder.append(", Obecny}");
        } else {
            stringBuilder.append(", Nieobecny}");
        }
        return stringBuilder.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    public boolean isPresent() {
        return present;
    }
}
