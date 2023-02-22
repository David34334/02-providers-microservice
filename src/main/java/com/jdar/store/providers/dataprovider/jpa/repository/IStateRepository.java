package com.jdar.store.providers.dataprovider.jpa.repository;

import com.jdar.store.providers.dataprovider.jpa.entity.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IStateRepository extends JpaRepository<StateEntity, UUID> {
}
