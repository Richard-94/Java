package com.epicode.menupizza.repositories;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.menupizza.model.MainPizza;

public interface RepositoryMenu extends CrudRepository<MainPizza, Long> {

}
