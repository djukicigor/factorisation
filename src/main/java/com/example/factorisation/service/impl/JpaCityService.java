package com.example.factorisation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.factorisation.model.City;
import com.example.factorisation.repository.CityRepository;
import com.example.factorisation.service.CityService;

@Transactional
@Service
public class JpaCityService implements CityService {

	@Autowired
	private CityRepository cityRepository;

	public City findOne(Long id) {
		return cityRepository.findOne(id);
	}
	
	@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}

	@Override
	public City save(City city) {
		return cityRepository.save(city);
	}

	@Override
	public List<City> save(List<City> cities) {
		return cityRepository.save(cities);
	}

	@Override
	public City delete(Long id) {
		City city = cityRepository.findOne(id);
		if(city == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant city");
		}
		cityRepository.delete(city);
		return city;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}

}
