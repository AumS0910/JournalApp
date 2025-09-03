package org.example.journalapp.repository;

import org.bson.types.ObjectId;
import org.example.journalapp.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String userName);

    void deleteByUserName(String userName);
}
