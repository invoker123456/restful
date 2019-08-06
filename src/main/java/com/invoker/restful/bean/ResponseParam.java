package com.invoker.restful.bean;

import lombok.Data;

/**
 * Created by invoker on 2019-08-06
 * Description:
 */
@Data
public class ResponseParam {
    private String status;
    private Object data;
    private String returnCode;
}
