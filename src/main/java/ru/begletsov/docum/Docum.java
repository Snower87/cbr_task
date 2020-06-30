package ru.begletsov.docum;

import java.util.Objects;

/**
 /* Класс-данных Docum содержит данные о документе: название, время печати, типа документа, размер бумаги, состояние напечатан или нет
 * 1) создание класса Docum 2) добавил несколько констант, переопределил методы equals, hashcode
 * 3) откорректировал названия временных констант + их значения исходя из цикла работы диспетчера = 100мс
 * @author Sergei Begletsov
 * @since 30.06.2020
 * @version 3
 */

public class Docum {
    //1. Поля класса
    private String name; //имя файла
    private int timePrinting; //время печати
    private String typeFile; //наименование типа документа
    private String sizePaper; //размер бумаги
    private boolean printed; //напечатан?

    //2. Константы
    //Время измеряется в циклах, 1 цикл = 100мс
    public final static int TIME_10S = 100;
    public final static int TIME_20S = 200;
    public final static int TIME_30S = 300;
    public final static int TIME_40S = 400;

    public final static String SIZE_A5 = "A5";
    public final static String SIZE_A4 = "A4";
    public final static String SIZE_A3 = "A3";
    public final static String SIZE_A2 = "A2";
    public final static String SIZE_A1 = "A1";

    public final static String TYPE_JPG = "jpg";
    public final static String TYPE_PDF = "pdf";
    public final static String TYPE_DOCX = "docx";
    public final static String TYPE_XLSX = "xlsx";
    public final static String TYPE_BIN = "bin";

    //3. Конструктор
    public Docum(String name, int timePrinting, String extensionFile, String sizePaper) {
        this.name = name;
        this.timePrinting = timePrinting;
        this.typeFile = extensionFile;
        this.sizePaper = sizePaper;
        this.printed = false;
    }

    //4. Методы, геттеры, сеттеры
    public String getName() {
        return name;
    }

    public int getTimePrinting() {
        return timePrinting;
    }

    public String getTypeFile() {
        return typeFile;
    }

    public String getSizePaper() {
        return sizePaper;
    }

    public boolean getPrinted() {
        return printed;
    }

    public void setPrinted(boolean printed) {
        this.printed = printed;
    }

    //5. Переопределение методов equals, hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Docum docum = (Docum) o;
        return timePrinting == docum.timePrinting &&
                printed == docum.printed &&
                Objects.equals(name, docum.name) &&
                Objects.equals(typeFile, docum.typeFile) &&
                Objects.equals(sizePaper, docum.sizePaper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, timePrinting, typeFile, sizePaper, printed);
    }
}
