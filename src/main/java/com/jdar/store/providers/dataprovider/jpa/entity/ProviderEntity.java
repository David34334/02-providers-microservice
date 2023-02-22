package com.jdar.store.providers.dataprovider.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PROVIDERS")
public class ProviderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROVIDER_ID", columnDefinition = "uuid")
    private UUID id;

    @Column(name = "PROVIDER_NAME", nullable = false)
    private String providerName;

    @Column(name = "PROVIDER_EMAIL", nullable = false)
    private String providerEmail;

    @Column(name = "PROVIDER_ADDRESS", nullable = false)
    private String providerAddress;

    @Column(name = "CREATE_DATE", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "UPDATED_DATE", nullable = false)
    private LocalDateTime updatedDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID", nullable = false)
    private CityEntity city;

}
