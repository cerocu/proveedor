package com.apsi.proveedor.proveedor.controllers;

import com.apsi.proveedor.proveedor.config.FileConection;
import com.apsi.proveedor.proveedor.constants.ConstantProveedor;
import com.apsi.proveedor.proveedor.model.ProveedorModel;
import com.apsi.proveedor.proveedor.response.ProveedorResponse;
import com.apsi.proveedor.proveedor.services.ProveedorService;
import com.sun.webkit.dom.CSSPageRuleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/proveedor/")
public class ProveedorController {
	
 @Autowired
 private ProveedorService proveedorService;
 //DineroServiceImplement DineroServicio;
    @CrossOrigin(origins = "*")
	@GetMapping("")
	public ResponseEntity<ProveedorResponse> getProveedor(@RequestHeader int page, @RequestHeader int pageSize) throws URISyntaxException, IOException {

		FileConection.getInstance().fileConection();
		List<ProveedorModel> proveedorModels= proveedorService.readProveedor();
		int currentPage = page;
		int startIndex = (currentPage - 1) * pageSize;
		int endIndex = Math.min(startIndex + pageSize, proveedorModels.size());
		List<ProveedorModel> itemsOnPage= new ArrayList<ProveedorModel>();
		ProveedorResponse response= new ProveedorResponse();
		try {
			 itemsOnPage = proveedorModels.subList(startIndex, endIndex);
			response.setData(itemsOnPage);
			response.setPage(page);
			response.setStatus(ConstantProveedor.SUCCESSFUL);
			response.setCode(200);
		}
		catch (Exception e){
			System.out.println("Error datos no encontrados");

			response.setData(itemsOnPage);
			response.setPage(page);
			response.setStatus(ConstantProveedor.SUCCESSFUL);
			response.setCode(404);

		}

		return new ResponseEntity<ProveedorResponse>(response, HttpStatus.OK);


	}
	@CrossOrigin(origins = "*")
	@PostMapping("")
	public ResponseEntity<ProveedorResponse>  solicitar(@RequestBody ProveedorModel proveedor) throws IOException, URISyntaxException {

		System.out.println("recurso");
		proveedorService.addProveedor(proveedor);
		return null;
		//return new ResponseEntity<List<DineroEntity>>(lista, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@DeleteMapping
	public ResponseEntity<ProveedorResponse>  deleteProveedor(@RequestBody ProveedorModel proveedor) throws IOException, URISyntaxException {

		System.out.println("recurso");
		proveedorService.deleteProveedor(proveedor);
		return null;
		//return new ResponseEntity<List<DineroEntity>>(lista, HttpStatus.OK);
	}





}
