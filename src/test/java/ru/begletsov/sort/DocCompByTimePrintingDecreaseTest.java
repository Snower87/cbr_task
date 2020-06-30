package ru.begletsov.sort;

import org.junit.Test;
import ru.begletsov.docum.Docum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class DocCompByTimePrintingDecreaseTest {

    @Test
    public void whenSort4DocumByTimePrintingDecrease() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_40S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_20S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file5", Docum.TIME_30S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );

        //2. Выполнение алгоритма: сортировка по времени печати <<по убыванию>>
        Collections.sort(documList, new DocCompByTimePrintingDecrease());

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file2", Docum.TIME_40S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file5", Docum.TIME_30S, Docum.TYPE_BIN, Docum.SIZE_A5),
                new Docum("file3", Docum.TIME_20S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4)
        );

        //4. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, documList);
    }
}