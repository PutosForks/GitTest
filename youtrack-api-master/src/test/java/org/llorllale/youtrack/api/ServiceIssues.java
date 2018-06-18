package org.llorllale.youtrack.api;

// @checkstyle AvoidStaticImport (2 lines)

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.llorllale.youtrack.api.session.PermanentToken;
import org.llorllale.youtrack.api.session.Session;
import org.stringdata.entity.FilesCopy;
import org.stringdata.entity.TimeTrack;

import java.io.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
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
    private static Map<String, Double> summaryRows = new HashMap<>();

    private static String pathname1 = "src\\site\\resources\\sd_in_mmb.xlsx";
    private static File f1 = new File(pathname1);

    private static String pathname2 = "src\\site\\resources\\sd_in_mmb_2018.xlsx";
    private static File f2 = new File(pathname2);

    private static Workbook workbook;
    private static CellStyle tableStyle;
    private static CellStyle headerStyle;
    private static CellStyle summaryStyle;
    private static int startSheet = 2;
    private static Map<String, String> users = new HashMap<>();
    static Integer rowNum = 0;

    public static void setup() throws Exception {
        config = new IntegrationTestsConfig();
        session = new PermanentToken(
                config.youtrackUrl(),
                config.youtrackUserToken()
        ).login();
    }


    public static void deletedUsers() {
        users.put("system_user@b8XoJZ1eDW", "Adam Neco");
    }


    private static String getAuthor(String login, TimeTrackEntry itt, Project p) throws IOException {
        String value;
        if (users.containsKey(login)) {
            return users.get(login);
        } else if (login.equals("system_user@b8XoJZ1eDW") && p.id().equals("EA")) {
            users.put("Vlada Adamovsky", "Vlada Adamovsky");
            return "Vlada Adamovsky";
        } else if (login.equals("system_user@b8XoJZ1eDW")) {
            users.put("Tomas Morong", "Tomas Morong");
            return "Tomas Morong";
        } else {
            value = p.users().user(login).email().replace("@stringdata.cz", "").replace(".", " ");
            users.put(login, value);
            return value;
        }

    }

    private static void setWorkBook() throws Exception {
        InputStream inp = new FileInputStream(pathname2);
        workbook = WorkbookFactory.create(inp);
    }


    private static void closeWorkbook() throws Exception {
        FileOutputStream fileOut = new FileOutputStream(pathname2);
        workbook.write(fileOut);
        fileOut.close();
    }

    private static void setWorksheet() {
        tableStyle = workbook.createCellStyle();
        tableStyle.setBorderBottom(CellStyle.BORDER_THIN);
        tableStyle.setBorderTop(CellStyle.BORDER_THIN);
        tableStyle.setBorderLeft(CellStyle.BORDER_THIN);
        tableStyle.setBorderRight(CellStyle.BORDER_THIN);

        headerStyle = workbook.createCellStyle();
        headerStyle.setFillPattern(HSSFCellStyle.LEAST_DOTS);
        headerStyle.setFillBackgroundColor(new HSSFColor.GREY_25_PERCENT().getIndex());
        headerStyle.setFillForegroundColor(new HSSFColor.GREY_25_PERCENT().getIndex());
        headerStyle.setBorderBottom(CellStyle.BORDER_THIN);
        headerStyle.setBorderTop(CellStyle.BORDER_THIN);
        headerStyle.setBorderLeft(CellStyle.BORDER_THIN);
        headerStyle.setBorderRight(CellStyle.BORDER_THIN);

        summaryStyle = workbook.createCellStyle();
        summaryStyle.setAlignment(CellStyle.ALIGN_CENTER);
        summaryStyle.setBorderBottom(CellStyle.BORDER_THIN);
        summaryStyle.setBorderTop(CellStyle.BORDER_THIN);
        summaryStyle.setBorderLeft(CellStyle.BORDER_THIN);
        summaryStyle.setBorderRight(CellStyle.BORDER_THIN);
        Font summaryFont = workbook.createFont();
        summaryFont.setBold(true);
        summaryStyle.setFont(summaryFont);

        startSheet++;
        rowNum = 0;
    }

    private static void setCellValue(Row currentRow, int cellIndex, String value, CellStyle cellStyle) {
        currentRow.createCell(cellIndex).setCellValue(value);
        currentRow.getCell(cellIndex).setCellStyle(cellStyle);
    }

    private static void setCellValue(Row currentRow, int cellIndex, double value, CellStyle cellStyle) {
        currentRow.createCell(cellIndex).setCellValue(value);
        currentRow.getCell(cellIndex).setCellStyle(cellStyle);
    }

    private static void setCellValue(Row currentRow, int cellIndex, Date value, CellStyle cellStyle) {
        currentRow.createCell(cellIndex).setCellValue(value);
        currentRow.getCell(cellIndex).setCellStyle(cellStyle);
    }

    private static void setServiceHeader(Sheet sheet) {
        Row currentRow = sheet.createRow(rowNum++);
        setCellValue(currentRow, 0, "Název projektu", headerStyle);
        setCellValue(currentRow, 1, "Požadavek", headerStyle);
        setCellValue(currentRow, 2, "Zaměstnanec", headerStyle);
        setCellValue(currentRow, 3, "Výkazano hodin", headerStyle);
        setCellValue(currentRow, 4, "Datum výkazu", headerStyle);
        setCellValue(currentRow, 5, "Popis na výkazu", headerStyle);
    }


    private static void addSummaryRow(Sheet sheet, Long sumPerMonth, String projectName, int month) {
        sheet.createRow(rowNum++);
        Double sumHours = (double) sumPerMonth / 60;
        Row currentRow = sheet.createRow(rowNum++);
        setCellValue(currentRow, 2, "Součetu", summaryStyle);
        setCellValue(currentRow, 3, sumPerMonth, summaryStyle);
        currentRow = sheet.createRow(rowNum++);
        setCellValue(currentRow, 2, "Hodiny", summaryStyle);
        setCellValue(currentRow, 3, sumHours, summaryStyle);
        sheet.createRow(rowNum++);
        // if (!sumPerMonth.equals(""))
        summaryRows.put(projectName + "" + "01-0" + month+ "-" + year, sumHours);

    }

    private static void drawSummarySheet() {
        int row = 499;
        Sheet sheet = workbook.getSheetAt(0);
        Row currentRow = sheet.createRow(row);
        Iterator it = summaryRows.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            currentRow = sheet.createRow(row++);
            currentRow.createCell(0).setCellValue((String) pair.getKey());
            currentRow.createCell(1).setCellValue((Double) pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    private static void drawSheet(Project p) {
        try {
            setWorksheet();
            Sheet sheet = workbook.getSheetAt(startSheet);
            workbook.setSheetName(startSheet, p.name());
            Long sumPerMonth = 0L;
            int monthDate = monthFrom;
            Row currentRow;
            setServiceHeader(sheet);
            ListIterator<TimeTrack> it = timeTracks.listIterator();
            while (it.hasNext()) {
                TimeTrack tt = it.next();

                if (tt.getMonthDate() > monthTo) {
                    break;
                }

                if (monthDate != tt.getMonthDate()) {
                    addSummaryRow(sheet, sumPerMonth, tt.getProjectName(), monthDate);
                    setServiceHeader(sheet);
                    sumPerMonth = 0L;
                }

                currentRow = sheet.createRow(rowNum++);
                currentRow.createCell(0).setCellValue(tt.getProjectName());
                currentRow.getCell(0).setCellStyle(tableStyle);
                currentRow.createCell(1).setCellValue(tt.getIssueName());
                currentRow.getCell(1).setCellStyle(tableStyle);
                currentRow.createCell(2).setCellValue(tt.getUserlogin());
                currentRow.getCell(2).setCellStyle(tableStyle);
                currentRow.createCell(3).setCellType(0);
                currentRow.getCell(3).setCellStyle(tableStyle);
                currentRow.getCell(3).setCellValue(tt.getDuration());
                currentRow.getCell(3).setCellStyle(tableStyle);
                currentRow.createCell(4).setCellValue(tt.getDate().format(DateTimeFormatter.ofPattern("dd.M.yyyy")).toString());
                currentRow.getCell(4).setCellStyle(tableStyle);
                currentRow.createCell(5).setCellValue(tt.getDescription().toString());
                currentRow.getCell(5).setCellStyle(tableStyle);

                monthDate = tt.getMonthDate();
                sumPerMonth += tt.getDuration();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadToTimeTrack(TimeTrack timeTrack) {
        timeTracks.add(timeTrack);
    }


    private static void issuesOfProject(Project p) throws IOException {
        String description = null;
        List<Issue> issues = p.issues().stream().collect(Collectors.toList());
        for (Issue issue : issues) {

            Optional<AssignedField> assignedField = issue.fields().stream().filter(assignedField1 -> assignedField1.issue().id().equals(issue.id()) &&
                    assignedField1.name().equals(type) && assignedField1.value().asString().equals(service)).findAny();
            if (assignedField.isPresent()) {

                List<TimeTrackEntry> issueTimeTracking = issue.timetracking().stream().collect(Collectors.toList());

                for (TimeTrackEntry itt : issueTimeTracking) {

                    if (itt.date().getYear() == year) {

                        try {
                            description = itt.description().get();
                        } catch (Exception e) {
                            description = "";
                        }

                        loadToTimeTrack(new TimeTrack(p.name(),
                                issue.id() + " " + issue.summary(),
                                getAuthor(itt.author(), itt, p),
                                itt.duration(),
                                itt.date(),
                                description));
                    }
                }
            }
        }

        Collections.sort(timeTracks);

    }

    public static void main(String[] args) {
        try {
            new FilesCopy(f1, f2);
            setup();
            setWorkBook();
            year = Integer.parseInt(args[0]);
            monthFrom = Integer.parseInt(args[1]);
            monthTo = Integer.parseInt(args[2]);
            List<Project> projects = new DefaultYouTrack(session).projects().stream().collect(Collectors.toList());
            for (Project p : projects) {
                if (p.id().equals("ML") || p.id().equals("SDX")) {
                    continue;
                }
                System.out.println(p.name());
                issuesOfProject(p);
                System.out.println(DateTimeFormatter.ofPattern("hh:mm:ss").format(ZonedDateTime.now()) + " " + p.name() + " proccessed ");
                drawSheet(p);
                timeTracks = new ArrayList<>();
            }

            drawSummarySheet();
            HSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
            closeWorkbook();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
