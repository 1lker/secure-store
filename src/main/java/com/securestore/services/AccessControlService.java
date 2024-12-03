package com.securestore.services;

import java.util.*;

public class AccessControlService {
    private Map<String, Set<String>> rolePermissions = new HashMap<>();
    private Map<String, String> userRoles = new HashMap<>();

    public AccessControlService() {
        // Rol ve izinleri tanımlama
        rolePermissions.put("ADMIN", new HashSet<>(Arrays.asList("READ", "WRITE", "DELETE")));
        rolePermissions.put("USER", new HashSet<>(Collections.singletonList("READ")));
    }

    public void assignRole(String userId, String role) {
        userRoles.put(userId, role);
    }

    public boolean hasAccess(String userId, String permission) {
        String role = getUserRole(userId);
        return rolePermissions.getOrDefault(role, Collections.emptySet()).contains(permission);
    }

    private String getUserRole(String userId) {
        return userRoles.getOrDefault(userId, "GUEST");
    }
}
