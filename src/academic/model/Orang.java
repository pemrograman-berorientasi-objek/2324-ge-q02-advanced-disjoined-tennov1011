package academic.model;

public class Orang {
    
    private String id;
    private String name;

    public  Orang(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
}
