package leandro.PruebaJersey2;

import java.io.Serializable;

public class User implements Serializable {
 
    private static final long serialVersionUID = 1L;
    
    public Integer id;
    public String name;
    public String username;
 
    public User() {
        super();
    }
     
    public User(Integer id, String name, String username) {
        super();
        this.id = id;
        this.name = name;
        this.username = username;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    
    

}
