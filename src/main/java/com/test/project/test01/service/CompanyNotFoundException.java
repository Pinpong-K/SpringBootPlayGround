package com.test.project.test01.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Not Found Company")
public class CompanyNotFoundException extends  RuntimeException
{


}
