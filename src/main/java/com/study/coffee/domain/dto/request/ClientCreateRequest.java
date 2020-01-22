package com.study.coffee.domain.dto.request;
import javax.validation.constraints.NotEmpty;

import com.study.coffee.domain.validators.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientCreateRequest {

    @NotEmpty(message = "O atributo name é obrigatório")
    private String name;

    @NotEmpty(message = "O atributo phone é obrigatório")
    @Phone(message = "phone is invalid")
    private String phone;

}