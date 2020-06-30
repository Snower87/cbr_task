package ru.begletsov.print;

import org.junit.Test;
import ru.begletsov.docum.Docum;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ThreadPrinterTest {

    @Test
    public void whenStartThreadPrinterThenStateWaitAtRun() {
        //1. Входные данные
        List<Docum> docToPrinter = new ArrayList<>();
        ThreadPrinter threadPrinter = new ThreadPrinter(docToPrinter);

        //2. Имитация времени, ждем 1 сек
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Выдать предупреждение, если состояние (режим) потока отличается
        assertEquals(StatePrinting.WAIT, threadPrinter.getState());
    }

    @Test
    public void whenDisabledThreadPrinterThenStateClose() {
        //1. Входные данные
        List<Docum> docToPrinter = new ArrayList<>();
        ThreadPrinter threadPrinter = new ThreadPrinter(docToPrinter);
        threadPrinter.disabled();

        //2. Имитация времени, ждем 1 сек
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Выдать предупреждение, если состояние (режим) потока отличается
        assertEquals(StatePrinting.CLOSE, threadPrinter.getState());
    }

    @Test
    public void whenStartPrintListDocumentThenStatePrinting() {
        //1. Входные данные
        List<Docum> docToPrinter = new ArrayList<>();
        ThreadPrinter threadPrinter = new ThreadPrinter(docToPrinter);

        int nFile = 1;
        docToPrinter.add(new Docum("file" + Integer.toString(nFile++), Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4));
        docToPrinter.add(new Docum("file" + Integer.toString(nFile++), Docum.TIME_40S, Docum.TYPE_PDF, Docum.SIZE_A3));

        //2. Имитация времени, ждем 1 сек
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Выдать предупреждение, если состояние (режим) потока отличается
        assertEquals(StatePrinting.PRINTING, threadPrinter.getState());
    }
}