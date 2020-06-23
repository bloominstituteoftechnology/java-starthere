package local.skylerwebdev.starter.repository;

import local.skylerwebdev.starter.models.user_LoginModels.UserEmail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserEmailRepository extends CrudRepository<UserEmail, Long>
{
    List<UserEmail> findAllByUser_Username(String name);
}
