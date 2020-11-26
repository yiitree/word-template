package com.zr.worddemo.domain;

import lombok.Data;

import java.util.List;

@Data
public class PaymentHackData {

    private String subtotal;

    // 一些通用数据
//    private String tax;
//    private String transform;
//    private String other;
//    private String unpay;

    // 总计
    private String total;

    // 表格内数据
    private List<Goods> goods;
    private List<Labor> labors;

}
