package com.finangen.services;

import com.finangen.domains.Pessoa;
import com.finangen.repositories.PessoaRepository;
import com.finangen.security.UsuarioSS;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //private final UsersRepository userRepository;
    private final PessoaRepository pessoaRepository;

    //public UserDetailsServiceImpl(UsersRepository userRepository) {
    public UserDetailsServiceImpl(PessoaRepository personRepository) {
        //this.userRepository = userRepository;
        this.pessoaRepository = personRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Optional<Users> user = userRepository.findByEmail(username);
        Optional<Pessoa> user = pessoaRepository.findByEmail(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return new UsuarioSS(user.orElse(null));
    }
}
