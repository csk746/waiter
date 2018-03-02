package com.daou.waiter.wait;

import com.daou.waiter.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Wait extends BaseEntity{
    @ManyToOne
    Store store;
    String phoneNumber;
}
