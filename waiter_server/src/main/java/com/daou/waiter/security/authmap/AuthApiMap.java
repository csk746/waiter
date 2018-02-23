/**
 *
 */
package com.daou.waiter.security.authmap;

import com.daou.waiter.user.domain.AuthorityType;

import lombok.Getter;

/**
 * Create by hsim on 2018. 1. 26.
 */
@Getter
public enum AuthApiMap {

    PRODUCT("product", AuthorityType.getAllGradeBit()),
    PRODUCT_LIST("product/list", AuthorityType.CLIENT.getBit() | AuthorityType.ADMIN.getBit());

    String uri;
    int accessType;

    private AuthApiMap(String uri, int accessType) {
        this.uri = uri;
        this.accessType = accessType;
    }


}
