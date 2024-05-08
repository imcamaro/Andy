package com.andy.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class ItextService {
    public byte[] createPDF(String name) throws DocumentException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, baos);
        try {
            document.open();
            Font font = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD);
            if(StringUtils.isBlank(name)){
                name = "Andy's Fans";
            }
            Paragraph paragraph = new Paragraph("Hello " + name + "!", font);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);

            Paragraph paragraph2 = new Paragraph("Happy Birthday!", font);
            paragraph2.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph2);
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
        return baos.toByteArray();
    }
}
