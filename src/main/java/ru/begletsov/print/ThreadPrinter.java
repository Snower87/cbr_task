package ru.begletsov.print;

/**
 /* Класс-поток ThreadPrinter отслеживает и задает состояние диспетчера принтера
 * 1) создание класса
 * @author Sergei Begletsov
 * @since 29.06.2020
 * @version 1
 */

public class ThreadPrinter implements Runnable {
    //1. Поля
    Thread t;
    private boolean isActive; //активность потока: true - работает, false - не работает
    private StatePrinting state; //состояние диспетчера
    int indexDocument; //индекс документа, который печатается

    //2. Конструктор
    public ThreadPrinter() {
        t = new Thread(this, "ThreadPrinter");
        t.start();
        this.isActive = true;
        this.state = StatePrinting.WAIT;
        this.indexDocument = 0;
    }

    //3. Методы:
    /**
     * 3.1 Деактивация, отключение потока
     */
    public void disabled() {
        this.isActive = false;
    }

    /**
     * 3.2 Переопределенный метод run()
     */
    @Override
    public void run() {
        int counter = 1;
        while (isActive) {
            try {
                Thread.sleep(100);
                switch (state) {
                    case WAIT:
                        this.state = StatePrinting.PRINTING;
                        break;
                    case PRINTING:
                        break;
                    case CLOSE:
                        this.indexDocument = 0;
                        this.isActive = false;
                        break;
                    default:
                        break;
                }
                counter++;
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
        }
    }
}

/**
 * Cостояния диспетчера печати документов:
 * PRINTING - распечатка документа,
 * WAIT - ожидание документов на печать,
 * CLOSE - прерывание работы, закрытие портов
 */
enum StatePrinting {
    PRINTING,
    WAIT,
    CLOSE
}