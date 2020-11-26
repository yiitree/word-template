package com.zr.worddemo;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;
import com.zr.worddemo.domain.Goods;
import com.zr.worddemo.domain.Labor;
import com.zr.worddemo.domain.PaymentHackData;
import com.zr.worddemo.util.WordUtils;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@DisplayName("Example for HackLoop Table")
public class HackLoopTableRenderPolicyTest {

    String inPutDir = "src/main/resources/template/table-template.docx";
//    String inPutDir = "E:/word/table-template.docx";
    String outPutDir = "E:/word/table-template-ok.docx";
    String outPutDir1 = "E:/word/table-template-ok1.docx";

    PaymentHackData data = new PaymentHackData();

    @BeforeEach
    public void init() {
        List<Goods> goods = new ArrayList<>();
        Goods good = new Goods();
        good.setCount(4);
        good.setName("墙纸");
        good.setDesc("书房卧室");
        good.setDiscount(1500);
        good.setPrice(400);
        good.setTax(new Random().nextInt(10) + 20);
        good.setTotalPrice(1600);
        good.setPicture(null);
        goods.add(good);
        goods.add(good);
        goods.add(good);
        data.setGoods(goods);

        List<Labor> labors = new ArrayList<>();
        Labor labor = new Labor();
        labor.setCategory("油漆工");
        labor.setPeople(2);
        labor.setPrice(400);
        labor.setTotalPrice(1600);
        labors.add(labor);
        labors.add(labor);
        labors.add(labor);
        data.setLabors(labors);

        // 表外的综合数据
        data.setTotal("1024");
        data.setSubtotal("xxxxx");

    }

    @Test
    public void testPaymentHackExample() throws Exception {
        HackLoopTableRenderPolicy hackLoopTableRenderPolicy = new HackLoopTableRenderPolicy();
        Configure config = Configure.newBuilder()
                .bind("goods", hackLoopTableRenderPolicy)
                .bind("labors", hackLoopTableRenderPolicy)
                .build();
        XWPFTemplate template = XWPFTemplate.compile(inPutDir, config).render(data);
        template.writeToFile(outPutDir);

        // 在读取一遍，生成目录(其实就是设置域，应该可以实现在模板中设置好)
        XWPFDocument doc = new XWPFDocument(POIXMLDocument.openPackage(outPutDir));
        WordUtils.generateToc(doc);
        OutputStream out = new FileOutputStream(outPutDir1);
        doc.write(out);
        out.flush();
        out.close();

    }

}
