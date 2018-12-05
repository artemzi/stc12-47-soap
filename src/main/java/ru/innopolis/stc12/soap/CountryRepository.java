package ru.innopolis.stc12.soap;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

public class CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void init() {
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(150_000_000);

        countries.put(spain.getName(), spain);

        Country russia = new Country();
        russia.setName("Russia");
        russia.setCapital("Moscow");
        russia.setCurrency(Currency.RUB);
        russia.setPopulation(150_000_000);

        countries.put(russia.getName(), russia);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.EUR);
        poland.setPopulation(90_000_000);

        countries.put(poland.getName(), poland);
    }

    public Country getCountry(String name) {
        return countries.get(name);
    }
}
