package com.tugrul.tarla_takip.dto;

import lombok.Data;


    @Data
    public class TarlaDTO{
        private Long id;
        private String urun;
        private  String ekimTarihi;
        private CiftciDTO ciftci;
    }

