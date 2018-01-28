package com.dorel.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import com.dorel.model.Applicationlog;

public class UserSpecificationsBuilder {
	private final List<SearchCriteria> params;
	 
    public UserSpecificationsBuilder() {
        params = new ArrayList<SearchCriteria>();
    }
 
    public UserSpecificationsBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }
 
    public Specification<Applicationlog> build() {
        if (params.size() == 0) {
            return null;
        }
 
        List<Specification<Applicationlog>> specs = new ArrayList<Specification<Applicationlog>>();
        for (SearchCriteria param : params) {
            specs.add(new UserSpecification(param));
        }
 
        Specification<Applicationlog> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specifications.where(result).and(specs.get(i));
        }
        return result;
    }
}
