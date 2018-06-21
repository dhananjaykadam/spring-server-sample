package org.server.security.enums.permissions;

public enum PermissionType {
	CREATE("CREATE"), UPDATE("UPDATE"), DELETE("DELETE"), READ("READ"),OTHER("OTHER");
	String value;

	PermissionType(String permission) {
		this.value = permission;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
