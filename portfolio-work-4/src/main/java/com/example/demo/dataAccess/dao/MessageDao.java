package com.example.demo.dataAccess.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.Message;

public interface MessageDao extends JpaRepository<Message,String> {

}
