package ru.begletsov.docum;

/**
 /* Класс-данных Docum содержит данные о документе: название, время печати, типа документа, размер бумаги, состояние напечатан или нет
 * 1) создание класса Docum
 * @author Sergei Begletsov
 * @since 29.06.2020
 * @version 1
 */

public class Docum {
    //1. Поля класса
    private String name; //имя файла
    private int timePrinting; //время печати
    private String typeFile; //наименование типа документа
    private String sizePaper; //размер бумаги
    private boolean printed; //напечатан?

    //2. Константы
    final static int TIME_10s = 10;
    final static int TIME_20s = 20;
    final static int TIME_30s = 30;

    final static String SIZE_A4 = "A4";
    final static String SIZE_A3 = "A3";
    final static String SIZE_A2 = "A2";

    final static String TYPE_JPG = "jpg";
    final static String TYPE_PDF = "pdf";
    final static String TYPE_DOCX = "docx";

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

    public boolean isPrinted() {
        return printed;
    }

    public void setPrinted(boolean printed) {
        this.printed = printed;
    }
}
