package com.aamir.rating.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginationDTO {

    private int offset;
    private int pageNumber;
}
