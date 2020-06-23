package local.skylerwebdev.starter.services.services;

import local.skylerwebdev.starter.models.user_LoginModels.UserEmail;

import java.util.List;

public interface UserEmailService
{
    List<UserEmail> findAll();

    UserEmail findUserEmailById(long id);

    List<UserEmail> findByUserName(String username,
                                   boolean isAdmin);

    void delete(long id,
                boolean isAdmin);

    UserEmail update(long UserEmailid,
                     String emailaddress,
                     boolean isAdmin);

    // note emails are added through the user process
}
