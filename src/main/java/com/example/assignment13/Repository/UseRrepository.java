package com.example.assignment13.Repository;

import com.example.assignment13.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseRrepository extends JpaRepository<UserModel,Integer> {
}
