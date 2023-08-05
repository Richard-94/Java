package com.epicode.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.api.model.Contacts;

public interface ContactsDaoRepository extends CrudRepository<Contacts, Long> {

}
