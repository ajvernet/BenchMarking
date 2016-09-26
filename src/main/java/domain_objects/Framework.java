package domain_objects;

public class Framework extends DomainObject{
    
    
    Language language;
    Server server;
    

    int RPS_8, RPS_16, RPS_32, RPS_64, RPS_128, RPS_256;
    int errors;
    public Framework(int id, String name, Language language, Server server, int rPS_8, int rPS_16, int rPS_32,
            int rPS_64, int rPS_128, int rPS_256, int errors) {
        super(id, name);
        this.language = language;
        this.server = server;
        RPS_8 = rPS_8;
        RPS_16 = rPS_16;
        RPS_32 = rPS_32;
        RPS_64 = rPS_64;
        RPS_128 = rPS_128;
        RPS_256 = rPS_256;
        this.errors = errors;
    }

    
    
    
    
}
