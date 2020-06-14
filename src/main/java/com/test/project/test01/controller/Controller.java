package com.test.project.test01.controller;


import com.sun.org.apache.xpath.internal.objects.XNull;
import com.test.project.test01.AddDto;
import com.test.project.test01.TestReadConfiguration;
import com.test.project.test01.dto.CompanyDto;
import com.test.project.test01.dto.PersonDto;
import com.test.project.test01.service.CompanyNotFoundException;
import com.test.project.test01.service.CompanyService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RequestMapping(path = "/api")
@RestController
public class Controller {
	
	@Autowired
	private CompanyService companyService;

	
	@GetMapping(path = "/{a}/divide", produces = MediaType.APPLICATION_JSON_VALUE)
    public AddDto divideMethod(
            @PathVariable Double a,
            @RequestParam(name = "baba") String b,
            @RequestParam(required = false) String c
    ) {
       // return testRead.getConfig();
		//return String.format("a : %s b : %s c : %s",a,b,c );
		return new AddDto.Builder().setA(a).build();
	}
	
	@PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public AddDto createCompany(@RequestBody AddDto req) {
		return new AddDto.Builder()
				.setA(req.getA())
				.build();

	}

	@PostMapping(path = "/company", produces = MediaType.APPLICATION_JSON_VALUE)
	public CompanyDto createCompany(@RequestBody CompanyDto req) throws Exception {
		return companyService.createCompany(req);

	}


	@GetMapping(path = "/company/{name}")
	public CompanyDto findCompany(@PathVariable String name)
	{
		CompanyDto foundCompany = companyService.getCompanyByName(name);
		if(foundCompany == null)
			throw  new CompanyNotFoundException();

		return foundCompany;


	}


	/*
	@GetMapping(path = "/company/{id}")
	public  CompanyDto findCompany(@PathVariable Long id) {
		return  companyService.getCompanyById(id);

	}

	@GetMapping(path = "/company")
	public List<CompanyDto> findCompanyContainName(@RequestParam(name = "name") String name){
		return  companyService.getCompanyByNameContaining(name);


	}
	*/


        /*
	@DeleteMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public AddDto addMethod(@RequestBody AddDto req) {
        return new  AddDto.Builder()
                .setA(req.getA())
                .build();

         */
        
        
       // return new  AddDto.Builder().
        //        .setA(String.format("%s + %s", req.getA(), req.getB()))
       //         .result(String.valueOf(req.getA() + req.getB()))
       //         .build();

	
	
}
