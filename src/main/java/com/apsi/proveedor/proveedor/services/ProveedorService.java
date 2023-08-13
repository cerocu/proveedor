package com.apsi.proveedor.proveedor.services;

import com.apsi.proveedor.proveedor.config.FileConection;

import com.apsi.proveedor.proveedor.model.ProveedorModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProveedorService {

    FileConection fileConection=FileConection.getInstance();

    public  List<ProveedorModel> readProveedor() throws URISyntaxException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ProveedorModel[] proveedorArrays = objectMapper.readValue(fileConection.fileConection(),ProveedorModel[].class);
        List<ProveedorModel> proveedors= Arrays.asList(proveedorArrays);

        return proveedors;
    }
    public void addProveedor(ProveedorModel proveedor) throws URISyntaxException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ProveedorModel> array=new ArrayList<>();
        array.addAll(readProveedor());
        if(!exist(array,proveedor))
          array.add(proveedor);
        objectMapper.writeValue(fileConection.fileConection(), array);

    }

    public void deleteProveedor(ProveedorModel proveedor) throws URISyntaxException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ProveedorModel> array=new ArrayList<>();
        array.addAll(readProveedor());
        if(exist(array,proveedor))
            array.remove(index(array,proveedor));
        objectMapper.writeValue(fileConection.fileConection(), array);

    }

    public boolean  exist(List<ProveedorModel> array,ProveedorModel proveedor){
       return array.stream()
                .filter(x -> x.getName().equals(proveedor.getName())).count()>0;
    }
    public ProveedorModel  index(List<ProveedorModel> array,ProveedorModel proveedor){
        return array.stream()
                .filter(x -> x.getName().equals(proveedor.getName())).findFirst().get();
    }
}
