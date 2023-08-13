package com.apsi.proveedor.proveedor.response;

import com.apsi.proveedor.proveedor.model.ProveedorModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ProveedorResponse {
    private List<ProveedorModel> data;
    private Integer page;
    private String status;
    private Integer code;
}
