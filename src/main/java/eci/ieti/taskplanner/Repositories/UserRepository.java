package eci.ieti.taskplanner.Repositories;

import eci.ieti.taskplanner.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
