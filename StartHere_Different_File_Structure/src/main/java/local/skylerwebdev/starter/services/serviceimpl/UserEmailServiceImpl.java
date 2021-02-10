package local.skylerwebdev.starter.services.serviceimpl;

import local.skylerwebdev.starter.exceptions.ResourceNotFoundException;
import local.skylerwebdev.starter.logging.Loggable;
import local.skylerwebdev.starter.models.user_LoginModels.UserEmail;
import local.skylerwebdev.starter.repository.UserEmailRepository;
import local.skylerwebdev.starter.services.services.UserEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Loggable
@Service(value = "UserEmailService")
public class UserEmailServiceImpl implements UserEmailService
{
    @Autowired
    private UserEmailRepository UserEmailrepos;

    @Override
    public List<UserEmail> findAll()
    {
        List<UserEmail> list = new ArrayList<>();
        UserEmailrepos.findAll()
                      .iterator()
                      .forEachRemaining(list::add);
        return list;
    }

    @Override
    public UserEmail findUserEmailById(long id)
    {
        return UserEmailrepos.findById(id)
                             .orElseThrow(() -> new ResourceNotFoundException("UserEmail with id " + id + " Not Found!"));
    }

    @Override
    public List<UserEmail> findByUserName(String username,
                                          boolean isAdmin)
    {
        Authentication authentication = SecurityContextHolder.getContext()
                                                             .getAuthentication();
        if (username.equalsIgnoreCase(authentication.getName().toLowerCase()) || isAdmin)
        {
            return UserEmailrepos.findAllByUser_Username(username.toLowerCase());
        } else
        {
            throw new ResourceNotFoundException(authentication.getName() + " not authorized to make change");
        }
    }


    @Override
    public void delete(long id,
                       boolean isAdmin)
    {
        if (UserEmailrepos.findById(id)
                          .isPresent())
        {
            Authentication authentication = SecurityContextHolder.getContext()
                                                                 .getAuthentication();
            if (UserEmailrepos.findById(id)
                              .get()
                              .getUser()
                              .getUsername()
                              .equalsIgnoreCase(authentication.getName()) || isAdmin)
            {
                UserEmailrepos.deleteById(id);
            } else
            {
                throw new ResourceNotFoundException(authentication.getName() + " not authorized to make change");
            }
        } else
        {
            throw new ResourceNotFoundException("UserEmail with id " + id + " Not Found!");
        }
    }

    @Override
    public UserEmail update(long UserEmailid,
                            String emailaddress,
                            boolean isAdmin)
    {
        Authentication authentication = SecurityContextHolder.getContext()
                                                             .getAuthentication();
        if (UserEmailrepos.findById(UserEmailid)
                          .isPresent())
        {
            if (UserEmailrepos.findById(UserEmailid)
                              .get()
                              .getUser()
                              .getUsername()
                              .equalsIgnoreCase(authentication.getName()) || isAdmin)
            {
                UserEmail UserEmail = findUserEmailById(UserEmailid);
                UserEmail.setUserEmail(emailaddress.toLowerCase());
                return UserEmailrepos.save(UserEmail);
            } else
            {
                throw new ResourceNotFoundException(authentication.getName() + " not authorized to make change");
            }
        } else
        {
            throw new ResourceNotFoundException("UserEmail with id " + UserEmailid + " Not Found!");
        }
    }
}
