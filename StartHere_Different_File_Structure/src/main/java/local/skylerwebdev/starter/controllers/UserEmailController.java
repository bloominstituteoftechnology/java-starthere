package local.skylerwebdev.starter.controllers;

import local.skylerwebdev.starter.logging.Loggable;
import local.skylerwebdev.starter.models.user_LoginModels.UserEmail;
import local.skylerwebdev.starter.services.services.UserEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Loggable
@RestController
@RequestMapping("/UserEmails")
public class UserEmailController
{
    private static final Logger logger = LoggerFactory.getLogger(UserEmailController.class);

    @Autowired
    UserEmailService UserEmailService;

    // http://localhost:2019/UserEmails/UserEmails
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/UserEmails",
                produces = {"application/json"})
    public ResponseEntity<?> listAllUserEmails(HttpServletRequest request)
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<UserEmail> allUserEmails = UserEmailService.findAll();
        return new ResponseEntity<>(allUserEmails,
                                    HttpStatus.OK);
    }

    // http://localhost:2019/UserEmails/UserEmail/8
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/UserEmail/{UserEmailId}",
                produces = {"application/json"})
    public ResponseEntity<?> getUserEmailById(HttpServletRequest request,
                                              @PathVariable
                                                  Long UserEmailId)
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        UserEmail ue = UserEmailService.findUserEmailById(UserEmailId);
        return new ResponseEntity<>(ue,
                                    HttpStatus.OK);
    }


    // http://localhost:2019/UserEmails/username/cinnamon
    @GetMapping(value = "/username/{userName}",
                produces = {"application/json"})
    public ResponseEntity<?> findUserEmailByUserName(HttpServletRequest request,
                                                     @PathVariable
                                                         String userName)
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<UserEmail> theUserEmails = UserEmailService.findByUserName(userName,
                                                                        request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(theUserEmails,
                                    HttpStatus.OK);
    }

    // http://localhost:2019/UserEmails/UserEmail/8
    @DeleteMapping("/UserEmail/{UserEmailid}")
    public ResponseEntity<?> deleteUserEmailById(HttpServletRequest request,
                                                 @PathVariable
                                                         long UserEmailid)
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        UserEmailService.delete(UserEmailid,
                                request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // http://localhost:2019/UserEmails/UserEmail/9/email/favbun@hops.local
    @PutMapping("/UserEmail/{UserEmailid}/email/{emailaddress}")
    public ResponseEntity<?> updateUserEmail(HttpServletRequest request,
                                             @PathVariable
                                                     long UserEmailid,
                                             @PathVariable
                                                 String emailaddress)
    {
        UserEmailService.update(UserEmailid,
                                emailaddress,
                                request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // note emails are added through the user process
}
