package com.andy.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Slf4j
@Service
public class PdfBoxService {

    public byte[] createPDF(String name){
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            if(StringUtils.isBlank(name)){
                name = "Andy's Fans";
            }
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // 设置字体和颜色
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 24);
            contentStream.setStrokingColor(0, 0, 0);

            // 写入个性化的贺卡消息
            contentStream.beginText();
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText("Hello, " + name + "!");
            contentStream.newLineAtOffset(0, -30); // 在当前位置下移30个单位，以创建新的一行
            contentStream.showText("Wishing you a very Happy Birthday!");
            contentStream.endText();

            contentStream.close();
            document.save(baos);
            document.close();

            log.info("PDF created successfully!");
            return baos.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
