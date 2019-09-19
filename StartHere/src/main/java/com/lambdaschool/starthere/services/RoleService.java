package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Role;

import java.util.List;

// Note role does not have an update. Changing the spelling of the role impacts resource access so is BIG DEAL!

public interface RoleService
{
    List<Role> findAll();

    Role findRoleById(long id);

    void delete(long id);

    Role save(Role role);

    Role findByName(String name);
}