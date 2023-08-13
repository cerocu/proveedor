package com.apsi.proveedor.proveedor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorModel {
    @JsonProperty("name")
    private String name;
    @JsonProperty("businessName")
    private String businessName;
    @JsonProperty("direction")
    private String direction;
    @JsonProperty("enabled")
    private Boolean enabled;

    @Override
    public String toString() {
        return "ProveedorModel{" +
                "name='" + name + '\'' +
                ", businessName='" + businessName + '\'' +
                ", direction='" + direction + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
