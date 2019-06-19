package com.sales.exceptions;

import com.sales.models.SaveResult;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.stereotype.Controller;

@Controller
public class CustomErrorController implements ErrorController {


    @GetMapping(value = "/error")
    @ResponseStatus(HttpStatus.OK)
    public SaveResult handleError() {

        //this method will be called whenever a wrong url is accessed.
        SaveResult response = new SaveResult();
        response.setSaved(false);
        response.setErrorMsg("Some server error occured");
        return response;
    }

    @Override
    public String getErrorPath() {
        return "";
    }
}