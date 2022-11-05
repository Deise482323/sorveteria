package com.br.sorveteria.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SorveteResponse {

    private String sorveteMassa;
    private String sorvetePalito;
}
