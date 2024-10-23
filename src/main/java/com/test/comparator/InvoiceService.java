package com.test.comparator;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class InvoiceService {
    public static List<Invoice> getInvoiceList() {
        return Arrays.asList(
            new Invoice(101, 496.67, "SQ078OPQ", LocalDate.parse("2020-04-24"), "2020-04-24"),
            new Invoice(102, 229.75, "QJ098OJH", LocalDate.parse("2020-09-24"), "2020-09-24"),
            new Invoice(103, 494.28, "RT048OQT", LocalDate.parse("2021-04-21"), "2021-04-21"),
            new Invoice(103, 195.56, "SR048OPR", LocalDate.parse("2021-04-22"), "2021-04-22"),
            new Invoice(103, 285.50, "JT048OTK", LocalDate.parse("2019-12-19"), "2019-12-19"));
    }

    private InvoiceService() {

    }
}
