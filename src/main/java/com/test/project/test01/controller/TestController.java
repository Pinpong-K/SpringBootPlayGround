package com.test.project.test01.controller;


import com.sun.org.apache.xpath.internal.objects.XNull;
import com.test.project.test01.AddDto;
import com.test.project.test01.TestReadConfiguration;
import com.test.project.test01.dto.CompanyDto;
import com.test.project.test01.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RequestMapping(path = "/api")
@RestController
public class TestController {
	
	@Autowired
	private TestReadConfiguration testRead;

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
    public AddDto addMethod(@RequestBody AddDto req) {
		return new AddDto.Builder()
				.setA(req.getA())
				.build();

	}

	@PostMapping(path = "/company", produces = MediaType.APPLICATION_JSON_VALUE)
	public CompanyDto addMethod(@RequestBody CompanyDto req) {
		return companyService.createCompany(req);

	}


	@GetMapping(path = "/company/{id}")
	public  CompanyDto findCompany(@RequestParam Long id) {
		return  companyService.getCompanyById(id);

	}

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
