package com.jdar.store.providers.dataprovider.jpa.repository;

import com.jdar.store.providers.dataprovider.jpa.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IProviderRepository extends JpaRepository<ProviderEntity, UUID> {
}
