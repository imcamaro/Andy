package andy.controller;

import andy.service.ItextService;
import andy.service.PdfBoxService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.OutputStream;

@Controller
@Slf4j
public class AndyController {

    @Autowired
    private PdfBoxService pdfBoxService;

    @Autowired
    private ItextService itextService;

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        log.info("####### Access into hello API #######");
        return ResponseEntity.ok("Hello World!");
    }

    @GetMapping("/pdfbox")
    public ResponseEntity<String> generatePdfBox(HttpServletResponse response) throws IOException {
        log.info("####### Access into pdfbox API #######");
        response.setHeader("Content-Disposition", "attachment;FileName=PDFBox.pdf");
        byte[] pdf = pdfBoxService.createPDF();
        OutputStream out = response.getOutputStream();
        out.write(pdf);
        out.close();

        return ResponseEntity.ok("PDFBox download success!");
    }

    @GetMapping("/itext")
    public ResponseEntity<String> generateItext(HttpServletResponse response){
        log.info("####### Access into itext API #######");
        return ResponseEntity.ok("iText PDF download success!");
    }

}
