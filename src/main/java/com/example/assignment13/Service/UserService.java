package com.example.assignment13.Service;


import com.example.assignment13.Model.UserModel;
import com.example.assignment13.Repository.UseRrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    final private UseRrepository useRrepository;

    public List<UserModel> getUsers(){
        List<UserModel> users=useRrepository.findAll();
        return users;
    }

    public void addUser(UserModel user){
        useRrepository.save(user);
    }

    public boolean updateUser(UserModel user, Integer id){
        UserModel oldUser = useRrepository.getById(id);
         if (oldUser==null)
            return false;

        Integer oldId=oldUser.getID();
        oldUser=user;
        oldUser.setID(oldId);
        useRrepository.save(oldUser);
        return true;
    }

    public boolean deleteUser(Integer id){
        UserModel oldUser = useRrepository.getById(id);
         if (oldUser==null)
            return false;

        useRrepository.delete(oldUser);
        return true;
    }

}
