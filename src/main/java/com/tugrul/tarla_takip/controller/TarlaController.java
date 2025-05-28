package com.tugrul.tarla_takip.controller;

import com.tugrul.tarla_takip.dto.CiftciDTO;
import com.tugrul.tarla_takip.dto.TarlaDTO;
import com.tugrul.tarla_takip.model.Tarla;
import com.tugrul.tarla_takip.repository.TarlaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarlalar")
@RequiredArgsConstructor
public class TarlaController {

    private final TarlaRepository tarlaRepository;

    @PostMapping
    public Tarla create(@RequestBody Tarla tarla) {
        return tarlaRepository.save(tarla);
    }

    @GetMapping("/{id}")
    public Tarla getById(@PathVariable Long id) {
        return tarlaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarla bulunamadı"));
    }
    @GetMapping
    public List<TarlaDTO> getAll() {
        return tarlaRepository.findAll().stream().map(tarla -> {
            TarlaDTO dto = new TarlaDTO();
            dto.setId(tarla.getId());
            dto.setUrun(tarla.getUrun());
            dto.setEkimTarihi(tarla.getEkimTarihi().toString());

            CiftciDTO ciftciDTO = new CiftciDTO();
            ciftciDTO.setId(tarla.getCiftci().getId());
            ciftciDTO.setIsim(tarla.getCiftci().getIsim());

            dto.setCiftci(ciftciDTO);
            return dto;
        }).toList();
    }

}
