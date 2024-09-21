package com.fms.fleetmanagement.controller;

import com.fms.fleetmanagement.dto.PermissionDTO;
import com.fms.fleetmanagement.service.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/permissions")
@AllArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping("/create")
    public ResponseEntity<PermissionDTO> createPermission(@RequestBody PermissionDTO permissionDTO) {
        PermissionDTO createdPermission = permissionService.createPermission(permissionDTO);
        return new ResponseEntity<>(createdPermission, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissionDTO> updatePermission(
            @PathVariable int id, @RequestBody PermissionDTO updatedPermissionDTO) {
        PermissionDTO updatedPermission = permissionService.updatePermission(id, updatedPermissionDTO);
        return new ResponseEntity<>(updatedPermission, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionDTO> getPermissionById(@PathVariable int id) {
        PermissionDTO permission = permissionService.getPermissionById(id);
        return ResponseEntity.of(Optional.ofNullable(permission));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PermissionDTO>> getAllPermissions() {
        List<PermissionDTO> permissions = permissionService.getAllPermissions();
        return ResponseEntity.ok(permissions);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermissionById(@PathVariable int id) {
        permissionService.deletePermissionById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
