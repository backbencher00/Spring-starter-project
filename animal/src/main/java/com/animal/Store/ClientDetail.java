package com.animal.Store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ClientDetail {
	@Id
	@GeneratedValue
	private int id;
	private String ipAddress;
	private String animalFact;
	private String accessDate;

}
