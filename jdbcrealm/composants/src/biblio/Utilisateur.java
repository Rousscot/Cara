package biblio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import org.apache.commons.codec.digest.DigestUtils;

@Entity
public class Utilisateur implements Serializable {
          
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(length=128)
    private String email;
  
    @Column(nullable=false, length=128)
    private String firstName;
      
    @Column(nullable=false, length=128)
    private String lastName;
      
    @Column(nullable=false, length=128) //sha-512 + hex
    private String password;
               
   
    @JoinColumn(name = "GROUPNAME")
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<Groupes> groups;

    
    public Utilisateur(){
    	
    	groups = new ArrayList<Groupes>();
         
    }
     
    public Utilisateur(Utilisateur user){
         
        this(); 
        this.email        = user.getEmail();
        this.firstName    = user.getFirstName();
        this.lastName     = user.getLastName();        
        this.password     = DigestUtils.sha512Hex(user.getPassword() );
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getEmail() {
        return email;
    }
  
    public void setEmail(String email) {
        this.email = email;
    }
  
    /**
     * @return the password in SHA512 HEX representation
     */
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = DigestUtils.sha512Hex(password);
    }
 
 
    public List<Groupes> getGroups() {
        return groups;
    }
 
    public void setGroups(List<Groupes> groups) {
        this.groups = groups;
    }
 
    @Override
    public String toString() {
        return "User [email=" + email + ", firstName=" + firstName
                + ", lastName=" + lastName + ", password=" + password
                + ", groups=" + groups + "]";
    }
}
