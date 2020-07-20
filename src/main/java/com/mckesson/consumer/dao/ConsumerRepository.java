package com.mckesson.consumer.dao;

import com.mckesson.consumer.bean.ConsumerBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends CrudRepository<ConsumerBean, Long>{

}
