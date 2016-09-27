package domain_objects;

public class Framework extends DomainObject{
    
    
    final Language language;
    final Server server;


    final int rps_8, rps_16, rps_32, rps_64, rps_128, rps_256;
    
    final int errors;
    
    
    public Framework()
    {
     
        this(0, "", new Language(), new Server(), 0, 0, 0, 0, 0, 0, 0);
    }
    
    public Framework(String name, Language language, Server server, int rps_8, int rps_16, int rps_32,
            int rps_64, int rps_128, int rps_256, int errors)
    {
        
        this(0, name, language, server, rps_8, rps_16, rps_32, rps_64, rps_128, rps_256, errors);
    }
    
    public Framework(int id, String name, Language language, Server server, int rps_8, int rps_16, int rps_32,
            int rps_64, int rps_128, int rps_256, int errors) {
        super(id, name);
        this.language = language;
        this.server = server;
        this.rps_8 = rps_8;
        this.rps_16 = rps_16;
        this.rps_32 = rps_32;
        this.rps_64 = rps_64;
        this.rps_128 = rps_128;
        this.rps_256 = rps_256;
        this.errors = errors;
    }


    
    public Framework setId(int id)
    {
        return new Framework(id, this.name, this.language, this.server, this.rps_8, this.rps_16, this.rps_32,
                this.rps_64, this.rps_128, this.rps_256, this.errors);
    }
    
    public Framework setName(String name)
    {
        return new Framework(id, this.name, this.language, this.server, this.rps_8, this.rps_16, this.rps_32,
                this.rps_64, this.rps_128, this.rps_256, this.errors);
    }
    
    public Framework setLanguage(Language language)
    {
        return new Framework(this.id, this.name, language, this.server, this.rps_8, this.rps_16, this.rps_32,
                this.rps_64, this.rps_128, this.rps_256, this.errors);
    }
    
    public Framework setServer(Server server)
    {
        return new Framework(id, this.name, this.language, server, this.rps_8, this.rps_16, this.rps_32,
                this.rps_64, this.rps_128, this.rps_256, this.errors);
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + errors;
        result = prime * result + ((language == null) ? 0 : language.hashCode());
        result = prime * result + rps_128;
        result = prime * result + rps_16;
        result = prime * result + rps_256;
        result = prime * result + rps_32;
        result = prime * result + rps_64;
        result = prime * result + rps_8;
        result = prime * result + ((server == null) ? 0 : server.hashCode());
        return result;
    }



   
    public boolean deeplyEquals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Framework other = (Framework) obj;
        if (errors != other.errors)
            return false;
        if (language == null) {
            if (other.language != null)
                return false;
        } else if (!language.equals(other.language))
            return false;
        if (rps_128 != other.rps_128)
            return false;
        if (rps_16 != other.rps_16)
            return false;
        if (rps_256 != other.rps_256)
            return false;
        if (rps_32 != other.rps_32)
            return false;
        if (rps_64 != other.rps_64)
            return false;
        if (rps_8 != other.rps_8)
            return false;
        if (server == null) {
            if (other.server != null)
                return false;
        } else if (!server.equals(other.server))
            return false;
        return true;
    }



    @Override
    public String toString() {
        return "Framework [language=" + language + ", server=" + server + ", rps_8=" + rps_8 + ", rps_16=" + rps_16
                + ", rps_32=" + rps_32 + ", rps_64=" + rps_64 + ", rps_128=" + rps_128 + ", rps_256=" + rps_256
                + ", errors=" + errors + "]";
    }
    
    
}
