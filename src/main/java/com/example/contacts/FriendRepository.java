package com.example.contacts;

import org.springframework.data.repository.CrudRepository;

public interface FriendRepository extends CrudRepository<Friend
        , Integer> {
}
