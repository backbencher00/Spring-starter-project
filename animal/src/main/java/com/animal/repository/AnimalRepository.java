package com.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.animal.Store.ClientDetail;

public interface AnimalRepository extends JpaRepository<ClientDetail, Integer>{

}
