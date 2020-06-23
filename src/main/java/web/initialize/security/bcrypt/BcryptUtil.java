package web.initialize.security.bcrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptUtil {
	public static String encoder(CharSequence rawPassword) {
		return new BCryptPasswordEncoder().encode(rawPassword);
	}
}
