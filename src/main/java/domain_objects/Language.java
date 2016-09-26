package domain_objects;

public class Language extends DomainObject {

    public Language(int id, String name) {
        super(id, name);
        // TODO Auto-generated constructor stub
    }
    
    public Language(int id)
    {
        this(id, "");
    }
    
    public Language(String name)
    {
        this(-1, name);
    }
    
    public Language()
    {
        this(-1, "");
    }
    
    public Language setId(int id)
    {
        return new Language(id, this.name);
    }
    
    public Language setName(String name)
    {
        return new Language(this.id, name);
    }
}
