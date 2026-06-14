package ec.edu.espe.safestore.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.safestore.model.Supplier;
import ec.edu.espe.safestore.model.SupplierInvoice;
import ec.edu.espe.safestore.model.InvoiceItem;
import org.bson.Document;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SupplierController {
    
    private MongoDBConnection dbConnection;
    private MongoCollection<Document> supplierCollection;
    private MongoCollection<Document> invoiceCollection;
    private ProductController productController;
    
    public SupplierController() {
        dbConnection = new MongoDBConnection();
        dbConnection.connect();
        supplierCollection = dbConnection.getCollection("suppliers");
        invoiceCollection = dbConnection.getCollection("supplier_invoices");
        productController = new ProductController();
        loadDefaultSuppliers();
    }
    
    private void loadDefaultSuppliers() {
        if (supplierCollection.countDocuments() == 0) {
            Document supplier1 = new Document("id", 1)
                    .append("name", "Distribuidora XYZ")
                    .append("contactPerson", "Juan Perez")
                    .append("phone", "0999999999")
                    .append("email", "juan@xyz.com")
                    .append("address", "Calle 123")
                    .append("creditTerm", 30)
                    .append("currentDebt", 0)
                    .append("creditLimit", 5000)
                    .append("isActive", true)
                    .append("invoiceIds", new ArrayList<Integer>());
            supplierCollection.insertOne(supplier1);
            
            Document supplier2 = new Document("id", 2)
                    .append("name", "Alimentos SA")
                    .append("contactPerson", "Maria Gomez")
                    .append("phone", "0888888888")
                    .append("email", "maria@alimentos.com")
                    .append("address", "Av. Principal")
                    .append("creditTerm", 15)
                    .append("currentDebt", 0)
                    .append("creditLimit", 3000)
                    .append("isActive", true)
                    .append("invoiceIds", new ArrayList<Integer>());
            supplierCollection.insertOne(supplier2);
        }
    }
    
    private Document supplierToDoc(Supplier s) {
        if (s == null) return new Document();
        
        List<Integer> invoiceIds = s.getInvoiceIds();
        if (invoiceIds == null) invoiceIds = new ArrayList<>();
        
        return new Document("id", s.getId())
                .append("name", s.getName() != null ? s.getName() : "")
                .append("contactPerson", s.getContactPerson() != null ? s.getContactPerson() : "")
                .append("phone", s.getPhone() != null ? s.getPhone() : "")
                .append("email", s.getEmail() != null ? s.getEmail() : "")
                .append("address", s.getAddress() != null ? s.getAddress() : "")
                .append("creditTerm", s.getCreditTerm())
                .append("currentDebt", s.getCurrentDebt())
                .append("creditLimit", s.getCreditLimit())
                .append("isActive", s.isActive())
                .append("invoiceIds", invoiceIds);
    }
    
    private Supplier docToSupplier(Document doc) {
        if (doc == null) return null;
        
        Supplier supplier = new Supplier();
        
        Object idObj = doc.get("id");
        if (idObj instanceof Number) {
            supplier.setId(((Number) idObj).intValue());
        }
        
        supplier.setName(doc.getString("name") != null ? doc.getString("name") : "");
        supplier.setContactPerson(doc.getString("contactPerson") != null ? doc.getString("contactPerson") : "");
        supplier.setPhone(doc.getString("phone") != null ? doc.getString("phone") : "");
        supplier.setEmail(doc.getString("email") != null ? doc.getString("email") : "");
        supplier.setAddress(doc.getString("address") != null ? doc.getString("address") : "");
        
        Object creditTermObj = doc.get("creditTerm");
        if (creditTermObj instanceof Number) {
            supplier.setCreditTerm(((Number) creditTermObj).doubleValue());
        }
        
        Object currentDebtObj = doc.get("currentDebt");
        if (currentDebtObj instanceof Number) {
            supplier.setCurrentDebt(((Number) currentDebtObj).doubleValue());
        }
        
        Object creditLimitObj = doc.get("creditLimit");
        if (creditLimitObj instanceof Number) {
            supplier.setCreditLimit(((Number) creditLimitObj).doubleValue());
        }
        
        Object isActiveObj = doc.get("isActive");
        if (isActiveObj instanceof Boolean) {
            supplier.setActive((Boolean) isActiveObj);
        }
        
        List<Integer> invoiceIds = doc.getList("invoiceIds", Integer.class);
        if (invoiceIds != null) {
            supplier.setInvoiceIds(invoiceIds);
        } else {
            supplier.setInvoiceIds(new ArrayList<>());
        }
        
        return supplier;
    }
    
    private Document invoiceToDoc(SupplierInvoice inv) {
        if (inv == null) return new Document();
        
        List<Document> itemDocs = new ArrayList<>();
        if (inv.getItems() != null) {
            for (InvoiceItem item : inv.getItems()) {
                Document itemDoc = new Document("productId", item.getProductId())
                        .append("productName", item.getProductName() != null ? item.getProductName() : "")
                        .append("quantity", item.getQuantity())
                        .append("unitCost", item.getUnitCost())
                        .append("totalPrice", item.getTotalPrice());
                itemDocs.add(itemDoc);
            }
        }
        
        return new Document("invoiceId", inv.getInvoiceId())
                .append("supplierId", inv.getSupplierId())
                .append("invoiceNumber", inv.getInvoiceNumber() != null ? inv.getInvoiceNumber() : "")
                .append("date", inv.getDate() != null ? inv.getDate().toString() : LocalDate.now().toString())
                .append("dueDate", inv.getDueDate() != null ? inv.getDueDate().toString() : LocalDate.now().toString())
                .append("subtotal", inv.getSubtotal())
                .append("tax", inv.getTax())
                .append("total", inv.getTotal())
                .append("status", inv.getStatus() != null ? inv.getStatus() : "pending")
                .append("items", itemDocs);
    }
    
    private SupplierInvoice docToInvoice(Document doc) {
        if (doc == null) return null;
        
        SupplierInvoice invoice = new SupplierInvoice();
        
        Object invoiceIdObj = doc.get("invoiceId");
        if (invoiceIdObj instanceof Number) {
            invoice.setInvoiceId(((Number) invoiceIdObj).intValue());
        }
        
        Object supplierIdObj = doc.get("supplierId");
        if (supplierIdObj instanceof Number) {
            invoice.setSupplierId(((Number) supplierIdObj).intValue());
        }
        
        invoice.setInvoiceNumber(doc.getString("invoiceNumber") != null ? doc.getString("invoiceNumber") : "");
        
        String dateStr = doc.getString("date");
        if (dateStr != null && !dateStr.isEmpty()) {
            try {
                invoice.setDate(LocalDate.parse(dateStr));
            } catch (Exception e) {
                invoice.setDate(LocalDate.now());
            }
        } else {
            invoice.setDate(LocalDate.now());
        }
        
        String dueDateStr = doc.getString("dueDate");
        if (dueDateStr != null && !dueDateStr.isEmpty()) {
            try {
                invoice.setDueDate(LocalDate.parse(dueDateStr));
            } catch (Exception e) {
                invoice.setDueDate(LocalDate.now());
            }
        } else {
            invoice.setDueDate(LocalDate.now());
        }
        
        Object subtotalObj = doc.get("subtotal");
        if (subtotalObj instanceof Number) {
            invoice.setSubtotal(((Number) subtotalObj).doubleValue());
        }
        
        Object taxObj = doc.get("tax");
        if (taxObj instanceof Number) {
            invoice.setTax(((Number) taxObj).doubleValue());
        }
        
        Object totalObj = doc.get("total");
        if (totalObj instanceof Number) {
            invoice.setTotal(((Number) totalObj).doubleValue());
        }
        
        invoice.setStatus(doc.getString("status") != null ? doc.getString("status") : "pending");
        
        List<Document> itemDocs = doc.getList("items", Document.class);
        if (itemDocs != null) {
            for (Document itemDoc : itemDocs) {
                Object productIdObj = itemDoc.get("productId");
                Integer productId = null;
                if (productIdObj instanceof Number) {
                    productId = ((Number) productIdObj).intValue();
                }
                
                String productName = itemDoc.getString("productName");
                
                Object quantityObj = itemDoc.get("quantity");
                Integer quantity = null;
                if (quantityObj instanceof Number) {
                    quantity = ((Number) quantityObj).intValue();
                }
                
                Object unitCostObj = itemDoc.get("unitCost");
                Double unitCost = null;
                if (unitCostObj instanceof Number) {
                    unitCost = ((Number) unitCostObj).doubleValue();
                }
                
                if (productId != null && quantity != null && unitCost != null) {
                    InvoiceItem item = new InvoiceItem(
                        productId,
                        productName != null ? productName : "",
                        quantity,
                        unitCost
                    );
                    invoice.addItem(item);
                }
            }
        }
        
        return invoice;
    }
    
    public boolean addSupplier(Supplier supplier) {
        if (supplier == null) return false;
        if (findSupplierById(supplier.getId()) != null) return false;
        supplierCollection.insertOne(supplierToDoc(supplier));
        return true;
    }
    
    public Supplier findSupplierById(int id) {
        Document doc = supplierCollection.find(Filters.eq("id", id)).first();
        return docToSupplier(doc);
    }
    
    public List<Supplier> getAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        for (Document doc : supplierCollection.find()) {
            Supplier s = docToSupplier(doc);
            if (s != null) {
                suppliers.add(s);
            }
        }
        return suppliers;
    }
    
    public boolean addInvoice(SupplierInvoice invoice) {
        if (invoice == null) return false;
        invoiceCollection.insertOne(invoiceToDoc(invoice));
        
        Supplier supplier = findSupplierById(invoice.getSupplierId());
        if (supplier != null) {
            supplier.addInvoiceId(invoice.getInvoiceId());
            supplier.setCurrentDebt(supplier.getCurrentDebt() + invoice.getTotal());
            supplierCollection.replaceOne(Filters.eq("id", supplier.getId()), supplierToDoc(supplier));
        }
        return true;
    }
    
    public List<SupplierInvoice> getPendingInvoices() {
        List<SupplierInvoice> pending = new ArrayList<>();
        for (Document doc : invoiceCollection.find(Filters.eq("status", "pending"))) {
            SupplierInvoice inv = docToInvoice(doc);
            if (inv != null) {
                pending.add(inv);
            }
        }
        return pending;
    }
    
    public List<SupplierInvoice> getAllInvoices() {
        List<SupplierInvoice> invoices = new ArrayList<>();
        for (Document doc : invoiceCollection.find()) {
            SupplierInvoice inv = docToInvoice(doc);
            if (inv != null) {
                invoices.add(inv);
            }
        }
        return invoices;
    }
    
    public boolean payInvoice(int invoiceId) {
        SupplierInvoice invoice = findInvoiceById(invoiceId);
        if (invoice == null || !"pending".equals(invoice.getStatus())) return false;
        
        invoice.setStatus("paid");
        invoiceCollection.replaceOne(Filters.eq("invoiceId", invoiceId), invoiceToDoc(invoice));
        
        Supplier supplier = findSupplierById(invoice.getSupplierId());
        if (supplier != null) {
            supplier.setCurrentDebt(supplier.getCurrentDebt() - invoice.getTotal());
            supplierCollection.replaceOne(Filters.eq("id", supplier.getId()), supplierToDoc(supplier));
        }
        return true;
    }
    
    private SupplierInvoice findInvoiceById(int id) {
        Document doc = invoiceCollection.find(Filters.eq("invoiceId", id)).first();
        return docToInvoice(doc);
    }
    
    public List<InvoiceItem> getInvoiceItems(int invoiceId) {
        SupplierInvoice invoice = findInvoiceById(invoiceId);
        if (invoice == null) return new ArrayList<>();
        return invoice.getItems();
    }
    
    public boolean updateSupplier(Supplier supplier) {
        if (supplier == null) return false;
        if (findSupplierById(supplier.getId()) == null) return false;
        supplierCollection.replaceOne(Filters.eq("id", supplier.getId()), supplierToDoc(supplier));
        return true;
    }
    
    public boolean deleteSupplier(int id) {
        if (findSupplierById(id) == null) return false;
        supplierCollection.deleteOne(Filters.eq("id", id));
        return true;
    }
}