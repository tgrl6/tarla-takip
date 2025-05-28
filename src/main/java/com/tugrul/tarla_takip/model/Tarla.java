package com.tugrul.tarla_takip.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urun;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate ekimTarihi;

    @ManyToOne
    @JoinColumn(name = "ciftci_id")
    private Ciftci ciftci;
}
