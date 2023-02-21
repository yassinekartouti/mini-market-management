package net.javaguides.sms;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import net.javaguides.sms.entity.Role;
import net.javaguides.sms.repository.RoleRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTest {
    @Autowired 
    RoleRepository roleRepository;

    @Test
    public void testCreateRoles() {
        Role superAdmin = new Role("Super Admin");
        roleRepository.saveAll(List.of(superAdmin));
        List<Role> listRoles = roleRepository.findAll();
        assertThat(listRoles.size()).isEqualTo(1);
    }
}
