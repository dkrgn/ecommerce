package com.ecom.dto.category;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryRequest {

    private Integer id;
    private String name;
    private String description;
}
