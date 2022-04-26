package Security2.Security2.model;

import java.io.Serializable;

public class Authentification implements Serializable {
    private final String string;

    public Authentification(String string){
        this.string=string;
    }

    public String getString(){
        return string;
    }
}
