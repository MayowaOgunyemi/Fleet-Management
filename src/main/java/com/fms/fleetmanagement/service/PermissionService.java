package com.fms.fleetmanagement.service;

import com.fms.fleetmanagement.dto.PermissionDTO;
import com.fms.fleetmanagement.entity.Permission;
import com.fms.fleetmanagement.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PermissionService {

    private final PermissionRepository permissionRepository;

    public PermissionDTO createPermission(PermissionDTO permissionDTO) {
        Permission permissionEntity = new Permission();
        permissionEntity.setName(permissionDTO.getName());

        Permission savedPermission = permissionRepository.save(permissionEntity);
        return mapEntityToDTO(savedPermission);
    }

    public PermissionDTO updatePermission(int id, PermissionDTO updatedPermissionDTO) {
        Optional<Permission> existingPermissionOptional = Optional.ofNullable(permissionRepository.findById(id));

        if (existingPermissionOptional.isPresent()) {
            Permission existingPermission = existingPermissionOptional.get();
            existingPermission.setName(updatedPermissionDTO.getName());

            Permission savedPermission = permissionRepository.save(existingPermission);
            return mapEntityToDTO(savedPermission);
        } else {
            // Handle case where permission with given ID is not found
            throw new RuntimeException("Permission with ID " + id + " not found.");
        }
    }

    public PermissionDTO getPermissionById(int id) {
        Optional<Permission> permissionOptional = Optional.ofNullable(permissionRepository.findById(id));

        return permissionOptional.map(this::mapEntityToDTO)
                .orElse(null); // You can throw an exception or handle accordingly if not found
    }

    public List<PermissionDTO> getAllPermissions() {
        List<Permission> allPermissions = permissionRepository.findAll();
        return allPermissions.stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    public void deletePermissionById(int id) {
        permissionRepository.deleteById(id);
    }

    // Helper method to map PermissionDTO to Permission entity
    private PermissionDTO mapEntityToDTO(Permission permission) {
        PermissionDTO permissionDTO = new PermissionDTO();
        permissionDTO.setId(permission.getId());
        permissionDTO.setName(permission.getName());
        return permissionDTO;
    }
}
