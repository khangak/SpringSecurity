package web.initialize.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	Integer id;
	
	@Column(name = "username")
	String user;

	@Column(name = "password")
	String pass;
	
	@Column(name = "role")
	String role;
}
