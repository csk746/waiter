package com.daou.waiter.wait;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaitRepository extends JpaRepository<Wait,Long>{

    public Wait findFirstByOrderByIdDesc();

}
