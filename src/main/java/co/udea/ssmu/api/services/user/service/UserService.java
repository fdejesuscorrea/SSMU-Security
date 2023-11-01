package co.udea.ssmu.api.services.user.service;

import co.udea.ssmu.api.model.jpa.dto.role.RoleDTO;
import co.udea.ssmu.api.model.jpa.dto.user.UserDTO;
import co.udea.ssmu.api.model.jpa.model.role.Role;
import co.udea.ssmu.api.model.jpa.model.user.User;
import co.udea.ssmu.api.model.jpa.repository.role.RoleRepository;
import co.udea.ssmu.api.model.jpa.repository.user.UserRepository;
import co.udea.ssmu.api.services.user.facade.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService, UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = this.userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("email " +email + "not found."));

        String[] roles = user.getRoles().stream().map(Role::getName).toArray(String[]::new);

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(this.grantedAuthorities(roles))
                .build();
    }

    private List<GrantedAuthority> grantedAuthorities(String[] roles) {
        List<GrantedAuthority> authorities = new ArrayList<>(roles.length);
        for (String role: roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        return authorities;
    }

    @Override
    public UserDTO save(UserDTO userDTO){
        User user = new User(userDTO.getEmail(), userDTO.getPassword(), List.of(new Role(1L)));
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            return null;
        } else {
            User userFound = userRepository.save(user);
            return new UserDTO(userFound.getEmail(), userFound.getPassword(), List.of(new RoleDTO(1L,"USER")));
        }
    }
}
