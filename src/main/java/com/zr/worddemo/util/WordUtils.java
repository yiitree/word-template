package com.zr.worddemo.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;

/**
 * @Author: 曾睿
 * @Date: 2020/11/25 19:41
 */
public class WordUtils {

    public static void generateToc(XWPFDocument document) {
        String findText = "toc";
        String replaceText = "";
        for (XWPFParagraph p : document.getParagraphs()) {
            for (XWPFRun r : p.getRuns()) {
                int pos = r.getTextPosition();
                String text = r.getText(pos);
                if (text != null && text.contains(findText)) {
                    text = text.replace(findText, replaceText);
                    r.setText(text, 0);
                    addField(p, "TOC \\o \"1-3\" \\h \\z \\u");
//                    addField(p, "TOC \\h");
                    break;
                }
            }
        }
    }


    private static void addField(XWPFParagraph paragraph, String fieldName) {
        CTSimpleField ctSimpleField = paragraph.getCTP().addNewFldSimple();
        ctSimpleField.setInstr(fieldName);
        ctSimpleField.setDirty(STOnOff.TRUE);
        ctSimpleField.addNewR().addNewT().setStringValue("<<fieldName>>");
    }

}
