package br.sys.function;

import br.sys.Bean.Mensalidade;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.sys.Financeiro.PagMensalidade;
import br.sys.function.PegarHora;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Alberto
 */
public class GerarPdfMesalidade {

    public GerarPdfMesalidade() {

    }

    public void GerarPdfMensalidade(Mensalidade mensalidade) throws ParseException {
        // public void GerarPdf(){
        Document doc = null;
        OutputStream os = null;
        PegarHora hora = new PegarHora();
        
        try {
            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 72, 72, 72, 72);

            try {
                //cria a stream de saída
                os = new FileOutputStream("E:\\Recibo_Mensalidade.pdf");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GerarPdfMesalidade.class.getName()).log(Level.SEVERE, null, ex);
            }

            //associa a stream de saída ao 
            PdfWriter.getInstance(doc, os);

            //abre o documento
            doc.open();

            Paragraph p = new Paragraph("Pagamento de Mensalidade.");
            doc.add(p);

            //adiciona o texto ao PDF
            Font f = new Font(Font.FontFamily.COURIER, 20, Font.BOLD); // tipo de fonte
            Image img = Image.getInstance("E:\\logomarca.jpg");
            img.setAlignment(Element.ALIGN_CENTER);
            doc.add(img);

            Paragraph p1 = new Paragraph("RECIBO DE MENSALIDADE!", f);
            p1.setAlignment(Element.ALIGN_CENTER); // Alinhamento
            p1.setSpacingAfter(20); // Espaçamento entre as linhas
            doc.add(p1);
            //PdfPTable table = new PdfPTable(3);// Numeros de Colunas
            PdfPTable table = new PdfPTable(new float[]{0.2f, 0.2f});// Exemplo de como definir o tamanho das celulas
            PdfPCell header = new PdfPCell(new Paragraph("Recibo de Mensalidade.", f));
            //table.setWidthPercentage(60.0f);
            table.setHorizontalAlignment(Element.ALIGN_RIGHT);
            // Customizando as bordas e cores É possível também customizarmos as bordas das células e as cores das bordas e das células 
            header.setBackgroundColor(BaseColor.YELLOW);
            header.setBorderWidthBottom(4.0f);
            header.setBorderColorBottom(BaseColor.BLUE);
            header.setBorder(Rectangle.BOTTOM);

            header.setColspan(2); // Colunas oculpda pelo cabeçario
            table.addCell(header);
            table.addCell("Nome: ");
            table.addCell(mensalidade.getNome());
            table.addCell("CPF: ");
            table.addCell(mensalidade.getCpf());
            table.addCell("Matriculas: ");
            table.addCell(Integer.toString(mensalidade.getMat_alunos()));
            table.addCell("Valor Recebido: ");
            table.addCell(Float.toString(mensalidade.getValor()));
            table.addCell("Data de Vecimento: ");
            table.addCell(mensalidade.getData_vencimento());
            table.addCell("Data de Pagamento: ");
            table.addCell(hora.Hora());
            doc.add(table);

            p1.setSpacingAfter(60);
            Paragraph p2 = new Paragraph("Comprovante de Pagamento.");
            p2.setSpacingAfter(20); // Espaçamento de linhas
            doc.add(p2);
            
            p1.setSpacingAfter(300);
            Paragraph p4 = new Paragraph("_____________________________________________________");
            p4.setAlignment(Element.ALIGN_CENTER);
            p2.setSpacingAfter(20); // Espaçamento de linhas
            doc.add(p4);

            p1.setSpacingAfter(50);
            Paragraph p3 = new Paragraph("Assinatura do Funcionario");
            p3.setAlignment(Element.ALIGN_CENTER);
            p2.setSpacingAfter(20); // Espaçamento de linhas
            doc.add(p3);

        } catch (DocumentException ex) {
            Logger.getLogger(GerarPdfMesalidade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerarPdfMesalidade.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (doc != null) {
                //fechamento do documento
                doc.close();
            }
            if (os != null) {
                try {
                    //fechamento da stream de saída
                    os.close();
                } catch (IOException ex) {
                    Logger.getLogger(GerarPdfMesalidade.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
