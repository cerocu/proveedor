package com.apsi.proveedor.proveedor.config;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.net.URISyntaxException;
import java.net.URL;
import java.io.*;

import java.nio.file.Path;
public class FileConection {

    private static FileConection fileConection;
    private static final String JSON_FILE_PATH = "bd.json";

    private FileConection(){

    }

    public static FileConection getInstance(){
        if(fileConection==null)
            fileConection=new FileConection();
        return fileConection;
    }
    public File fileConection() throws IllegalArgumentException, URISyntaxException {
        ClassLoader cargador = getClass().getClassLoader();
        System.out.println("llega");
        URL resource = cargador.getResource("bd.json");
        System.out.println("llega2");
        if (resource == null) {
            throw new IllegalArgumentException("fichero no encontrado"
                    + "bd.json");
        } else {
            return new File(resource.toURI());
        }
       // ObjectMapper objectMapper = new ObjectMapper();

    }
    public void addResource()throws IOException{

    }


}
