/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.repository.interfaces;

import ec.edu.espe.safestore.model.User;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ronal
 */
public class IUserRepositoryTest {
    
    public IUserRepositoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByUsername method, of class IUserRepository.
     */
    @Test
    public void testFindByUsername() {
        System.out.println("findByUsername");
        String username = "";
        IUserRepository instance = new IUserRepositoryImpl();
        User expResult = null;
        User result = instance.findByUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByEmail method, of class IUserRepository.
     */
    @Test
    public void testFindByEmail() {
        System.out.println("findByEmail");
        String email = "";
        IUserRepository instance = new IUserRepositoryImpl();
        User expResult = null;
        User result = instance.findByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByResetToken method, of class IUserRepository.
     */
    @Test
    public void testFindByResetToken() {
        System.out.println("findByResetToken");
        String token = "";
        IUserRepository instance = new IUserRepositoryImpl();
        User expResult = null;
        User result = instance.findByResetToken(token);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class IUserRepository.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        User user = null;
        IUserRepository instance = new IUserRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.save(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class IUserRepository.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        User user = null;
        IUserRepository instance = new IUserRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.update(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class IUserRepository.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String username = "";
        IUserRepository instance = new IUserRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.delete(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class IUserRepository.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        IUserRepository instance = new IUserRepositoryImpl();
        List<User> expResult = null;
        List<User> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByRole method, of class IUserRepository.
     */
    @Test
    public void testFindByRole() {
        System.out.println("findByRole");
        String role = "";
        IUserRepository instance = new IUserRepositoryImpl();
        List<User> expResult = null;
        List<User> result = instance.findByRole(role);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IUserRepositoryImpl implements IUserRepository {

        public User findByUsername(String username) {
            return null;
        }

        public User findByEmail(String email) {
            return null;
        }

        public User findByResetToken(String token) {
            return null;
        }

        public boolean save(User user) {
            return false;
        }

        public boolean update(User user) {
            return false;
        }

        public boolean delete(String username) {
            return false;
        }

        public List<User> findAll() {
            return null;
        }

        public List<User> findByRole(String role) {
            return null;
        }
    }

    public class IUserRepositoryImpl implements IUserRepository {

        public User findByUsername(String username) {
            return null;
        }

        public User findByEmail(String email) {
            return null;
        }

        public User findByResetToken(String token) {
            return null;
        }

        public boolean save(User user) {
            return false;
        }

        public boolean update(User user) {
            return false;
        }

        public boolean delete(String username) {
            return false;
        }

        public List<User> findAll() {
            return null;
        }

        public List<User> findByRole(String role) {
            return null;
        }
    }
    
}
