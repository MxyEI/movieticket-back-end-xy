package com.awesometickets.web.controller.response;

import java.util.LinkedHashMap;

/**
 * 响应（Response of RESTFul API.）
 */
public class RestResponse extends LinkedHashMap<String, Object> {

    public RestResponse() {
        super();
    }

    public RestResponse(LinkedHashMap<String, Object> m) {
        super(m);
    }

}
