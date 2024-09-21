package com.fms.fleetmanagement.service;

import com.fms.fleetmanagement.dto.RoleDTO;
import com.fms.fleetmanagement.entity.Permission;
import com.fms.fleetmanagement.entity.Role;
import com.fms.fleetmanagement.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleDTO createRole(RoleDTO roleDTO) {
        Role roleEntity = new Role();
        roleEntity.setRole(roleDTO.getRole());
        roleEntity.setPermission(mapPermissionDTOToEntity(roleDTO.getPermissionId()));

        Role savedRole = roleRepository.save(roleEntity);
        return mapEntityToDTO(savedRole);
    }

    public RoleDTO updateRole(int id, RoleDTO updatedRoleDTO) {
        Optional<Role> existingRoleOptional = Optional.ofNullable(roleRepository.findById(id));

        if (existingRoleOptional.isPresent()) {
            Role existingRole = existingRoleOptional.get();

            Role updatedRole = new Role();
            updatedRole.setId(existingRole.getId());
            updatedRole.setRole(updatedRoleDTO.getRole());
            updatedRole.setPermission(existingRole.getPermission()); // Retain the existing permission

            Role savedRole = roleRepository.save(updatedRole);
            return mapEntityToDTO(savedRole);
        } else {
            // Handle case where role with given ID is not found
            throw new RuntimeException("Role with ID " + id + " not found.");
        }
    }

    public RoleDTO getRoleById(int id) {
        Optional<Role> roleOptional = Optional.ofNullable(roleRepository.findById(id));

        return roleOptional.map(this::mapEntityToDTO)
                .orElse(null); // You can throw an exception or handle accordingly if not found
    }

    public List<RoleDTO> getAllRoles() {
        List<Role> allRoles = roleRepository.findAll();
        return allRoles.stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    public void deleteRoleById(int id) {
        roleRepository.deleteById(id);
    }

    // Helper method to map RoleDTO to Role entity
    private RoleDTO mapEntityToDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setRole(role.getRole());
        roleDTO.setPermissionId(mapPermissionEntityToDTO(role.getPermission()));
        return roleDTO;
    }

    // Helper method to map PermissionDTO to Permission entity
    private Permission mapPermissionDTOToEntity(int permissionDTO) {
        Permission permission = new Permission();
        permission.setName(String.valueOf(permissionDTO));
        return permission;
    }

    // Helper method to map Permission entity to PermissionDTO
    private int mapPermissionEntityToDTO(Permission permission) {
        return permission.getId();
    }
}
