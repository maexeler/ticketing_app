package ch.zli.m223.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.zli.m223.model.AppUser;
import ch.zli.m223.repository.RoleRepository;
import ch.zli.m223.repository.TodoRepository;
import ch.zli.m223.roles.UserRoles;
import ch.zli.m223.service.user.UserService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ServerInitialisation implements ApplicationRunner {

    private final UserService userService;
    private final RoleRepository roleRepository;
    private final TodoRepository todoRepository;

    @Value("${test.data.create.user:false}")
    private boolean createTestDataForUser;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (createTestDataForUser) {
            roleRepository.addRole(UserRoles.member);
            roleRepository.addRole(UserRoles.admin);
            
            userService.addUser("admin", "admin", "admin@admin.com", "admin");
            userService.addUser("Max", "Werner", "max@werner.com", "maxwerner");
            userService.addUser("Mini", "Max", "mini@max.com", "minimax");
            userService.addUser("Lady", "Gaga", "lady@gaga.com", "ladygaga");

            AppUser todoUser = 
            userService.addUser("todo", "todo", "todo@todo.com", "todo");
            todoRepository.addTodo(todoUser, "do it", false);
            todoRepository.addTodo(todoUser, "do it again", false);
            todoRepository.addTodo(todoUser, "did it already", true);
        }
    }
    
}
