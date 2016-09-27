package domain_objects;

public class Server extends DomainObject{



    public Server(int id, String name) {
        super(id, name);
        // TODO Auto-generated constructor stub
    }

    public Server(int id)
    {
        this(id, "");
    }
    
    public Server(String name)
    {
        this(-1, name);
    }
    
    public Server()
    {
        this(-1, "");
    }
    
    public Server setId(int id)
    {
        return new Server(id, this.name);
    }
    
    public Server setName(String name)
    {
        return new Server(this.id, name);
    }
    
    @Override
    public String toString() {
        return name;
    }
}
