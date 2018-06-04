/*
 * Copyright 2017 George Aristy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.llorllale.youtrack.api;

// @checkstyle AvoidStaticImport (2 lines)

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.llorllale.youtrack.api.session.PermanentToken;
import org.llorllale.youtrack.api.session.Session;
import org.stringdata.entity.FilesCopy;
import org.stringdata.entity.TimeTrack;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public final class ServiceIssues {
    private static IntegrationTestsConfig config;
    private static Session session;
    private static final String service = "Požadavek - serviska";
    private static final String type = "Typ";
    private static int year;
    private static int monthFrom;
    private static int monthTo;
    private static List<TimeTrack> timeTracks = new ArrayList<>();

    private static String pathname1 = "src\\site\\resources\\sd_in_mmb.xlsx";
    private static File f1 = new File(pathname1);

    private static String pathname2 = "src\\site\\resources\\sd_in_mmb_2018.xlsx";
    private static File f2 = new File(pathname2);

    private static Workbook wb;
    private static CellStyle tableRowStyle;
    private static CellStyle headerRowStyle;
    private static CellStyle summaryRowStyle;
    private static int startSheet = 1;
    static Integer rowNum = 0;

    public static void setup() throws Exception {
        config = new IntegrationTestsConfig();
        session = new PermanentToken(
                config.youtrackUrl(),
                config.youtrackUserToken()
        ).login();
    }

    private static void setWorksheet() throws Exception {
        InputStream inp = new FileInputStream(pathname2);
        wb = WorkbookFactory.create(inp);

        tableRowStyle = wb.createCellStyle();
        tableRowStyle.setBorderBottom(CellStyle.BORDER_THIN);
        tableRowStyle.setBorderTop(CellStyle.BORDER_THIN);
        tableRowStyle.setBorderLeft(CellStyle.BORDER_THIN);
        tableRowStyle.setBorderRight(CellStyle.BORDER_THIN);

        headerRowStyle = wb.createCellStyle();
        headerRowStyle.setFillPattern(HSSFCellStyle.BORDER_NONE);
        headerRowStyle.setFillBackgroundColor(new HSSFColor.GREY_25_PERCENT().getIndex());
        headerRowStyle.setBorderBottom(CellStyle.BORDER_THIN);
        headerRowStyle.setBorderTop(CellStyle.BORDER_THIN);
        headerRowStyle.setBorderLeft(CellStyle.BORDER_THIN);
        headerRowStyle.setBorderRight(CellStyle.BORDER_THIN);

        summaryRowStyle = wb.createCellStyle();
        summaryRowStyle.setAlignment(CellStyle.ALIGN_CENTER);
        summaryRowStyle.setBorderBottom(CellStyle.BORDER_THIN);
        summaryRowStyle.setBorderTop(CellStyle.BORDER_THIN);
        summaryRowStyle.setBorderLeft(CellStyle.BORDER_THIN);
        summaryRowStyle.setBorderRight(CellStyle.BORDER_THIN);

        startSheet++;
        rowNum = 0;
    }

    private static void setServiceHeader(Sheet sheet) {
        Row currentRow = sheet.createRow(rowNum++);
        currentRow.createCell(0).setCellValue("Název projektu");
        currentRow.getCell(0).setCellStyle(headerRowStyle);
        currentRow.createCell(1).setCellValue("Požadavek");
        currentRow.getCell(1).setCellStyle(headerRowStyle);
        currentRow.createCell(2).setCellValue("Zaměstnanec");
        currentRow.getCell(2).setCellStyle(headerRowStyle);
        currentRow.createCell(3).setCellValue("Výkazano hodin");
        currentRow.getCell(3).setCellStyle(headerRowStyle);
        currentRow.createCell(4).setCellValue("Datum výkazu");
        currentRow.getCell(4).setCellStyle(headerRowStyle);
        currentRow.createCell(5).setCellValue("Popis na výkazu");
        currentRow.getCell(5).setCellStyle(headerRowStyle);
    }


    private static void addSummaryRow(Sheet sheet, Long sumPerMonth) {
        sheet.createRow(rowNum++);
        Row currentRow = sheet.createRow(rowNum++);
        currentRow.createCell(2).setCellValue("Součet:");
        currentRow.createCell(3).setCellValue(sumPerMonth);
        currentRow = sheet.createRow(rowNum++);
        currentRow.createCell(2).setCellValue("Hodiny:");
        currentRow.createCell(3).setCellType(0);
        currentRow.getCell(3).setCellValue((double) sumPerMonth / 60);
        sheet.createRow(rowNum++);
    }

    private static void drawSheet(Project p) {
        try {
            setWorksheet();
            Sheet sheet = wb.getSheetAt(startSheet);
            wb.setSheetName(startSheet, p.name());
            rowNum = 0;
            Long sumPerMonth = 0L;
            int monthDate = monthFrom;
            Row currentRow;
            setServiceHeader(sheet);
            ListIterator<TimeTrack> it = timeTracks.listIterator();
            while (it.hasNext()) {
                rowNum++;
                TimeTrack tt = it.next();

                if (monthDate != tt.getMonthDate()) {
                    addSummaryRow(sheet, sumPerMonth);
                    setServiceHeader(sheet);
                    sumPerMonth = 0L;
                }

                currentRow = sheet.createRow(rowNum);
                currentRow.createCell(0).setCellValue(tt.getProjectName());
                currentRow.getCell(0).setCellStyle(tableRowStyle);
                currentRow.createCell(1).setCellValue(tt.getIssueName());
                currentRow.getCell(1).setCellStyle(tableRowStyle);
                currentRow.createCell(2).setCellValue(tt.getUserlogin());
                currentRow.getCell(2).setCellStyle(tableRowStyle);
                currentRow.createCell(3).setCellType(0);
                currentRow.getCell(3).setCellStyle(tableRowStyle);
                currentRow.getCell(3).setCellValue(tt.getDuration());
                currentRow.getCell(3).setCellStyle(tableRowStyle);
                currentRow.createCell(4).setCellValue(tt.getDate().format(DateTimeFormatter.ofPattern("dd.M.yyyy")).toString());
                currentRow.getCell(4).setCellStyle(tableRowStyle);
                currentRow.createCell(5).setCellValue(tt.getDescription().toString());
                currentRow.getCell(5).setCellStyle(tableRowStyle);

                monthDate = tt.getMonthDate();
                sumPerMonth += tt.getDuration();
            }

            FileOutputStream fileOut = new FileOutputStream(pathname2);

            wb.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadToTimeTrack(TimeTrack timeTrack) {
        timeTracks.add(timeTrack);
    }


    private static void issuesOfProject(Project p) throws IOException {
        for (Issue i : p.issues().stream().collect(Collectors.toList())) {
            Issue issue = p.issues().get(i.id()).get();
            AssignedField assignedField = p.issues().get(issue.id()).get().fields().stream().filter(assignedField1 -> assignedField1.name().equals(type)).findFirst().get();
            if (assignedField.value().asString().equals(service)) {

                List<TimeTrackEntry> issueTimeTracking = issue.timetracking().stream().collect(Collectors.toList());

                for (TimeTrackEntry itt : issueTimeTracking) {
                    if (itt.date().getYear() == year) {
                        loadToTimeTrack(new TimeTrack(p.name(),
                                issue.id() + " " + assignedField.value().asString(),
                                itt.author(),
                                itt.duration(),
                                itt.date(),
                                (itt.description().isPresent()) ? itt.description().get() : null));
                    }
                }
            }
        }

        Collections.sort(timeTracks);
        for (TimeTrack tt : timeTracks) {
            System.out.println(tt.toString());
        }

    }

    public static void main(String[] args) {
        try {
            new FilesCopy(f1, f2);
            setup();
            year = Integer.parseInt(args[0]);
            monthFrom = Integer.parseInt(args[1]);
            monthTo = Integer.parseInt(args[2]);
            List<Project> projects = new DefaultYouTrack(session).projects().stream().collect(Collectors.toList());
            for (Project p : projects) {
                issuesOfProject(p);

                if (p.id().equals("CM")) {
                    drawSheet(p);
                }

                timeTracks = new ArrayList<>();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
