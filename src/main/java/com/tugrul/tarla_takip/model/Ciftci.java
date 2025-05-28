package com.tugrul.tarla_takip.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ciftci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isim;

    @OneToMany(mappedBy = "ciftci", cascade = CascadeType.ALL)
    private List<Tarla> tarlalar;
}
