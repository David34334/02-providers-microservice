package com.jdar.store.providers.dataprovider.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "STATES")
public class StateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STATE_ID", columnDefinition = "uuid")
    private UUID id;

    @Column(name = "STATE_NAME", nullable = false)
    private String stateName;

}
