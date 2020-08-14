package com.example.restful.service;

import com.example.restful.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class UserService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;

    static{
        users.add(new User(1,"kim",new Date()));
        users.add(new User(2,"min",new Date()));
        users.add(new User(3,"soo",new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for (User user : users) {
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id){
        for (User user : users) {
            if(user.getId()==id){
                users.remove(user);
                return user;
            }
        }
        return null;
    }
}
