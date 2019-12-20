package com.example.rest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.rest.model.UserInfo;
import java.lang.String;
import java.util.List;

@Repository
public interface UserAuthRepository  extends JpaRepository<UserInfo, String >{
	
	List<UserInfo> findByFirstName(String firstname);
	
	@Query(value = "SELECT * FROM user_info WHERE first_name = ?1 and password=?2", nativeQuery = true)
	  UserInfo findByUserNamePassword(String username, String password);
	//UserInfo (String id,String password);

	//UserInfo findByUserNamePassword(String username, String password);
	
}
