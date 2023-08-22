package com.company.project.signup.repository;

import com.company.project.signup.model.User;
import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository <User, String>{
}
