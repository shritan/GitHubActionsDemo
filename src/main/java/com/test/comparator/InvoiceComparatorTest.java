package com.test.comparator;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InvoiceComparatorTest {

    public static void main(final String[] args) {
        List<Invoice> invoices = InvoiceService.getInvoiceList();
        // invoices = ByLambda(invoices);
        // invoices = byUsingMethodRef(invoices);
        invoices = byStreamAPI(invoices);
        invoices.forEach(System.out::println);
    }

    static List<Invoice> ByLambda(final List<Invoice> invoices) {
        // By Using Lambada
        final Comparator<Invoice> invoicComparator = (invoice1, invoice2) -> invoice1.getCreatedOn().compareTo(invoice2.getCreatedOn());
        Collections.sort(invoices, invoicComparator);
        invoices.forEach(System.out::println);
        return invoices;
    }

    static List<Invoice> byUsingMethodRef(final List<Invoice> invoices) {
        invoices.sort(Comparator.comparing(Invoice::getCreatedOn));
        return invoices;
    }

    static List<Invoice> byStreamAPI(final List<Invoice> invoices) {
        return invoices.stream().sorted(Comparator.comparing(Invoice::getCreatedOn)).toList();
    }

    static List<Invoice> sortedByUpdateDt(final List<Invoice> invoices) {
        // invoices.stream().map(s -> LocalDateTime.parse(s.getUpdateDate(),
        // DateTimeFormatter.ISO_DATE)).ma.toList();
        invoices.sort((o1, o2) -> LocalDateTime.parse(o1.getUpdateDate()).compareTo(LocalDateTime.parse(o2.getUpdateDate())));
        // invoices.sort(Comparator.comparing(t -> LocalDate.parse(t, DateTimeFormatter.ISO_DATE)));
        return invoices;
    }

}
