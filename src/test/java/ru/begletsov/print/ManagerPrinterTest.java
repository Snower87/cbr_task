package ru.begletsov.print;

import org.junit.Test;
import ru.begletsov.docum.Docum;
import ru.begletsov.sort.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ManagerPrinterTest {

    //===============================================================
    //                  ТЕСТЫ НА СОРТИРОВКУ СПИСКА
    //===============================================================
    //              << сортировка по типу файла >>
    //---------------------------------------------------------------
    @Test
    public void whenAdd5DocumToListSortByTypeFileDecreaseAndPrinted5Docum() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_1S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем n-сек
        try {
            Thread.sleep(1000 + 4000 + 2000 + 1000 + 3000 + 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file4", Docum.TIME_1S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        for (Docum docum: documListExpected) {
            docum.setPrinted(true);
        }

        //4. Выполнение алгоритма: сортировка по типу документа <<по убыванию>>
        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getSortListDocByTypeFileDecrease());
    }

    @Test
    public void whenAdd5DocumToListSortByTypeFileDecreaseAndPrinted3Docum() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_1S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем n-сек
        try {
            Thread.sleep(1000 + 4000 + 2000 + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }		

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1)
        );
        for (Docum docum: documListExpected) {
            docum.setPrinted(true);
        }

        //4. Выполнение алгоритма: сортировка по типу документа <<по убыванию>>        		
        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getSortListDocByTypeFileDecrease());
    }

    @Test
    public void whenAdd5DocumToListSortByTypeFileIncreaseAndPrinted5Docum() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_1S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем n-сек
        try {
            Thread.sleep(1000 + 4000 + 2000 + 1000 + 3000 + 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }		
		
        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file4", Docum.TIME_1S, Docum.TYPE_XLSX, Docum.SIZE_A2)
        );
        for (Docum docum: documListExpected) {
            docum.setPrinted(true);
        }		

        //4. Выполнение алгоритма: сортировка по типу документа <<по возрастанию>>
        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getSortListDocByTypeFileIncrease());
    }

    @Test
    public void whenAdd5DocumToListSortByTypeFileIncreaseAndPrinted3Docum() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_1S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем n-сек
        try {
            Thread.sleep(1000 + 4000 + 2000 + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }	

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3)
        );
        for (Docum docum: documListExpected) {
            docum.setPrinted(true);
        }

        //4. Выполнение алгоритма: сортировка по типу документа <<по возрастанию>>		
        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getSortListDocByTypeFileIncrease());
    }

    //===============================================================
    //                  ТЕСТЫ НА СОРТИРОВКУ СПИСКА
    //===============================================================
    //              << сортировка по времени печати >>
    //---------------------------------------------------------------
    @Test
    public void whenAdd4DocumToListSortTimePrintingDecreaseAndPrintined4Docum() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем n-сек
        try {
            Thread.sleep(1000 + 4000 + 2000 + 3000 + 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }		

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4)
        );
        for (Docum docum: documListExpected) {
            docum.setPrinted(true);
        }		

		//4. Выполнение алгоритма: сортировка по времени печати <<по убыванию>>
        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getSortListDocByTimePrintingDecrease());
    }

    @Test
    public void whenAdd4DocumToListSortByTimePrintingDecreaseAndPrinted2Docum() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем n-сек
        try {
            Thread.sleep(1000 + 4000 + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }				

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4)
        );
        for (Docum docum: documListExpected) {
            docum.setPrinted(true);
        }				

		//4. Выполнение алгоритма: сортировка по времени печати <<по убыванию>>		
        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getSortListDocByTimePrintingDecrease());
    }

    @Test
    public void whenAdd4DocumToListSortByTimePrintingIncreaseAndPrinted4Docum() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем n-сек
        try {
            Thread.sleep(1000 + 4000 + 2000 + 3000 + 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }	

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3)
        );
        for (Docum docum: documListExpected) {
            docum.setPrinted(true);
        }				

		//4. Выполнение алгоритма: сортировка по времени печати <<по возрастанию>>
        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getSortListDocByTimePrintingIncrease());
    }

    @Test
    public void whenAdd4DocumToListSortByTimePrintingIncreaseAndPrinted2Docum() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем n-сек
        try {
            Thread.sleep(1000 + 4000 + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }			

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3)
        );
        for (Docum docum: documListExpected) {
            docum.setPrinted(true);
        }			

		//4. Выполнение алгоритма: сортировка по времени печати <<по возрастанию>>
        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getSortListDocByTimePrintingIncrease());
    }

    //===============================================================
    //                  ТЕСТЫ НА СОРТИРОВКУ СПИСКА
    //===============================================================
    //              << сортировка по размеру бумаги >>
    //---------------------------------------------------------------
    @Test
    public void wheAdd5DocumToListSortBySizePaperDecreaseAndPrinted5Docum() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_1S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем n-сек
        try {
            Thread.sleep(1000 + 4000 + 2000 + 1000 + 3000 + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }		

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5),
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file4", Docum.TIME_1S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1)
        );
        for (Docum docum: documListExpected) {
            docum.setPrinted(true);
        }

		//4. Выполнение алгоритма: сортировка по размеру бумаги <<по убыванию>>
        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getSortListDocBySizePaperDecrease());
    }

    @Test
    public void whenAdd5DocumToListSortBySizePaperDecreaseAndPrinted3Docum() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_1S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем n-сек
        try {
            Thread.sleep(1000 + 4000 + 2000 + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }			

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1)
        );
        for (Docum docum: documListExpected) {
            docum.setPrinted(true);
        }

		//4. Выполнение алгоритма: сортировка по размеру бумаги <<по убыванию>>
        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getSortListDocBySizePaperDecrease());
    }

    @Test
    public void whenAdd5DocumToListSortBySizePaperIncreaseAndPrinted5Docum() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_1S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем n-сек
        try {
            Thread.sleep(1000 + 4000 + 2000 + 1000 + 3000 + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_1S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        for (Docum docum: documListExpected) {
            docum.setPrinted(true);
        }			

		//4. Выполнение алгоритма: сортировка по размеру бумаги <<по возрастанию>>
        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getSortListDocBySizePaperIncrease());
    }

    @Test
    public void whenAdd5DocumToListSortBySizePaperIncreaseAndPrinted3Docum() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_1S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);
		
        //2. Имитация времени, ждем n-сек
        try {
            Thread.sleep(1000 + 4000 + 2000 + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }	

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4)
        );
        for (Docum docum: documListExpected) {
            docum.setPrinted(true);
        }			

		//4. Выполнение алгоритма: сортировка по размеру бумаги <<по возрастанию>>
        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getSortListDocBySizePaperIncrease());
    }

    //===============================================================
    //                  ТЕСТЫ НА СОРТИРОВКУ СПИСКА
    //===============================================================
    //              << сортировка по порядку печати >>
    //---------------------------------------------------------------
    @Test
    public void whenAdd5DocumToListSortByOrderDecreaseAndPrinted5Docum() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_1S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем n-сек
        try {
            Thread.sleep(1000 + 4000 + 2000 + 1000 + 3000 + 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5),
                new Docum("file4", Docum.TIME_1S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4)
        );
        for (Docum docum: documListExpected) {
            docum.setPrinted(true);
        }

        //4. Выполнение алгоритма: сортировка по порядку печати <<по убыванию>>
        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getSortListDocByOrderDecrease());
    }

    @Test
    public void whenAdd5DocumToListSortByOrderDecreaseAndPrinted3Docum() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_1S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем n-сек
        try {
            Thread.sleep(1000 + 4000 + 2000 + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4)
        );
        for (Docum docum: documListExpected) {
            docum.setPrinted(true);
        }

        //4. Выполнение алгоритма: сортировка по порядку печати <<по убыванию>>
        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getSortListDocByOrderDecrease());
    }

    @Test
    public void whenAdd5DocumToListSortByOrderIncreaseAndPrinted5Docum() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_1S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем n-сек
        try {
            Thread.sleep(1000 + 4000 + 2000 + 1000 + 3000 + 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_1S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        for (Docum docum: documListExpected) {
            docum.setPrinted(true);
        }

        //4. Выполнение алгоритма: сортировка по порядку печати <<по возрастанию>>
        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getSortListDocByOrderIncrease());
    }

    @Test
    public void whenAdd5DocumToListSortByOrderIncreaseAndPrinted3Docum() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_1S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_3S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем n-сек
        try {
            Thread.sleep(1000 + 4000 + 2000 + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file1", Docum.TIME_1S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_4S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_2S, Docum.TYPE_DOCX, Docum.SIZE_A1)
        );
        for (Docum docum: documListExpected) {
            docum.setPrinted(true);
        }

        //4. Выполнение алгоритма: сортировка по порядку печати <<по возрастанию>>
        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getSortListDocByOrderIncrease());
    }

    //===============================================================
    //            ТЕСТЫ НА ОТМЕНУ ПЕЧАТИ ПРИНЯТОГО ДОКУМЕНТА
    //===============================================================
    @Test
    public void whenAdd3DocumentsAtListPrintingAndImmediatelyCancelPrinting3Document() {
        //1. Входные данные
        List<Docum> documList = new ArrayList<>();
        documList.add(new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4));
        documList.add(new Docum("file2", Docum.TIME_3S, Docum.TYPE_PDF, Docum.SIZE_A3));
        documList.add(new Docum("file3", Docum.TIME_1S, Docum.TYPE_DOCX, Docum.SIZE_A1));
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем 0,1 сек
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Отменяю 3 последних документа на распечатку
        managerPrinter.cancelPrintingDocument();
        managerPrinter.cancelPrintingDocument();
        managerPrinter.cancelPrintingDocument();

        //4. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4)
        );

        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getDocumentList());
    }

    @Test
    public void whenAdd3DocumentsAtListPrintingAndImmediatelyCancelPrinting2Document() {
        //1. Входные данные
        List<Docum> documList = new ArrayList<>();
        documList.add(new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4));
        documList.add(new Docum("file2", Docum.TIME_3S, Docum.TYPE_PDF, Docum.SIZE_A3));
        documList.add(new Docum("file3", Docum.TIME_1S, Docum.TYPE_DOCX, Docum.SIZE_A1));
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем 0,1 сек
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Отменяю 2 последних документа на распечатку
        managerPrinter.cancelPrintingDocument();
        managerPrinter.cancelPrintingDocument();

        //4. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4)
        );

        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getDocumentList());
    }

    @Test
    public void whenAdd3DocumentsAtListPrintingAndImmediatelyCancelPrinting1Document() {
        //1. Входные данные
        List<Docum> documList = new ArrayList<>();
        documList.add(new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4));
        documList.add(new Docum("file2", Docum.TIME_3S, Docum.TYPE_PDF, Docum.SIZE_A3));
        documList.add(new Docum("file3", Docum.TIME_1S, Docum.TYPE_DOCX, Docum.SIZE_A1));
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем 0,1 сек
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Отменяю 1 последний документ на распечатку
        managerPrinter.cancelPrintingDocument();

        //4. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_3S, Docum.TYPE_PDF, Docum.SIZE_A3)
        );

        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getDocumentList());
    }

    @Test
    public void whenAdd5DocumentsAtListPrintingThenCancelPrinting2Document() {
        //1. Входные данные
        List<Docum> documList = new ArrayList<>();
        documList.add(new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4));
        documList.add(new Docum("file2", Docum.TIME_10S, Docum.TYPE_PDF, Docum.SIZE_A3));
        documList.add(new Docum("file3", Docum.TIME_10S, Docum.TYPE_DOCX, Docum.SIZE_A1));
        documList.add(new Docum("file4", Docum.TIME_10S, Docum.TYPE_XLSX, Docum.SIZE_A2));
        documList.add(new Docum("file5", Docum.TIME_10S, Docum.TYPE_BIN, Docum.SIZE_A5));
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем 1 сек
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Отменяю последние 2 документа на распечатку
        managerPrinter.cancelPrintingDocument();
        managerPrinter.cancelPrintingDocument();

        //4. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_10S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_10S, Docum.TYPE_DOCX, Docum.SIZE_A1)
        );

        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getDocumentList());
    }


    @Test
    public void whenAdd5DocumentsAtListPrintingThenCancelPrinting1Document() {
        //1. Входные данные
        List<Docum> documList = new ArrayList<>();
        documList.add(new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4));
        documList.add(new Docum("file2", Docum.TIME_10S, Docum.TYPE_PDF, Docum.SIZE_A3));
        documList.add(new Docum("file3", Docum.TIME_10S, Docum.TYPE_DOCX, Docum.SIZE_A1));
        documList.add(new Docum("file4", Docum.TIME_10S, Docum.TYPE_XLSX, Docum.SIZE_A2));
        documList.add(new Docum("file5", Docum.TIME_10S, Docum.TYPE_BIN, Docum.SIZE_A5));
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем 1 сек
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Отменяю последний принятый документ на распечатку
        managerPrinter.cancelPrintingDocument();

        //4. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_10S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_10S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_10S, Docum.TYPE_XLSX, Docum.SIZE_A2)
        );

        //5. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, managerPrinter.getDocumentList());
    }

    //===============================================================
    //            ТЕСТЫ НА ПРИЕМ ДОКУМЕНТОВ НА ПЕЧАТЬ
    //===============================================================
    @Test
    public void whenAdd5DocumentsAtListPrintingThenListNotNull() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_10S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_10S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_10S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_10S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем 1 сек
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Ожидаемый результат
        List<Docum> documListExpected = documList;

        //4. Выдать предупреждение, если списки равны
        assertNotEquals(new ArrayList<>(), managerPrinter.getDocumentList());
    }

    @Test
    public void whenNotDocumentsAtListPrintingThenListIsNull() {
        //1. Входные данные
        List<Docum> documList = new ArrayList<>();
        ManagerPrinter managerPrinter = new ManagerPrinter(documList);

        //2. Имитация времени, ждем 1 сек
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Выдать предупреждение, если списки не равны
        assertEquals(new ArrayList<>(), managerPrinter.getDocumentList());
    }


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