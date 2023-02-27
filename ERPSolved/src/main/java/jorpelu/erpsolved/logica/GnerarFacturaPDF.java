package jorpelu.erpsolved.logica;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfImage;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jorpelu.erpsolved.model.LineaDeFacturaEntity;
import jorpelu.erpsolved.model.ProductoEntity;
import jorpelu.erpsolved.model.TercerosEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import java.net.URL;
import java.util.List;
import java.util.Map;

@Component("ventas/facturas")
public class GnerarFacturaPDF extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<LineaDeFacturaEntity> lineaDeFacturaEntities = (List<LineaDeFacturaEntity>)model.get("listaFactura");
        TercerosEntity tercero = (TercerosEntity) model.get("terceroForm");
        document.setPageSize(PageSize.A4);
        document.open();
        PdfPTable tablaProductos = new PdfPTable(6);
        Image image = Image.getInstance("src/main/resources/static/img/logo.png");
        PdfPTable tablaClientes = new PdfPTable(3);
        tablaClientes.addCell("name:"+tercero.getName());
        tablaClientes.addCell(tercero.getCif());
        tablaClientes.addCell(tercero.getDireccion());
        lineaDeFacturaEntities.forEach(producto -> {
            tablaProductos.addCell("id:"+String.valueOf(producto.getId()));
            tablaProductos.addCell(producto.getIdProd().getDescripcion());
            tablaProductos.addCell(String.valueOf(producto.getCantidad()));
            tablaProductos.addCell(String.valueOf(producto.getPrecioLinea()));
            tablaProductos.addCell(String.valueOf(producto.getIdProd().getPrecio()));
            tablaProductos.addCell(producto.getIdProd().getFamilia());
        });
        document.add(image);
        document.add(tablaClientes);
        document.add(tablaProductos);

    }
}
