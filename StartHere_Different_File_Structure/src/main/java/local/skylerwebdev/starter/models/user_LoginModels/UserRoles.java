package local.skylerwebdev.starter.models.user_LoginModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import local.skylerwebdev.starter.logging.Loggable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Loggable
@Entity
@Table(name = "userroles",
       uniqueConstraints = {@UniqueConstraint(columnNames = {"userid", "roleid"})})
public class UserRoles extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties("userroles")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "roleid")
    @JsonIgnoreProperties("userroles")
    private Role role;

    public UserRoles()
    {
    }

    public UserRoles(User user,
                     Role role)
    {
        this.user = user;
        this.role = role;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoles userRoles = (UserRoles) o;
        return Objects.equals(user, userRoles.user) &&
            Objects.equals(role, userRoles.role);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUser(),
                            getRole());
    }

    @Override
    public String toString()
    {
        return "UserRoles{" + "user=" + user.getUserid() + ", role=" + role.getRoleid() + '}';
    }
}
