package com.attendance.view;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;


/**
 * Created by Tobitoi on 11/17/17.
 */


public abstract class AbstractPdfView extends AbstractView {

    public AbstractPdfView(){
        setContentType("application/pdf");
    }

    @Override
    protected boolean generatesDownloadContent(){
        return true;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object > model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        ByteArrayOutputStream byteArrayOutputStream = createTemporaryOutputStream();

        Document document = new Document();
        PdfWriter writer = newWriter(document, byteArrayOutputStream);
        prepareWriter(model,writer,request);
        buildPdfMetadata(model,document,request);

        document.open();
        buildPdfDocument(model,document,writer,request,response);
        document.close();

        writeToResponse(response,byteArrayOutputStream);

    }

    protected Document newDocument(){
        return new Document(PageSize.A4);
    }

    protected PdfWriter newWriter(Document document, OutputStream outputStream) throws DocumentException {
        return  PdfWriter.getInstance(document, outputStream);
    }

    protected void prepareWriter (Map<String,Object> model, PdfWriter writer, HttpServletRequest request) throws DocumentException {
        writer.setViewerPreferences(getViewerPreferences());
    }

    protected int getViewerPreferences(){
        return PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage;
    }

    protected void buildPdfMetadata(Map <String, Object> model, Document document, HttpServletRequest request){

    }

    protected  abstract  void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter, HttpServletRequest request, HttpServletResponse response) throws Exception;
}