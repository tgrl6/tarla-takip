package com.tugrul.tarla_takip.controller;

import com.tugrul.tarla_takip.dto.CiftciDTO;
import com.tugrul.tarla_takip.model.Ciftci;
import com.tugrul.tarla_takip.repository.CiftciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ciftciler")
@RequiredArgsConstructor
public class CiftciController {

    private final CiftciRepository ciftciRepository;

    @GetMapping
    public List<CiftciDTO> getAll() {
        return ciftciRepository.findAll().stream().map(c -> {
            CiftciDTO dto = new CiftciDTO();
            dto.setId(c.getId());
            dto.setIsim(c.getIsim());
            return dto;
        }).toList();
    }

    @PostMapping
    public Ciftci create(@RequestBody Ciftci ciftci) {
        return ciftciRepository.save(ciftci);
    }

    @GetMapping("/{id}")
    public Ciftci getById(@PathVariable Long id) {
        return ciftciRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Çiftçi bulunamadı"));
    }
}
