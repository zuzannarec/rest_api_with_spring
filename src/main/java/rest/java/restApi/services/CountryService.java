package rest.java.restApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import rest.java.restApi.model.RestResponse;
import rest.java.restApi.model.RootObject;

import java.util.Locale;

@Service
public class CountryService {
    private static final String COUNTRY_CODE_URL = "http://services.groupkt.com/country/get/iso2code/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MessageSource messageSource;


    public RestResponse getCountryFromRestApi(final String code){
        ResponseEntity<RootObject> rootObjectEntity = getDataFromApi(code);
        if(rootObjectEntity.getStatusCode().is2xxSuccessful()) {
            RestResponse response = rootObjectEntity.getBody().
                    getRestResponse();
            response.setSayHello(messageSource.
                    getMessage("say.hello", null, Locale.forLanguageTag(code)));
            return response;
        }
        return null;
    }

    private ResponseEntity<RootObject> getDataFromApi(final String code){
        return restTemplate.
                getForEntity(UriComponentsBuilder.
                        fromHttpUrl(COUNTRY_CODE_URL+code).build().toUri(),
                        RootObject.class);
    }

}
