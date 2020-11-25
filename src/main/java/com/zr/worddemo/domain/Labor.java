package com.zr.worddemo.domain;

import lombok.Data;

/**
 * 人工费
 * @Author: 曾睿
 * @Date: 2020/11/25 16:31
 */
@Data
public class Labor {

    // 种类
    private String category;
    // 人数
    private int people;
    // 单价
    private int price;
    // 总计
    private int totalPrice;

}
