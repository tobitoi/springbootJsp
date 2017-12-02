package com.attendance.utils;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.attendance.model.CheckInOut;
import com.attendance.view.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Tobitoi on 11/16/17.
 */
public class CreatePDF  extends AbstractPdfView{


    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<CheckInOut> checkInOutList = (List<CheckInOut>) model.get("checkInOuts");

        document.add(new Paragraph("Belajar PDF Writer"));

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{ 3.0f, 2.0f, 2.0f, 2.0f, 1.0f});
        table.setSpacingBefore(10);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);

        PdfPCell pdfCell = new PdfPCell();
        pdfCell.setBackgroundColor(BaseColor.BLUE);
        pdfCell.setPadding(5);

        pdfCell.setPhrase(new Phrase("Id",font));
        table.addCell(pdfCell);

        pdfCell.setPhrase(new Phrase("nama",font));
        table.addCell(pdfCell);

        pdfCell.setPhrase(new Phrase("check In",font));
        table.addCell(pdfCell);

        pdfCell.setPhrase(new Phrase("check Out",font));
        table.addCell(pdfCell);

        for (CheckInOut checkInOut : checkInOutList){
            table.addCell(String.valueOf(checkInOut.getPegawai().getUserId()));
            table.addCell(String.valueOf(checkInOut.getPegawai().getName()));
            table.addCell(checkInOut.getCheckInTime());
            table.addCell(checkInOut.getCheckOutTime());
        }

        document.add(table);
    }
}

