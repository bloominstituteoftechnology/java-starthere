package local.skylerwebdev.starter.models.user_LoginModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import local.skylerwebdev.starter.logging.Loggable;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Loggable
@Entity
@Table(name = "UserEmails",
       uniqueConstraints = {@UniqueConstraint(columnNames = {"userid", "UserEmail"})})
public class UserEmail extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long UserEmailid;

    @Column(nullable = false)
    @Email
    private String UserEmail;

    @ManyToOne
    @JoinColumn(name = "userid",
                nullable = false)
    @JsonIgnoreProperties("UserEmails")
    private User user;

    public UserEmail()
    {
    }

    public UserEmail(User user,
                     String UserEmail)
    {
        this.UserEmail = UserEmail;
        this.user = user;
    }

    public long getUserEmailid()
    {
        return UserEmailid;
    }

    public void setUserEmailid(long UserEmailid)
    {
        this.UserEmailid = UserEmailid;
    }

    public String getUserEmail()
    {
        if (UserEmail == null) // this is possible when updating a user
        {
            return null;
        } else
        {
            return UserEmail.toLowerCase();
        }
    }

    public void setUserEmail(String UserEmail)
    {
        this.UserEmail = UserEmail.toLowerCase();
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "UserEmail{" + "UserEmailid=" + UserEmailid + ", UserEmail='" + UserEmail + '\'' + ", user=" + user.getUsername() + '}';
    }
}
