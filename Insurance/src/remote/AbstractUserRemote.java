package remote;

import javax.ejb.Remote;

@Remote
public interface AbstractUserRemote {

    public boolean login(String lastName, String password);

}
