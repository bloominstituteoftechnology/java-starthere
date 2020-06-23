package local.skylerwebdev.starter.services.services;

import local.skylerwebdev.starter.models.user_LoginModels.Role;

import java.util.List;

public interface RoleService
{
    List<Role> findAll();

    Role findRoleById(long id);

    void delete(long id);

    Role save(Role role);

    Role findByName(String name);

    Role update(long id, Role role);
}
