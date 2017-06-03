
import java.io.FileOutputStream;
import java.sql.SQLXML;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class FirstPdf {
	private static String FILE = "D:/FirstPdf.pdf";
	private static Font CAT_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font RED_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
	private static Font SUB_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	private static Font SMALL_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	public static void main(String[] args) {
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();

			addMetaData(document);

			addContent(document);

			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --------------- TODO Them detail cho file PDF ---------------
	private static void addMetaData(Document document) {
		document.addTitle("My first PDF");
		document.addSubject("Using iText");
		document.addKeywords("Java, PDF, iText");
		document.addAuthor("Lars Vogel");
		document.addCreator("Lars Vogel");
	}

	private static void addContent(Document document) throws DocumentException {

		// --------------- TODO them content 1 ---------------

		Anchor anchor = new Anchor("First Chapter", CAT_FONT);
		anchor.setName("First Chapter");
		// So 2 la SO THU TU cua "First Chapter" hien tren PDF
		Chapter catPart = new Chapter(new Paragraph(anchor), 1);

		Paragraph subPara = new Paragraph("Subcategory 1", SUB_FONT);
		Section subCatPart = catPart.addSection(subPara);

		subCatPart.add(new Paragraph("Hello"));

		subPara = new Paragraph("Subcategory 2", SUB_FONT);
		subCatPart = catPart.addSection(subPara);

		// Them danh sach co thu tu
		// parameter thu nhat la danh stt, thu 2 la danh ABC, thu 3 la Symbol
		List list = new List(false, false, 10);
		list.add(new ListItem("First point"));
		list.add(new ListItem("Second point"));
		list.add(new ListItem("Third point"));
		subCatPart.add(list);

		subCatPart.add(new Paragraph("Hola"));
		subCatPart.add(new Paragraph("Xin Chao"));
		subCatPart.add(new Paragraph("Ohayo GoZaiMaXu"));

		// --------------- TODO them 5 dong trong ---------------
		Paragraph paragraph = new Paragraph();
		for (int i = 0; i < 5; i++) {
			paragraph.add(new Paragraph(" "));
		}
		subCatPart.add(paragraph);

		// --------------- TODO them table ---------------

		PdfPTable table = new PdfPTable(3);

		// tao thead cho table
		for (int i = 1; i <= 3; i++) {
			PdfPCell cel = new PdfPCell(new Phrase("Table Header " + i));
			cel.setHorizontalAlignment(Element.ALIGN_CENTER);
			cel.setPadding(5);
			// cel.setBorderColor(BaseColor.GRAY);
			// cel.setSpacing(4);
			// cel.setBorderWidth(1);
			table.addCell(cel);
		}

		// table.setHeaderRows(10);

		// tao tbody cho table
		for (int i = 1; i <= 9; i++) {
			table.addCell("1." + i);
		}

		subCatPart.add(table);

		// --------------- TODO Them tat ca o tren vao file PDF ---------------
		document.add(catPart);

		// --------------- TODO tao content 2 ---------------
		anchor = new Anchor("Second Chapter", RED_FONT);
		anchor.setName("Second Chapter");

		// So 2 la SO THU TU cua "Second Chapter" hien tren PDF
		catPart = new Chapter(new Paragraph(anchor), 2);

		subPara = new Paragraph("Subcategory", SMALL_FONT);
		subCatPart = catPart.addSection(subPara);

		// Them tat ca o tren vao file PDF
		document.add(catPart);

	}
}