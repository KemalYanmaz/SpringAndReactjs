package com.example.demo.business.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.CountryService;
import com.example.demo.dataAccess.abstracts.CountryDao;
import com.example.demo.dataAccess.concretes.CountryDto;
import com.example.demo.entities.concretes.Country;

@Service
public class CountryManager implements CountryService{
	
	private CountryDao countryDao;

	public CountryManager(CountryDao countryDao) {
		this.countryDao = countryDao;

	}

	@Override
	public List<CountryDto> findByCapitalLike(String capital) {
		Map<Long,CountryDto> countryMap = new HashMap<>();
		countryDao.findByCapitalStartingWithIgnoreCase(capital).forEach(country->{
			countryMap.put(country.getId(),countryToDto(country));
		});
		List<CountryDto> countryDtoList = new ArrayList<>();
		for(long id :countryMap.keySet()) {
			countryDtoList.add(countryMap.get(id));
		}
		return countryDtoList;
	}

	
	private CountryDto countryToDto(Country country) {
		CountryDto countryDto = new CountryDto();
		countryDto.setId(country.getId());
		countryDto.setCapital(country.getCapital());
		countryDto.setFlag(country.getFlag());
		countryDto.setName(country.getName());
		countryDto.setRegion(country.getRegion());
		return countryDto;
	}

	@Override
	public void add(Country country) {
		countryDao.save(country);
	}

	@Override
	public void addAll(List<Country> countries) {
		countryDao.saveAll(countries);
		
	}

	@Override
	public List<CountryDto> getAll(String text) {
		SearchSpecification spec1,spec2,spec3,spec4,spec5,spec6,spec7,spec8;
		spec1 = new SearchSpecification(new SearchCriteria("alpha2Code", ":", text));
		spec2 = new SearchSpecification(new SearchCriteria("alpha3Code", ":", text));
		spec3 = new SearchSpecification(new SearchCriteria("cioc", ":", text));
		spec4 = new SearchSpecification(new SearchCriteria("capital", ":", text));
		spec5 = new SearchSpecification(new SearchCriteria("name", ":", text));
		spec6 = new SearchSpecification(new SearchCriteria("nativeName", ":", text));
		spec7 = new SearchSpecification(new SearchCriteria("region", ":", text));
		spec8 = new SearchSpecification(new SearchCriteria("subregion", ":", text));

		Map<Long,CountryDto> countryMap = new HashMap<>();
		countryDao.findAll(Specification.where(spec1).or(spec2).or(spec3).or(spec4).or(spec5).or(spec6).or(spec7).or(spec8)).forEach(country->{
			countryMap.put(country.getId(),countryToDto(country));
		});
		List<CountryDto> countryDtoList = new ArrayList<>();
		for(long id :countryMap.keySet()) {
			countryDtoList.add(countryMap.get(id));
		}
		return countryDtoList;
	}
	
	class SearchSpecification implements Specification<Country> {

	    private SearchCriteria criteria;

	    private SearchSpecification(SearchCriteria criteria){
	        this.criteria =criteria;
	    }

	    @Override
	    public Predicate toPredicate
	      (Root<Country> root, CriteriaQuery<?> query, CriteriaBuilder builder) {


	        if (criteria.getOperation().equalsIgnoreCase(":")) {
	            if (root.get(criteria.getColumn()).getJavaType() == String.class) {
	                return builder.like(
	                  builder.upper(root.<String>get(criteria.getColumn())), "%" + criteria.getValue().toString().toUpperCase() + "%");
	            } 
	        }
	        return null;
	    }
	}
	class SearchCriteria {
	    private String column;
	    private String operation;
	    private Object value;
	    
		public SearchCriteria(String string, String string2, String string3) {
			this.column = string;
			this.operation = string2;
			this.value = string3;
		}
		public String getColumn() {
			return column;
		}
		public void setColumn(String column) {
			this.column = column;
		}
		public String getOperation() {
			return operation;
		}
		public void setOperation(String operation) {
			this.operation = operation;
		}
		public Object getValue() {
			return value;
		}
		public void setValue(Object value) {
			this.value = value;
		}
	    
	    
	}
	
	
}
