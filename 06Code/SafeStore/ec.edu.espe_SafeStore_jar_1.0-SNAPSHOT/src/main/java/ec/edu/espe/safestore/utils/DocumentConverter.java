
package ec.edu.espe.safestore.utils;

import ec.edu.espe.safestore.model.*;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
public class DocumentConverter {
    
    public static Document productToDoc(Product p) {
        return new Document("id", p.getId())
                .append("name", p.getName())
                .append("wholesalePrice", p.getWholesalePrice())
                .append("retailPrice", p.getRetailPrice())
                .append("stock", p.getStock())
                .append("minStock", p.getMinStock())
                .append("expiryDate", p.getExpiryDate());
    }

    public static Product docToProduct(Document doc) {
        return new Product(
            doc.getInteger("id"),
            doc.getString("name") != null ? doc.getString("name") : "",
            doc.getDouble("wholesalePrice") != null ? doc.getDouble("wholesalePrice") : 0.0,
            doc.getDouble("retailPrice") != null ? doc.getDouble("retailPrice") : 0.0,
            doc.getInteger("stock") != null ? doc.getInteger("stock") : 0,
            doc.getInteger("minStock") != null ? doc.getInteger("minStock") : 0,
            doc.getString("expiryDate") != null ? doc.getString("expiryDate") : ""
        );
    }
    
    public static Document userToDoc(User u) {
        return new Document("username", u.getUsername())
                .append("password", u.getPassword())
                .append("role", u.getRole());
    }

    public static User docToUser(Document doc) {
        return new User(
            doc.getString("username"),
            doc.getString("password"),
            doc.getString("role")
        );
    }
    
    public static Document saleToDoc(Sale s) {
        List<Document> itemDocs = new ArrayList<>();
        for (SaleItem item : s.getItems()) {
            itemDocs.add(new Document("productId", item.getProductId())
                    .append("productName", item.getProductName())
                    .append("quantity", item.getQuantity())
                    .append("unitPrice", item.getUnitPrice())
                    .append("totalPrice", item.getTotalPrice()));
        }
        return new Document("saleId", s.getSaleId())
                .append("customerName", s.getCustomerName())
                .append("saleType", s.getSaleType())
                .append("paymentMethod", s.getPaymentMethod())
                .append("date", s.getDate() != null ? s.getDate().toString() : java.time.LocalDateTime.now().toString())
                .append("subtotal", s.getSubtotal())
                .append("tax", s.getTax())
                .append("total", s.getTotal())
                .append("items", itemDocs);
    }

    public static Sale docToSale(Document doc) {
        Sale s = new Sale(
            doc.getInteger("saleId"),
            doc.getString("customerName"),
            doc.getString("saleType"),
            doc.getString("paymentMethod")
        );
        s.setSubtotal(doc.getDouble("subtotal") != null ? doc.getDouble("subtotal") : 0.0);
        s.setTax(doc.getDouble("tax") != null ? doc.getDouble("tax") : 0.0);
        s.setTotal(doc.getDouble("total") != null ? doc.getDouble("total") : 0.0);
        List<Document> itemDocs = doc.getList("items", Document.class);
        if (itemDocs != null) {
            for (Document itemDoc : itemDocs) {
                SaleItem item = new SaleItem(
                    itemDoc.getInteger("productId"),
                    itemDoc.getString("productName"),
                    itemDoc.getInteger("quantity") != null ? itemDoc.getInteger("quantity") : 0,
                    itemDoc.getDouble("unitPrice") != null ? itemDoc.getDouble("unitPrice") : 0.0
                );
                s.getItems().add(item);
            }
        }
        return s;
    }
    
    public static Document comboToDoc(Combo c) {
        List<Document> itemDocs = new ArrayList<>();
        for (ComboItem item : c.getItems()) {
            itemDocs.add(new Document("productId", item.getProductId())
                    .append("productName", item.getProductName())
                    .append("productPrice", item.getProductPrice())
                    .append("quantity", item.getQuantity()));
        }
        return new Document("id", c.getId())
                .append("name", c.getName())
                .append("description", c.getDescription())
                .append("comboPrice", c.getComboPrice())
                .append("isActive", c.isActive())
                .append("items", itemDocs);
    }

    public static Combo docToCombo(Document doc) {
        Combo c = new Combo(
            doc.getInteger("id"),
            doc.getString("name"),
            doc.getString("description"),
            doc.getDouble("comboPrice") != null ? doc.getDouble("comboPrice") : 0.0
        );
        c.setActive(Boolean.TRUE.equals(doc.getBoolean("isActive")));
        List<Document> itemDocs = doc.getList("items", Document.class);
        if (itemDocs != null) {
            for (Document itemDoc : itemDocs) {
                c.addItem(new ComboItem(
                    itemDoc.getInteger("productId"),
                    itemDoc.getString("productName"),
                    itemDoc.getDouble("productPrice") != null ? itemDoc.getDouble("productPrice") : 0.0,
                    itemDoc.getInteger("quantity") != null ? itemDoc.getInteger("quantity") : 0
                ));
            }
        }
        return c;
    }
    
    public static Document creditAccountToDoc(CreditAccount a) {
        List<Document> txDocs = new ArrayList<>();
        for (Transaction t : a.getTransactions()) {
            txDocs.add(new Document("amount", t.getAmount())
                    .append("description", t.getDescription())
                    .append("type", t.getType())
                    .append("date", t.getDate()));
        }
        return new Document("customerId", a.getCustomerId())
                .append("customerName", a.getCustomerName())
                .append("creditLimit", a.getCreditLimit())
                .append("currentDebt", a.getCurrentDebt())
                .append("isBlocked", a.isBlocked())
                .append("transactions", txDocs);
    }

    public static CreditAccount docToCreditAccount(Document doc) {
        CreditAccount a = new CreditAccount(
            doc.getInteger("customerId"),
            doc.getString("customerName"),
            doc.getDouble("creditLimit") != null ? doc.getDouble("creditLimit") : 0.0
        );
        a.setCurrentDebt(doc.getDouble("currentDebt") != null ? doc.getDouble("currentDebt") : 0.0);
        a.setBlocked(Boolean.TRUE.equals(doc.getBoolean("isBlocked")));
        List<Document> txDocs = doc.getList("transactions", Document.class);
        if (txDocs != null) {
            List<Transaction> txs = new ArrayList<>();
            for (Document txDoc : txDocs) {
                txs.add(new Transaction(
                    txDoc.getDouble("amount") != null ? txDoc.getDouble("amount") : 0.0,
                    txDoc.getString("description"),
                    txDoc.getString("type"),
                    txDoc.getDate("date") != null ? txDoc.getDate("date") : new java.util.Date()
                ));
            }
            a.setTransactions(txs);
        }
        return a;
    }
    
    public static Document reservationToDoc(Reservation r) {
        List<Document> itemDocs = new ArrayList<>();
        if (r.getItems() != null) {
            for (ReservationItem item : r.getItems()) {
                itemDocs.add(new Document("productId", item.getProductId())
                        .append("productName", item.getProductName() != null ? item.getProductName() : "")
                        .append("quantity", item.getQuantity())
                        .append("unitPrice", item.getUnitPrice())
                        .append("totalPrice", item.getTotalPrice()));
            }
        }
        return new Document("reservationId", r.getReservationId())
                .append("customerId", r.getCustomerId())
                .append("customerName", r.getCustomerName() != null ? r.getCustomerName() : "")
                .append("customerPhone", r.getCustomerPhone() != null ? r.getCustomerPhone() : "")
                .append("reservationDate", r.getReservationDate() != null ? r.getReservationDate().toString() : java.time.LocalDateTime.now().toString())
                .append("expiryDate", r.getExpiryDate() != null ? r.getExpiryDate().toString() : java.time.LocalDateTime.now().plusDays(Constants.DEFAULT_RESERVATION_DAYS).toString())
                .append("status", r.getStatus() != null ? r.getStatus() : Constants.RESERVATION_ACTIVE)
                .append("notes", r.getNotes() != null ? r.getNotes() : "")
                .append("items", itemDocs);
    }

    public static Reservation docToReservation(Document doc) {
        if (doc == null) return null;
        Reservation r = new Reservation();
        Object idObj = doc.get("reservationId");
        if (idObj instanceof Number) {
            r.setReservationId(((Number) idObj).intValue());
        }
        Object customerIdObj = doc.get("customerId");
        if (customerIdObj instanceof Number) {
            r.setCustomerId(((Number) customerIdObj).intValue());
        }
        r.setCustomerName(doc.getString("customerName") != null ? doc.getString("customerName") : "");
        r.setCustomerPhone(doc.getString("customerPhone") != null ? doc.getString("customerPhone") : "");
        r.setStatus(doc.getString("status") != null ? doc.getString("status") : Constants.RESERVATION_ACTIVE);
        r.setNotes(doc.getString("notes") != null ? doc.getString("notes") : "");
        String expiryStr = doc.getString("expiryDate");
        if (expiryStr != null && !expiryStr.isEmpty()) {
            try {
                r.setExpiryDate(java.time.LocalDateTime.parse(expiryStr));
            } catch (Exception e) {
                r.setExpiryDate(java.time.LocalDateTime.now().plusDays(Constants.DEFAULT_RESERVATION_DAYS));
            }
        } else {
            r.setExpiryDate(java.time.LocalDateTime.now().plusDays(Constants.DEFAULT_RESERVATION_DAYS));
        }
        String resDateStr = doc.getString("reservationDate");
        if (resDateStr != null && !resDateStr.isEmpty()) {
            try {
                r.setReservationDate(java.time.LocalDateTime.parse(resDateStr));
            } catch (Exception e) {
                r.setReservationDate(java.time.LocalDateTime.now());
            }
        } else {
            r.setReservationDate(java.time.LocalDateTime.now());
        }
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
                Object unitPriceObj = itemDoc.get("unitPrice");
                Double unitPrice = null;
                if (unitPriceObj instanceof Number) {
                    unitPrice = ((Number) unitPriceObj).doubleValue();
                }
                if (productId != null && quantity != null && unitPrice != null) {
                    ReservationItem item = new ReservationItem(productId, productName != null ? productName : "", quantity, unitPrice);
                    r.addItem(item);
                }
            }
        }
        return r;
    }
    
    public static Document supplierToDoc(Supplier s) {
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
    
    public static Supplier docToSupplier(Document doc) {
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
        supplier.setInvoiceIds(invoiceIds != null ? invoiceIds : new ArrayList<>());
        return supplier;
    }
    
    public static Document invoiceToDoc(SupplierInvoice inv) {
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
                .append("date", inv.getDate() != null ? inv.getDate().toString() : java.time.LocalDate.now().toString())
                .append("dueDate", inv.getDueDate() != null ? inv.getDueDate().toString() : java.time.LocalDate.now().toString())
                .append("subtotal", inv.getSubtotal())
                .append("tax", inv.getTax())
                .append("total", inv.getTotal())
                .append("status", inv.getStatus() != null ? inv.getStatus() : Constants.INVOICE_PENDING)
                .append("items", itemDocs);
    }
    
    public static SupplierInvoice docToInvoice(Document doc) {
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
                invoice.setDate(java.time.LocalDate.parse(dateStr));
            } catch (Exception e) {
                invoice.setDate(java.time.LocalDate.now());
            }
        } else {
            invoice.setDate(java.time.LocalDate.now());
        }
        String dueDateStr = doc.getString("dueDate");
        if (dueDateStr != null && !dueDateStr.isEmpty()) {
            try {
                invoice.setDueDate(java.time.LocalDate.parse(dueDateStr));
            } catch (Exception e) {
                invoice.setDueDate(java.time.LocalDate.now());
            }
        } else {
            invoice.setDueDate(java.time.LocalDate.now());
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
        invoice.setStatus(doc.getString("status") != null ? doc.getString("status") : Constants.INVOICE_PENDING);
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
                    InvoiceItem item = new InvoiceItem(productId, productName != null ? productName : "", quantity, unitCost);
                    invoice.addItem(item);
                }
            }
        }
        return invoice;
    }
}
