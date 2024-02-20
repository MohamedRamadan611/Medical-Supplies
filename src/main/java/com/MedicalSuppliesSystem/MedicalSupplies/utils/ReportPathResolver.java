package com.MedicalSuppliesSystem.MedicalSupplies.utils;

import com.unilever.csm.enums.ReportsEnum;
import com.unilever.csm.model.ConstantStrings;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Mohanad.Ehab
 */
public class ReportPathResolver {

    public static String getReportPath(String reportId) {
        String reportName = getReportName(reportId);

        if (!reportName.isEmpty()) {
            return ConstantStrings.MAIN_REPORT_PATH + reportName + ConstantStrings.JASPER_EXTENSION;
        }

        return "";
    }

    public static String getReportName(String reportId) {
        if (reportId.equals(ReportsEnum.NEW_COLLECTION.getReportId())) {
            return ConstantStrings.NEW_COLLECTION_REPORT;
        } else if (reportId.equals(ReportsEnum.REJECTED_PAYMENT.getReportId())) {
            return ConstantStrings.REJECTED_PAYMENT_REPORT;
        } else if (reportId.equals(ReportsEnum.NEW_PAYMENT.getReportId())) {
            return ConstantStrings.NEW_PAYMENT_REPORT;
        } else {
            return "";
        }
    }

}
