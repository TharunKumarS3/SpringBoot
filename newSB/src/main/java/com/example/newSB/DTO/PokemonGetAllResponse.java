package com.example.newSB.DTO;

import lombok.Data;

import java.util.List;
@Data
public class PokemonGetAllResponse {

    private List<PokemonDTO> data;
    private int pageNo;
    private int pageSize;

    private  long totalElements;
    private int totalPages;
    private boolean last;

}
