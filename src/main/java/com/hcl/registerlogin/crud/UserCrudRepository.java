package com.hcl.registerlogin.crud;
import org.springframework.data.repository.CrudRepository;

import com.hcl.registerlogin.user.User;


public interface UserCrudRepository extends CrudRepository<User, Long>{

}
