package local.skylerwebdev.starter;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import local.skylerwebdev.starter.models.user_LoginModels.Role;
import local.skylerwebdev.starter.models.user_LoginModels.User;
import local.skylerwebdev.starter.models.user_LoginModels.UserRoles;
import local.skylerwebdev.starter.models.user_LoginModels.UserEmail;
import local.skylerwebdev.starter.services.services.RoleService;
import local.skylerwebdev.starter.services.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Locale;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;


    @Override
    public void run(String[] args) throws Exception {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        roleService.save(r1);
        roleService.save(r2);
        roleService.save(r3);

        // admin, data, user
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(),
            r1));
        admins.add(new UserRoles(new User(),
            r2));
        admins.add(new UserRoles(new User(),
            r3));
        User u1 = new User("admin",
            "password",
            "admin@lambdaschool.local",
            admins);
        u1.getUserEmails()
            .add(new UserEmail(u1,
                "admin@email.local"));
        u1.getUserEmails()
            .add(new UserEmail(u1,
                "admin@mymail.local"));

        userService.save(u1);

        // data, user
        ArrayList<UserRoles> datas = new ArrayList<>();
        datas.add(new UserRoles(new User(),
            r3));
        datas.add(new UserRoles(new User(),
            r2));
        User u2 = new User("cinnamon",
            "1234567",
            "cinnamon@lambdaschool.local",
            datas);
        u2.getUserEmails()
            .add(new UserEmail(u2,
                "cinnamon@mymail.local"));
        u2.getUserEmails()
            .add(new UserEmail(u2,
                "hops@mymail.local"));
        u2.getUserEmails()
            .add(new UserEmail(u2,
                "bunny@email.local"));
        userService.save(u2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(),
            r2));
        User u3 = new User("barnbarn",
            "ILuvM4th!",
            "barnbarn@lambdaschool.local",
            users);
        u3.getUserEmails()
            .add(new UserEmail(u3,
                "barnbarn@email.local"));
        userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(),
            r2));
        User u4 = new User("puttat",
            "password",
            "puttat@school.lambda",
            users);
        userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(),
            r2));
        User u5 = new User("misskitty",
            "password",
            "misskitty@school.lambda",
            users);
        userService.save(u5);

        // using JavaFaker create a bunch of regular users
        // https://www.baeldung.com/java-faker
        // https://www.baeldung.com/regular-expressions-java


    }}
