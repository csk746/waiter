/**
 *
 */
package com.daou.waiter.model;

import com.daou.waiter.constants.Constants;
import lombok.Getter;
import lombok.Setter;

/**
 * Create by hsim on 2017. 10. 20.
 */

@Getter
@Setter
public class PageModel {

    private int size = Constants.DEFAULT_LIST_SIZE;
    private int page = Constants.DEFAULT_PAGE;
    private String field = "createdAt";
    private String order = "desc";

    public void setOffset(int offset) {
        this.size = offset;
    }

    public void setOffSet(int offset) {
        this.size = offset;
    }
}
