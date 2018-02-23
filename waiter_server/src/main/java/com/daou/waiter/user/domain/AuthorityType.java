/**
 *
 */
package com.daou.waiter.user.domain;

import com.daou.waiter.security.account.AccountUserDetails;

/**
 * Create by hsim on 2018. 1. 26.
 */
public enum AuthorityType {


    CLIENT(1), MANAGER(2), CEO(3), ADMIN(4), SUPER_ADMIN(5), DEVELOPER(10);

    int grade;

    private AuthorityType(int grade) {
        this.grade = grade;
    }

    public int getBit() {
        return 1 << (this.grade - 1);
    }

    public boolean isHavedGrade(int grade) {
        return (this.getBit() & grade) > 0;
    }

    public boolean isHavedGrade(User user) {
        return this.isHavedGrade(user.grade);
    }

    public boolean isHavedGrade(AccountUserDetails userDetail) {
        return this.isHavedGrade(userDetail.getUser());
    }

    public static int getAllGradeBit() {
        AuthorityType[] types = AuthorityType.values();
        int bit = 0;
        for (AuthorityType type : types) {
            bit |= type.getBit();
        }
        return bit;
    }

}
