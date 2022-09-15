package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.ApiModel;
import com.example.model.ArchModel;

public interface ApiRepo extends CrudRepository <ArchModel, Integer> {

}
