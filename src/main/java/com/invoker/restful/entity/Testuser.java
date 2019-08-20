package com.invoker.restful.entity;

import lombok.Data;

@Data//使用lombok简化代码，自动在编译的时候生成setter,getter方法
public class Testuser {
    //创建实体类，注意属性名要和数据库中的字段名保持一致

    private Integer id;
    private String name;
    private String sex;

}
