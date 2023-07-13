package ch.zli.m223.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.controller.dto.UserDto;
import ch.zli.m223.controller.dto.UserUpdateDto;
import ch.zli.m223.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/admin/users")
@RequiredArgsConstructor
public class UserAdminController {
    
    private final UserService userService;

    @GetMapping()
    List<UserDto> getUserList() {
        return userService.getUserList().stream()
        .map( user -> new UserDto(user))
        .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    UserDto getUser(@PathVariable("id") Long id) {
        return new UserDto(userService.getUser(id));
    }

    @PutMapping("/{id}")
    UserDto updateUser(
        @PathVariable("id") Long id,
        @RequestBody UserUpdateDto data
    ) {
        return new UserDto(userService.updateUser(
            id,
            data.firstName, data.lastName, 
            data.email, data.password, data.role
        ));
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/{id}/role")
    UserDto setUserRole(@PathVariable("id") Long id, @RequestBody String role) {
        return new UserDto(userService.setUserRole(id, role));
    }
}
