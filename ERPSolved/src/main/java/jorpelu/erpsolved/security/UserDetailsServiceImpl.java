package jorpelu.erpsolved.security;

import jorpelu.erpsolved.model.Usuario;
import jorpelu.erpsolved.repo.IUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserInterface userRepo;

    @Autowired
    private PasswordEncoder pssEncoder;

    public Usuario save(Usuario user){
        user.setPassword(pssEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userRepo.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new UserDetailsImpl(user);
    }

}