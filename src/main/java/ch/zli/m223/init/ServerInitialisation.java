package ch.zli.m223.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.zli.m223.repository.RoleRepository;
import ch.zli.m223.roles.UserRoles;
import ch.zli.m223.service.UserService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ServerInitialisation implements ApplicationRunner {

    private final UserService userService;
    private final RoleRepository roleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        roleRepository.addRole(UserRoles.member);
        roleRepository.addRole(UserRoles.admin);
        
        userService.addUser("admin", "admin", "admin@admin.com", "admin");
        userService.addUser("Max", "Werner", "mw@test.com", "maxwerner");
        userService.addUser("Mini", "Max", "mm@test.com", "minimax");
        userService.addUser("Lady", "Gaga", "lady@gaga.com", "ladygaga");
    }
    
}
