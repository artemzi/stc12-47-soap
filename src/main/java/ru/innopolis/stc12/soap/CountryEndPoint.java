package ru.innopolis.stc12.soap;

import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

public class CountryEndPoint {
    private static final String URL = "http://spring.io/guides/gs-producing-web-service";

    private CountryRepository repository;

    @Autowired
    public CountryEndPoint(CountryRepository repository) {
        this.repository = repository;
    }

    @PayloadRoot(namespace = URL, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest getCountryRequest) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(repository.getCountry(getCountryRequest.getName()));
        return response;
    }
}
