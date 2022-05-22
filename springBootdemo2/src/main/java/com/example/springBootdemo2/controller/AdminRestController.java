package com.example.springBootdemo2.controller;

import com.example.springBootdemo2.model.Role;
import com.example.springBootdemo2.model.User;
import com.example.springBootdemo2.service.RoleService;
import com.example.springBootdemo2.service.UserService;
import com.example.springBootdemo2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin_api")
public class AdminRestController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    //Все юзеры
    @GetMapping()
    public List<User> userALL() {
        return userService.getAllUsers();
    }

    //Юзер по ID
    @GetMapping("/{id}")
    public User usersId(@PathVariable("id") int id) {
        return userService.getUserId(id);
    }

    //Добавить нового юзера
    @PostMapping
    public User addUser(@RequestBody User user) {
         return userService.addUser(user);

    }

    //Изменить юзера
    @PutMapping
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user); // вот тут изменила с addUser
        return user;
    }

    //Удалить юзера
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.removeUser(id);
    }

    @GetMapping("/getroles")
    private List<Role> allRoles() {
        return (List<Role>) roleService.findAll();
    }
}
