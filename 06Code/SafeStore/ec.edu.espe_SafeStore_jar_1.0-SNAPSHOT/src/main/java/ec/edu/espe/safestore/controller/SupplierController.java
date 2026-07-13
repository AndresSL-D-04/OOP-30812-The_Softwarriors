package ec.edu.espe.safestore.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.safestore.model.*;
import ec.edu.espe.safestore.utils.*;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

public class SupplierController {
    
    private final MongoDBConnection dbConnection;
    private final MongoCollection<Document> supplierCollection;
    private final MongoCollection<Document> invoiceCollection;
    private final DataInitializer dataInitializer;
    
    public SupplierController() {
        this.dbConnection = new MongoDBConnection();
        this.dbConnection.connect();
        this.supplierCollection = dbConnection.getCollection(Constants.COLLECTION_SUPPLIERS);
        this.invoiceCollection = dbConnection.getCollection(Constants.COLLECTION_SUPPLIER_INVOICES);
        this.dataInitializer = new DataInitializer(dbConnection);
        this.dataInitializer.initializeSuppliers();
    }
    
    public boolean addSupplier(Supplier supplier) {
        if (supplier == null || findSupplierById(supplier.getId()) != null) return false;
        supplierCollection.insertOne(DocumentConverter.supplierToDoc(supplier));
        return true;
    }
    
    public Supplier findSupplierById(int id) {
        Document doc = supplierCollection.find(Filters.eq("id", id)).first();
        return DocumentConverter.docToSupplier(doc);
    }
    
    public List<Supplier> getAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        for (Document doc : supplierCollection.find()) {
            Supplier s = DocumentConverter.docToSupplier(doc);
            if (s != null) suppliers.add(s);
        }
        return suppliers;
    }
    
    public boolean updateSupplier(Supplier supplier) {
        if (supplier == null || findSupplierById(supplier.getId()) == null) return false;
        supplierCollection.replaceOne(Filters.eq("id", supplier.getId()), DocumentConverter.supplierToDoc(supplier));
        return true;
    }
    
    public boolean deleteSupplier(int id) {
        if (findSupplierById(id) == null) return false;
        supplierCollection.deleteOne(Filters.eq("id", id));
        return true;
    }
    
    public boolean addInvoice(SupplierInvoice invoice) {
        if (invoice == null) return false;
        invoiceCollection.insertOne(DocumentConverter.invoiceToDoc(invoice));
        Supplier supplier = findSupplierById(invoice.getSupplierId());
        if (supplier != null) {
            supplier.addInvoiceId(invoice.getInvoiceId());
            supplier.setCurrentDebt(supplier.getCurrentDebt() + invoice.getTotal());
            updateSupplier(supplier);
        }
        return true;
    }
    
    public List<SupplierInvoice> getPendingInvoices() {
        List<SupplierInvoice> pending = new ArrayList<>();
        for (Document doc : invoiceCollection.find(Filters.eq("status", Constants.INVOICE_PENDING))) {
            SupplierInvoice inv = DocumentConverter.docToInvoice(doc);
            if (inv != null) pending.add(inv);
        }
        return pending;
    }
    
    public List<SupplierInvoice> getAllInvoices() {
        List<SupplierInvoice> invoices = new ArrayList<>();
        for (Document doc : invoiceCollection.find()) {
            SupplierInvoice inv = DocumentConverter.docToInvoice(doc);
            if (inv != null) invoices.add(inv);
        }
        return invoices;
    }
    
    public boolean payInvoice(int invoiceId) {
        SupplierInvoice invoice = findInvoiceById(invoiceId);
        if (invoice == null || !Constants.INVOICE_PENDING.equals(invoice.getStatus())) return false;
        invoice.setStatus(Constants.INVOICE_PAID);
        invoiceCollection.replaceOne(Filters.eq("invoiceId", invoiceId), DocumentConverter.invoiceToDoc(invoice));
        Supplier supplier = findSupplierById(invoice.getSupplierId());
        if (supplier != null) {
            supplier.setCurrentDebt(supplier.getCurrentDebt() - invoice.getTotal());
            updateSupplier(supplier);
        }
        System.out.println("Factura #" + invoiceId + " pagada");
        return true;
    }
    
    private SupplierInvoice findInvoiceById(int id) {
        Document doc = invoiceCollection.find(Filters.eq("invoiceId", id)).first();
        return DocumentConverter.docToInvoice(doc);
    }
    
    public List<InvoiceItem> getInvoiceItems(int invoiceId) {
        SupplierInvoice invoice = findInvoiceById(invoiceId);
        return invoice != null ? invoice.getItems() : new ArrayList<>();
    }
}