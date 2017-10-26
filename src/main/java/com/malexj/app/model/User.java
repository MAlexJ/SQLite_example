package com.malexj.app.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(exclude = {"userId"})
public class User {

	@NonNull
	private long userId;

	private String fullName;

	private String email;

	private String password;

}