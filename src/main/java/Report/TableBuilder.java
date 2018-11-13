package Report;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class TableBuilder {
	 // create table
    public static PdfPTable createTable() throws DocumentException {
    	

        // create 6 column table
        PdfPTable table = new PdfPTable(4);
        
        // set the width of the table to 100% of page
        table.setWidthPercentage(100);
        
        // set relative columns width
        table.setWidths(new float[]{1f,1f,0.5f,1.5f});

        
        // ----------------Table Header "Title"----------------
        // font
        Font font = new Font(FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.WHITE);
        Font HeadingFont = new Font(FontFamily.HELVETICA, 20, Font.BOLD, BaseColor.WHITE);
        // create header cell
        PdfPCell cell = new PdfPCell(new Phrase("Alt-Text Image Relavancy Report",HeadingFont));
        // set Column span "1 cell = 6 cells width"
        cell.setColspan(4);
        // set style
        Style.headerCellStyle(cell);
        cell.setBackgroundColor(new BaseColor(20, 20, 20));
        // add to table
        table.addCell(cell);
        	
        
        //-----------------Table Cells Label/Value------------------
        
        // 1st Row
        PdfPCell cellImage=createLabelCell("Image");
        PdfPCell cellAlt=createLabelCell("Alt-Text");
        PdfPCell cellRelevancy=createLabelCell("Alt-Text-Relevancy");
        PdfPCell cellRecommandstions=createLabelCell("Recommandations");
        Style.headerCellStyle(cellImage);
        Style.headerCellStyle(cellAlt);
        Style.headerCellStyle(cellRelevancy);
        Style.headerCellStyle(cellRecommandstions);
        table.addCell(cellImage);
        table.addCell(cellAlt);
        table.addCell(cellRelevancy);
        table.addCell(cellRecommandstions);

        return table;
    }
    
    private static PdfPCell createLabelCell(String text){
    	Font font = new Font(FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
    	PdfPCell cell = new PdfPCell(new Phrase(text,font));
    	Style.labelCellStyle(cell);
        return cell;
    }
    
    private static PdfPCell createPassCell(String text){
    	Font font = new Font(FontFamily.HELVETICA, 14, Font.NORMAL, BaseColor.GREEN);
    	PdfPCell cell = new PdfPCell(new Phrase(text,font));
    	cell.setBackgroundColor(new BaseColor(240, 240, 240));
    	Style.valueCellStyle(cell);
        cell.setBorder(1);
        return cell;
    }
    private static PdfPCell createFailCell(String text){
    	Font font = new Font(FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.RED);
    	PdfPCell cell = new PdfPCell(new Phrase(text,font));
    	cell.setBackgroundColor(new BaseColor(240,240,240));
    	Style.valueCellStyle(cell);
        cell.setBorder(0);
        cell.setBorderWidth(1);
        cell.setBorderColor(BaseColor.GRAY);
        return cell;
    }
    
    
    public static void addNewRow(PdfPTable table,String ImagePath,String Alt,String relevancy,String Recommandation) {
    	System.out.println("Trying to add the row"+ImagePath);
    	try {
			table.addCell(Image.getInstance(ImagePath));
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(relevancy.contains("GREEN"))
    	{
    		table.addCell(createLabelCell(Alt));
        	table.addCell(createPassCell(relevancy));
        	table.addCell(createLabelCell(Recommandation));
    	}
    	else
    	{
    		table.addCell(createLabelCell(Alt));
    		table.addCell(createFailCell(relevancy));
        	table.addCell(createLabelCell(Recommandation));
    	}

    	
    }
}