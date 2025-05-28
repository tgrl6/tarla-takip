package com.tugrul.tarla_takip.controller;

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
    public List<Ciftci> getAll() {
        return ciftciRepository.findAll();
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
