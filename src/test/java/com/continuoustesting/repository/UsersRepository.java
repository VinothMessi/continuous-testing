package com.continuoustesting.repository;

import com.continuoustesting.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface UsersRepository extends JpaRepository<Users, Integer> {
}