package com.example.contacts;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact,
        Integer> {

}
