
package ec.edu.espe.safestore.repository.interfaces;
import ec.edu.espe.safestore.model.User;
import java.util.List;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public interface IUserRepository {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByResetToken(String token);
    boolean save(User user);
    boolean update(User user);
    boolean delete(String username);
    List<User> findAll();
    List<User> findByRole(String role);
}
