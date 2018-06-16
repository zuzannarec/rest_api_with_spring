package rest.java.restApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.java.restApi.exceptions.UserExistsException;
import rest.java.restApi.model.User;
import rest.java.restApi.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    static List<User> users;

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public Optional<User> getUserByName(final String name){
        return repository.getUserByName(name);
    }

    public Optional<User> getUserById(final Long id){
        return repository.findById(id);
    }

    public Long addUser(User user){
        Optional<User> optionalUser = getUserByName(user.getName());
        if(optionalUser.isPresent()){
            throw new UserExistsException("user exists in the system");
        }
        user = repository.save(user);
        return user.getId();
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public void updateUser(final User user, final Long id){
//        repository.deleteById(id);
        user.setId(id);
        repository.save(user);
    }

    public void deleteUser(final Long id) {
        repository.deleteById(id);
    }

}
