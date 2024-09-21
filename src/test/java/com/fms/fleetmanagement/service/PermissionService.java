package com.fms.fleetmanagement.service;

import com.fms.fleetmanagement.dto.PermissionDTO;
import com.fms.fleetmanagement.entity.Permission;
import com.fms.fleetmanagement.repository.PermissionRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PermissionServiceTest {

    @Mock
    private PermissionRepository permissionRepository;

    @InjectMocks
    private PermissionService permissionService;

    @Test
    void testCreatePermission() {
        // Input DTO for creating permission
        PermissionDTO inputPermissionDTO = new PermissionDTO();
        inputPermissionDTO.setName("TestPermission");

        // Mocking the repository's safe method
        when(permissionRepository.save(any())).thenAnswer(invocation -> {
            Permission savedPermission = invocation.getArgument(0);
            savedPermission.setId(1);  // Assigning an ID to the saved permission
            return savedPermission;
        });

        // Calling the service method to create a permission
        PermissionDTO resultPermissionDTO = permissionService.createPermission(inputPermissionDTO);

        // Verifying the result
        assertNotNull(resultPermissionDTO);
        // The ID should not be null after creation
        assertEquals(inputPermissionDTO.getName(), resultPermissionDTO.getName());

        // Verifying that the save method of the repository was called
        verify(permissionRepository, times(1)).save(any());
    }
}
