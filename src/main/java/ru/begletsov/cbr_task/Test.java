package ru.begletsov.cbr_task;

import ru.begletsov.docum.Docum;
import ru.begletsov.print.ThreadPrinter;
import ru.begletsov.sort.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {
    //1. Поля
    List<Docum> documentList;
    ThreadPrinter myThread;
    int nFile = 0; //номер файла

    //2. Конструктор
    public Test() {
        this.documentList = new ArrayList<>();
        this.myThread = new ThreadPrinter();
    }

    @SuppressWarnings("checkstyle:SimplifyBooleanExpression")
    public void init(Scanner scanner) {
        boolean run = true;

        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Select type of document ===");
                System.out.println("1. jpg");
                System.out.println("2. pdf");
                System.out.println("3. docx");
                System.out.println("4. xsls");
                System.out.println("5. bin");
                int typeDocument = Integer.valueOf(scanner.nextLine());
                System.out.println("User select type: " + typeDocument);
                nFile++;
                switch (typeDocument) {
                    case 1:
                        documentList.add(new Docum("file" + Integer.toString(nFile), Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4));
                        break;
                    case 2:
                        documentList.add(new Docum("file" + Integer.toString(nFile), Docum.TIME_40S, Docum.TYPE_PDF, Docum.SIZE_A3));
                        break;
                    case 3:
                        documentList.add(new Docum("file" + Integer.toString(nFile), Docum.TIME_20S, Docum.TYPE_DOCX, Docum.SIZE_A1));
                        break;
                    case 4:
                        documentList.add(new Docum("file" + Integer.toString(nFile), Docum.TIME_10S, Docum.TYPE_XLSX, Docum.SIZE_A2));
                        break;
                    case 5:
                        documentList.add(new Docum("file" + Integer.toString(nFile), Docum.TIME_30S, Docum.TYPE_BIN, Docum.SIZE_A5));
                        break;
                    default:
                        System.out.println("Sorry, this document not found!");
                        break;
                }
            } else if (select == 1) {
                System.out.println("=== All documents at printing ===");
                for (Docum document: documentList) {
                    System.out.println(document.getName() + ", "
                            + document.getTimePrinting()  + ", "
                            + document.getTypeFile()  + ", "
                            + document.getSizePaper());
                }
            } else if (select == 2) {
                System.out.println("2. Stop printing documents");
                myThread.disabled();
                for (Docum document: documentList) {
                    if (document.getPrinted() == false) {
                        System.out.println(document.getName() + ", "
                                + document.getTimePrinting()  + ", "
                                + document.getTypeFile()  + ", "
                                + document.getSizePaper());
                    }
                }
            } else if (select == 3) {
                System.out.println("=== Average time printed documents ===");
                float timePrintedDocum = 0;
                int numPrintedDocum = 0;
                for (Docum docum: documentList) {
                    if (docum.getPrinted() == false) {
                        numPrintedDocum++;
                        timePrintedDocum += docum.getTimePrinting();
                    }
                }
                timePrintedDocum /= numPrintedDocum;
                System.out.println(timePrintedDocum + " sec");
            } else if (select == 4) {
                System.out.println("4. Cancel printing last document");
            } else if (select == 5) {
                System.out.println("=== Select sort printed documents ===");
                System.out.println("<<SORTING BY INCREASE>>"); //сортировка <<по возрастанию>>
                System.out.println("1. Sorting by turns"); //по очереди
                System.out.println("2. Sorting by type file"); //по типу документов
                System.out.println("3. Sorting by time printing"); //по продолжительности печати
                System.out.println("4. Sorting by size paper"); //по размеру печати
                System.out.println("<<SORTING BY DECREASE>>"); //сортировка <<по убыванию>>
                System.out.println("11. Sorting by turns"); //по очереди
                System.out.println("12. Sorting by type file"); //по типу документов
                System.out.println("13. Sorting by time printing"); //по продолжительности печати
                System.out.println("14. Sorting by size paper"); //по размеру печати
                int typeSorting = Integer.valueOf(scanner.nextLine());
                System.out.println("User select sorting: " + typeSorting);
                switch (typeSorting) {
                    case 1: // Сортировка по очереди <<по возрастанию>>

                        break;
                    case 2: // Сортировка по типу документа <<по возрастанию>>
                        Collections.sort(documentList, new DocCompByTypeFileIncrease());
                        break;
                    case 3: // Сортировка по времени печати <<по возрастанию>>
                        Collections.sort(documentList, new DocCompByTimePrintingIncrease());
                        break;
                    case 4: // Сортировка по размеру бумаги <<по возрастанию>>
                        Collections.sort(documentList, new DocCompBySizePaperIncrease());
                        break;

                    case 11: // Сортировка по очереди <<по убыванию>>

                        break;
                    case 12: // Сортировка по типу документа <<по убыванию>>
                        Collections.sort(documentList, new DocCompByTypeFileDecrease());
                        break;
                    case 13: // Сортировка по времени печати <<по убыванию>>
                        Collections.sort(documentList, new DocCompByTimePrintingDecrease());
                        break;
                    case 14: // Сортировка по размеру бумаги <<по убыванию>>
                        Collections.sort(documentList, new DocCompBySizePaperDecrease());
                        break;
                    default:
                        System.out.println("Sorry, type sorting not found!");
                        break;
                }
            } else if (select == 6) {
                run = false;
                myThread.disabled();
                System.out.println("exit, run = false");

            }
        }
    }

    public void showMenu() {
        System.out.println("------------------------");
        System.out.println("         MENU           ");
        System.out.println("------------------------");
        // добавить остальные пункты меню.
        System.out.println("0. Add new document");
        System.out.println("1. Show all documents printing");
        System.out.println("2. Stop printing documents");
        System.out.println("3. Calculate average time printing");
        System.out.println("4. Cancel printing last document");
        System.out.println("5. Sorting printed documents");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Test test = new Test();
        test.init(scanner);
    }
}
