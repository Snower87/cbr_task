package ru.begletsov.sort;

import org.junit.Test;
import ru.begletsov.docum.Docum;

import java.util.*;

import static org.junit.Assert.*;

public class DocCompBySizePaperDecreaseTest {

    @Test
    public void whenSort5DocumBySizePaperDecrease() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_40S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_20S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_10S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_30S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );

        //2. Выполнение алгоритма: сортировка по размеру бумаги <<по убыванию>>
        Collections.sort(documList, new DocCompBySizePaperDecrease());

        //3. Ожидаемый результат
        List<Docum> documListExpected = Arrays.asList(
                new Docum("file5", Docum.TIME_30S, Docum.TYPE_BIN, Docum.SIZE_A5),
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_40S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file4", Docum.TIME_10S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file3", Docum.TIME_20S, Docum.TYPE_DOCX, Docum.SIZE_A1)
        );

        //4. Выдать предупреждение, если списки не равны
        assertEquals(documListExpected, documList);
    }

    @Test
    public void whenCheckListBySizePaperDecreaseAfterSort() {
        //1. Входные данные
        List<Docum> documList = Arrays.asList(
                new Docum("file1", Docum.TIME_10S, Docum.TYPE_JPG, Docum.SIZE_A4),
                new Docum("file2", Docum.TIME_40S, Docum.TYPE_PDF, Docum.SIZE_A3),
                new Docum("file3", Docum.TIME_20S, Docum.TYPE_DOCX, Docum.SIZE_A1),
                new Docum("file4", Docum.TIME_10S, Docum.TYPE_XLSX, Docum.SIZE_A2),
                new Docum("file5", Docum.TIME_30S, Docum.TYPE_BIN, Docum.SIZE_A5)
        );

        //2. Выполнение алгоритма: сортировка по размеру бумаги <<по убыванию>>
        Collections.sort(documList, new DocCompBySizePaperDecrease());

        //3. Получение размера бумаги из сортированных данных по размеру бумаги <<по убыванию>>
        List<String> sizePaper = new LinkedList<>();
        for (Docum docum: documList) {
            sizePaper.add(docum.getSizePaper());
        }

        //4. Ожидаемый результат
        List<String> sizePaperExpected = Arrays.asList(
                new String("A5"),
                new String("A4"),
                new String("A3"),
                new String("A2"),
                new String("A1")
        );

        //5. Выдать предупреждение, если списки не равны
        assertEquals(sizePaperExpected, sizePaper);
    }
}