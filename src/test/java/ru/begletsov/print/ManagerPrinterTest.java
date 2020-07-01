package ru.begletsov.print;

import org.junit.Test;
import ru.begletsov.docum.Docum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ManagerPrinterTest {

    //===============================================================
    //                ТЕСТЫ НА ОСТАНОВ ДИСПЕТЧЕРА
    //        С ВЫВОДОМ СПИСКА НЕНАПЕЧАТАННЫХ ДОКУМЕНТОВ
    //===============================================================
    @Test
    public void whenAdd5DocumentsAtListAndStopPrintingAfterFiveDocumentThenListIsNull() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_10S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_10S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_10S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_10S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем 55 сек
        try {
            Thread.sleep(55000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Ожидаемый результат
        List<Docum> documListExpected = new ArrayList<>();

        //4. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.stopPrinting());
    }

    @Test
    public void whenAdd5DocumentsAtListAndStopPrintingAfterTherdDocumentThenListIs2Document() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_10S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_20S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_10S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_30S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем 44 сек
        try {
            Thread.sleep(44000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file4", Docum.TIME_10S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_30S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );

        //4. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.stopPrinting());
    }

    @Test
    public void whenAdd5DocumentsAtListAndStopPrintingAfterSecondDocumentThenListIs3Document() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_10S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_20S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_10S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_30S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем 22 сек
        try {
            Thread.sleep(22000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file3", Docum.TIME_20S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_10S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_30S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );

        //4. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.stopPrinting());
    }

    @Test
    public void whenAdd5DocumentsAtListAndStopPrintingAfterFirstDocumentThenListIs4Document() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_40S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_20S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_10S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_30S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем 11 сек
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file2", Docum.TIME_40S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_20S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_10S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_30S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );

        //4. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.stopPrinting());
    }

    @Test
    public void whenAdd5DocumentsAtListAndStopPrintingAtFirstDocumentThenListIs5Document() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_40S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_20S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_10S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_30S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем 2 сек
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_40S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_20S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_10S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_30S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );

        //4. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.stopPrinting());
    }


    //===============================================================
    //      ТЕСТЫ НА РАСЧЕТ СРЕДНЕЙ ПРОДОЛЖИТЕЛЬНОСТИ ПЕЧАТИ
    //               НАПЕЧАТАННЫХ ДОКУМЕНТОВ
    //===============================================================
    @Test
    public void whenPrinting1DocumentThenAverageTimePrintingIs10sec() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем 11 сек
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Выдать предупреждение, если время не равно
        assertEquals(Docum.TIME_10S, managerPrinter.calcAverageTimePrinting(),0.01);
    }

    @Test
    public void whenPrinting2DocumentThenAverageTimePrintingIs15sec() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_20S, Docum.TYPE_DOCX, Docum.SIZE_A1)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем 35 сек
        try {
            Thread.sleep(35000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Ожидаемое значение
        float avrTimePrintingExpected = (Docum.TIME_10S + Docum.TIME_20S) / 2;

        //4. Выдать предупреждение, если время не равно
        assertEquals(avrTimePrintingExpected, managerPrinter.calcAverageTimePrinting(),0.01);
    }

    @Test
    public void whenPrinting3DocumentThenAverageTimePrintingIs13_3sec() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_20S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file3", Docum.TIME_10S, Docum.TYPE_XLSX, Docum.SIZE_A2)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем 45 сек
        try {
            Thread.sleep(45000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Ожидаемое значение
        float avrTimePrintingExpected = ((float) (Docum.TIME_10S + Docum.TIME_20S + Docum.TIME_10S) )/ 3;

        //4. Выдать предупреждение, если время не равно
        assertEquals(avrTimePrintingExpected, managerPrinter.calcAverageTimePrinting(),0.01);
    }

    @Test
    public void whenStartPrinting1DocumentAndNotEndedThenAverageTimePrintingIs0sec() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Выдать предупреждение, если время не равно
        assertEquals(0, managerPrinter.calcAverageTimePrinting(),0.01);
    }
}