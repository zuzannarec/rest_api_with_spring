package rest.java.restApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import rest.java.restApi.services.CountryService;
import rest.java.restApi.model.RestResponse;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/country/{code}")
    public RestResponse getCountryCode(@PathVariable() String code) {
        return countryService.getCountryFromRestApi(code);
    }
}
