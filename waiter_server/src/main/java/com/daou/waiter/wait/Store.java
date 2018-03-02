package com.daou.waiter.wait;

import com.daou.waiter.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Store extends BaseEntity{
    String name;
    int waitCount;
}
