package Security2.Security2.service;

import Security2.Security2.model.UserModel;
import Security2.Security2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    final
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("Nicoleta","1234", new ArrayList<>());
    }


    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(Integer userId) {
        return userRepository.findById(userId).get();
    }

    public UserModel createUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public void updateUser(Integer userId, UserModel userModel){
        userRepository.findById(userId).get().setName(userModel.getName());
        userRepository.findById(userId).get().setFirstName(userModel.getFirstName());
        userRepository.findById(userId).get().setLastName(userModel.getLastName());

    }
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }


}
