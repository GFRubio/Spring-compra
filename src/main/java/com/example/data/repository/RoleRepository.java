package com.example.data.repository;


import com.example.data.model.Rol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Rol, Long> {

    Rol findByName(String name);
}