package com.anderson.automation.webboka.infra;

import org.springframework.data.repository.CrudRepository;

import com.anderson.automation.webboka.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
