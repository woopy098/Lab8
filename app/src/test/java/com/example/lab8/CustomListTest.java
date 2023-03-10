package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity(){
        list = MockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city);
        assertEquals(true,list.hasCity(city));
    }

    @Test
    void testDeleteCity() {
        list = MockCityList();
        assertEquals(0, list.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);

        assertEquals(1, list.getCities().size());
        list.deleteCity(city);
        assertEquals(0, list.getCities().size());
    }
    @Test
    void testcountCities(){
        list = MockCityList();
        assertEquals(1, list.getCount());
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        assertEquals(2, list.getCount());
        list.deleteCity(city);
        assertEquals(1, list.getCount());
    }
}
