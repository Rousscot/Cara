/**
 *
 * @author roos
 */

package biblio;

import javax.persistence.*;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.Query;

@DeclareRoles({"Bibliothecaire","Lecteur"})
@Stateless
public class BiblioBeanBean implements BiblioBeanRemote {
    
  @PersistenceContext(unitName = "Biblio-ejbPU")
  EntityManager persistance;
  
  @RolesAllowed({"Bibliothecaire","Lecteur"})
  public List<String> liste() {
    Query q = persistance.createNamedQuery("allbooks");
    try {
      List<String> resultList = (List<String>)q.getResultList();
	  return resultList;
    } catch (ClassCastException e) {
      return null;
    }
  }

  @RolesAllowed("Bibliothecaire")
  public void ajouter(String author, String title) {
    Book b = new Book();
    b.setTitle(title);
    b.setAuthor(author);
    persistance.persist(b);
  }

  @RolesAllowed("Lecteur")
  public Book getLivre(String title) {
    String texteRequete = "SELECT b FROM Book AS b WHERE b.title='"+title+"'";
    Query requete = persistance.createQuery(texteRequete);
    Book resultat = null;
    try {
      resultat = (Book)requete.getSingleResult();
    } catch (NonUniqueResultException e) {
    } catch (EntityNotFoundException ee) {  	
    } catch (NoResultException eee) {
    }
    return resultat;
  }

  @PermitAll
  public void init() {
	  Groupes g1 = persistance.find(Groupes.class, "Bibliothecaire");
	  Groupes g2 = persistance.find(Groupes.class,"Lecteur");
	  Utilisateur u1 = new Utilisateur();
	  u1.setEmail("zenobe.gramme@bibliotheque-lille.fr");
	  u1.setFirstName("Zenobe");
	  u1.setLastName("Gramme");
	  u1.setPassword("toto");
	  u1.getGroups().add(g1);
	  g1.getUsers().add(u1);
	  Utilisateur u2 = new Utilisateur();
	  u2.setEmail("gudule.witberg@fai.fr");
	  u2.setFirstName("Gudule");
	  u2.setLastName("Witberg");
	  u2.setPassword("toto");
	  u2.getGroups().add(g2);
	  g2.getUsers().add(u2);
	  persistance.persist(u1);
	  persistance.persist(u2);
	  persistance.merge(g1);
	  persistance.merge(g2);

  }

}
