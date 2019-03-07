package com.mx.service.ServiciosRestFull.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mx.service.ServiciosRestFull.bean.City;
@Service
public class CityService implements ICityService  
{

	@Override
	public List<City> findAll() 
	{
		City ciudad1 =  new City(1l,"Ciudad de México",1200);
		City ciudad2 =  new City(2l,"Cancun",1300);
		City ciudad3 =  new City(3l,"Monterrey",1400);
		List<City> lista =  new ArrayList<City>();
		lista.add(ciudad1);
		lista.add(ciudad2);
		lista.add(ciudad3);
		return lista;
	}
}