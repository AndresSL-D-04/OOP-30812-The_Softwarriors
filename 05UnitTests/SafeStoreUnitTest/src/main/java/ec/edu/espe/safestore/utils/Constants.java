/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.utils;

/**
 *
 * @author ronal, The Softwarriors, @ESPE
 */
public class Constants {
    public static final String ROLE_MANAGER = "Manager";
    public static final String ROLE_CASHIER = "Cashier";
    
    public static final String SALE_TYPE_RETAIL = "retail";
    public static final String SALE_TYPE_WHOLESALE = "wholesale";
    
    public static final String PAYMENT_CASH = "cash";
    public static final String PAYMENT_CREDIT = "credit";
    public static final String PAYMENT_MIXED = "mixed";
    
    public static final String RESERVATION_ACTIVE = "active";
    public static final String RESERVATION_COMPLETED = "completed";
    public static final String RESERVATION_CANCELLED = "cancelled";
    public static final String RESERVATION_EXPIRED = "expired";
    
    public static final String INVOICE_PENDING = "pending";
    public static final String INVOICE_PAID = "paid";
    
    public static final String TX_DEBT = "DEBT";
    public static final String TX_PAYMENT = "PAYMENT";
    public static final String TX_INCOME = "INCOME";
    public static final String TX_EXPENSE = "EXPENSE";
    
    public static final String REPORT_SLOW_MOVING = "SLOW_MOVING";
    
    public static final double TAX_RATE = 0.15;
    
    public static final double DISCOUNT_EXPIRED = 0.50;
    public static final double DISCOUNT_LAST_WEEK = 0.30;
    public static final double DISCOUNT_TWO_WEEKS = 0.20;
    public static final double DISCOUNT_ONE_MONTH = 0.10;
    
    public static final String COLLECTION_USERS = "users";
    public static final String COLLECTION_PRODUCTS = "products";
    public static final String COLLECTION_SALES = "sales";
    public static final String COLLECTION_SALES_HOLD = "sales_hold";
    public static final String COLLECTION_COMBOS = "combos";
    public static final String COLLECTION_CREDITS = "credits";
    public static final String COLLECTION_RESERVATIONS = "reservations";
    public static final String COLLECTION_SUPPLIERS = "suppliers";
    public static final String COLLECTION_SUPPLIER_INVOICES = "supplier_invoices";
    public static final String COLLECTION_CASH_SESSIONS = "cash_sessions";
    public static final String COLLECTION_BACKUPS = "backups";
    public static final String COLLECTION_INVENTORY_LOGS = "inventory_logs";
    public static final String COLLECTION_GENERATED_REPORTS = "generated_reports";
    public static final String COLLECTION_ALERT_CONFIG = "alert_config";
    
    public static final int DEFAULT_ALERT_DAYS = 30;
    public static final int DEFAULT_RESERVATION_DAYS = 2;
    public static final int MAX_RESERVATION_DAYS = 7;
    
    public static final int MIN_PASSWORD_LENGTH = 4;
    public static final int TOKEN_EXPIRY_HOURS = 24;
}