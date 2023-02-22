package com.jdar.store.providers.dataprovider.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CITIES")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CITY_ID", columnDefinition = "uuid")
    private UUID id;

    @Column(name = "CITY_NAME", nullable = false)
    private String cityName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "STATE_ID", nullable = false)
    private StateEntity state;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProviderEntity> providersList;

}