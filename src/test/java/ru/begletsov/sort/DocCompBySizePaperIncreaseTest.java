package ru.begletsov.sort;

import org.junit.Test;
import ru.begletsov.docum.Docum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class DocCompBySizePaperIncreaseTest {

    @Test
    public void whenSort5DocumBySizePaperIncrease() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_10s, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_40s, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_20s, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_10s, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_30s, Docum.TYPE_BIN, Docum.SIZE_A5)
        );

        //2. Выполнение алгоритма: сортировка по размеру бумаги <<по возрастанию>>
        Collections.sort(documList, new DocCompBySizePaperIncrease());

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file3", Docum.TIME_20s, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_10s, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file2", Docum.TIME_40s, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file1", Docum.TIME_10s, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file5", Docum.TIME_30s, Docum.TYPE_BIN, Docum.SIZE_A5)
        );

        //4. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, documList);
    }
}