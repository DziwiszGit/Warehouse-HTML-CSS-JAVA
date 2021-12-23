package pl.Warehouse.models;

public enum Positions {
    DRIVER ("DRIVER"),
    HELPER ("HELPER"),
    MANAGER ("MANAGER"),
    PACKER("PACKER");
    String positon;
    Positions(String postion) {
        this.positon=postion;
    }
}
