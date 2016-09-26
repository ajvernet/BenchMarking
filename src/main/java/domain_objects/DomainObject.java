package domain_objects;

public abstract class DomainObject {

    final int id;
    final String name;
    
    public DomainObject(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    
    
    
    
}
