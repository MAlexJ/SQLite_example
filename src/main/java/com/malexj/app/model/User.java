package com.malexj.app.model;

import lombok.*;


@ToString
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"userId"})
public class User {

	@Getter
	@Setter
	private long userId;

	@Getter
	@Setter
	private String fullName;

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private String password;
}