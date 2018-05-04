package com.awesometickets.web.controller.response;

import java.util.ArrayList;
import java.util.Collection;


/**
 *  响应处理（Collection response of RESTFul API.）
 */
public class CollectionResponse extends RestResponse {

    public <T> CollectionResponse() {
        this(new ArrayList<T>());
    }

    public <T> CollectionResponse(Collection<T> data) {
        put("count", data.size());
        put("data", data);
    }

}
