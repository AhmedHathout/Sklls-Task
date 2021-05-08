package com.ahmedhathout.skllstask.repositories;

import com.ahmedhathout.skllstask.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, UserDetailsService {
    Optional<User> findUserByEmail(String email);

    @Override
    default UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Delete print
        System.out.println("username=" + username);
        UserDetails userDetails = findUserByEmail(username.toLowerCase().trim()).orElseThrow(() -> {System.out.println("ssssssssssss"); return new UsernameNotFoundException(username);});
        System.out.println("userDetails=" + userDetails);
        return userDetails;
    }
}
