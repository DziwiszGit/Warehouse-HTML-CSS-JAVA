package pl.Warehouse.exceptions;

public class AuthValidationException extends RuntimeException{
    private String info;
    public AuthValidationException(String info){
        this.info=info;
    }
    public String getInfo(){return info;}

}
