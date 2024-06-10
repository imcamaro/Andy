package com.andy.controller;

import com.andy.service.ItextService;
import com.andy.service.PdfBoxService;
import com.itextpdf.text.DocumentException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.OutputStream;

@Controller
@Slf4j
@Tag(name="PDF Controller")
public class PdfController {

    @Autowired
    private PdfBoxService pdfBoxService;

    @Autowired
    private ItextService itextService;

    @GetMapping("/pdfbox")
    @Operation(summary = "Generate PDF Box", description = "generate PDF by PdfBox")
    public void generatePdfBox(HttpServletResponse response,
                               @RequestParam(required = false) String name) throws IOException {
        log.info("####### Access into pdfbox API #######");
        response.setHeader("Content-Disposition", "attachment;FileName=PDFBox.pdf");
        byte[] pdf = pdfBoxService.createPDF(name);
        OutputStream out = response.getOutputStream();
        out.write(pdf);
        out.close();
        log.info("####### Complete pdfbox API #######");
    }

    @GetMapping("/itext")
    @Operation(summary = "Generate iText PDF", description = "generate PDF by iText")
    public void generateItext(HttpServletResponse response,
                              @RequestParam(required = false) String name) throws DocumentException, IOException {
        log.info("####### Access into itext API #######");
        response.setHeader("Content-Disposition", "attachment;FileName=iText.pdf");
        byte[] pdf = itextService.createPDF(name);
        OutputStream out = response.getOutputStream();
        out.write(pdf);
        out.close();
        log.info("####### Complete iText API #######");
    }

}
