package com.jsalaza.springboot.servicio.vacunacion.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	@JsonIgnore
	private String user;

	@JsonIgnore
	private String pass;

	private String token;
	private Collection role;
	private Integer idEmpleado;


}
