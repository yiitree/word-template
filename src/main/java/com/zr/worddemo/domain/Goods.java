package com.zr.worddemo.domain;

import com.deepoove.poi.data.PictureRenderData;
import lombok.Data;

/**
 * 货物明细
 * @Author: 曾睿
 * @Date: 2020/11/25 16:31
 */
@Data
public class Goods {

    // 数量
    private int count;
    // 货物名称
    private String name;
    // 货物简介
    private String desc;
    // 折扣
    private int discount;
    // 应纳税
    private int tax;
    // 单价
    private int price;
    // 总计
    private int totalPrice;
    // 照片
    private PictureRenderData picture;

}
