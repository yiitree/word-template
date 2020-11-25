package com.zr.worddemo.domain;

import lombok.Data;

import java.util.List;

@Data
public class PaymentHackData {

    private String subtotal;
//    private String tax;
//    private String transform;
//    private String other;
//    private String unpay;

    // 总计
    private String total;

    private List<Goods> goods;
    private List<Labor> labors;

//    private List<Goods> goods2;
//    private List<Labor> labors2;

}
