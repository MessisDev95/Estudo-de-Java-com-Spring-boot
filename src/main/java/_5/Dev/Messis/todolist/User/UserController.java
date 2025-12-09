package _5.Dev.Messis.todolist.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public UserModel create(@RequestBody UserModel UserModel) {
        System.out.println("======================================================");
        System.out.println("Usuário: " + UserModel.getUsername());
        System.out.println("Nome: " + UserModel.getName());
        System.out.println("Senha: " + UserModel.getPassword());
        
        var user = this.userRepository.findByUsername(UserModel.getUsername());
        if (user != null) {
            System.out.println("Usuário já existe!");
            return null;
        }
        var userCreated = this.userRepository.save(UserModel);
        return userCreated;

    }
    
}
