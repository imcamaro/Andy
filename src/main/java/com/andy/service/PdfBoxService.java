package com.andy.service;

import lombok.extern.slf4j.Slf4j;
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

    public byte[] createPDF(){
        try {
            byte[] pdf = null;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // 创建一个内容流，用于在页面上绘制文本、图形等
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.setStrokingColor(0, 0, 0);
            contentStream.beginText();
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText("Hello World!");
            contentStream.endText();
            contentStream.close();
            document.save(baos);

            document.close();

            pdf = baos.toByteArray();
            log.info("PDF created successfully!");
            return pdf;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
