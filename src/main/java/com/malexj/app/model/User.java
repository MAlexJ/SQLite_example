package com.malexj.app.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"userId"})
public class User {

	private long userId;
	private String fullName;
	private String email;
	private String password;
}