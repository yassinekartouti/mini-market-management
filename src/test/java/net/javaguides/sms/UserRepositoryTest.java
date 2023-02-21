package net.javaguides.sms;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import net.javaguides.sms.entity.Role;
import net.javaguides.sms.entity.User;
import net.javaguides.sms.repository.RoleRepository;
import net.javaguides.sms.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired 
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUsername("yassine");
        user.setPassword("$2a$10$beXQpfgVfeIBPmufWGeIMewGQrjypoiYrcMAOSmoUVPI.2vkw42au"); 
        Role roleUser = roleRepository.findByName("Super Admin");
        user.addRole(roleUser);

        User savedUser = userRepository.save(user);
        assertThat(savedUser.getRoles().size()).isEqualTo(1);
    }
}