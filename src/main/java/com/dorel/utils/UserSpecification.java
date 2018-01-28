package com.dorel.utils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.dorel.model.Applicationlog;

public class UserSpecification implements Specification<Applicationlog> {

		private SearchCriteria criteria;

		public UserSpecification(SearchCriteria param) {
			this.criteria = param;
		}


	public Predicate toPredicate(Root<Applicationlog> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
	
	if (criteria.getOperation().equalsIgnoreCase(">")) {
		return builder.greaterThanOrEqualTo(
				root.<String> get(criteria.getKey()), criteria.getValue().toString());
	}else if (criteria.getOperation().equalsIgnoreCase("<")) {
		return builder.lessThanOrEqualTo(
				root.<String> get(criteria.getKey()), criteria.getValue().toString());
	 }
	else if (criteria.getOperation().equalsIgnoreCase(":")) {
		if (root.get(criteria.getKey()).getJavaType() == String.class) {
			
			return builder.like(builder.coalesce((builder.lower(root.<String>get(criteria.getKey()))),""), "%" + criteria.getValue() + "%");
		} else {
			return builder.equal(builder.coalesce(root.get(criteria.getKey()),""), criteria.getValue());
		}
	}
		return null;
	}

	
}
