package com.shiftFlow.org.user.enums;

import java.util.*;

public enum Permission {
    /** Staff Module Root */
    STAFF("STAFF"),

    /** Profile */
    STAFF_PROFILE("STAFF:PROFILE"),
    STAFF_PROFILE_READ("STAFF:PROFILE:READ"),
    STAFF_PROFILE_WRITE("STAFF:PROFILE:WRITE"),
    STAFF_PROFILE_MODIFY("STAFF:PROFILE:MODIFY"),
    STAFF_PROFILE_DELETE("STAFF:PROFILE:DELETE");

    private final String path;
    Permission(String path) { this.path = path; }
    public String path() { return path; }

    private static final Map<Permission, List<Permission>> hierarchy = new HashMap<>();
    private static final Map<Permission, List<Permission>> implications = new HashMap<>();

    static {
        // Initialize all permissions in maps
        for (Permission p : values()) {
            hierarchy.put(p, new ArrayList<>());
            implications.put(p, new ArrayList<>());
        }

        hierarchy.get(STAFF).add(STAFF_PROFILE);
        hierarchy.get(STAFF_PROFILE).add(STAFF_PROFILE_READ);
        hierarchy.get(STAFF_PROFILE).add(STAFF_PROFILE_WRITE);
        hierarchy.get(STAFF_PROFILE).add(STAFF_PROFILE_MODIFY);
        hierarchy.get(STAFF_PROFILE).add(STAFF_PROFILE_DELETE);
    }

    public static Set<Permission> getAllDerivedPermissions(Collection<Permission> perms) {
        Set<Permission> result = new LinkedHashSet<>();
        perms.forEach(p -> traverse(p, result));
        return result;
    }

    private static void traverse(Permission p, Set<Permission> seen) {
        if (!seen.add(p)) return;
        hierarchy.get(p).forEach(c -> traverse(c, seen));
        implications.get(p).forEach(c -> traverse(c, seen));
    }
}
