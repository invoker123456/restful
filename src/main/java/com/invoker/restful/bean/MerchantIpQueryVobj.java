package com.invoker.restful.bean;

import lombok.Data;

/**
 * Created by invoker on 2019-08-06
 * Description:
 */
@Data
public class MerchantIpQueryVobj {
    private String merchantId;
    private String merchantIp;
    private String merchantIpList;
    private float money;
}
