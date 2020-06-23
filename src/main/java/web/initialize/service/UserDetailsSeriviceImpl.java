package web.initialize.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import web.initialize.entity.UserEntity;
import web.initialize.repository.UserRepository;
@Service
public class UserDetailsSeriviceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> user = userRepository.findByUser(username);
		if(!user.isPresent()) {
			throw new UsernameNotFoundException("Username " + username + "was not found!");
		}
		GrantedAuthority grant = new SimpleGrantedAuthority(user.get().getRole());
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		grantList.add(grant);
		UserDetails userDetails = new User(user.get().getUser(),user.get().getPass(),grantList);
		return userDetails;
	}

}
