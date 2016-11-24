package com.company;

/**
 * Created by Ксения on 10.11.2016.
 */
import java.io.*;

/*
прописываем класс, который связывается с файлом и считывает оттуда данные
 */
public class Reader {
    // поле, имеющее тип встроенного класса для чтения
    private BufferedReader reader;

    // конструктор - связываем поле reader с конкретным файлом
    public Reader(String filename) {
        // try - блок, в котором возможны какие-либо исключения
        try {
            // подключили файл к полю reader
            this.reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        }
        // catch - что делаем, если словили исключение
        catch (FileNotFoundException e) {
            System.err.print("File not found");
        }
    }

    // считывает следующие значения из файла
    public Pair readPair() {
        // строка для хранения значений валютной пары
        String pairLine;
        Pair pair = new Pair();
        try {
            // считали строку
            pairLine = reader.readLine();

            if (pairLine == null) {
                return null;
            }

            //разбили строку на подстроки на основании встреченного разделителя - символа табуляции
            String[]lines = pairLine.split("\t");

            String date = lines[0];
            String time = lines[1];
            String openAsString = lines[2];
            String highAsString = lines[3];
            String lowAsString = lines[4];
            String closeAsString = lines[5];
            String volAsString = lines[6];

            // конвертация строки в число
            double open = Double.parseDouble(openAsString);
            double high = Double.parseDouble(highAsString);
            double low = Double.parseDouble(lowAsString);
            double close = Double.parseDouble(closeAsString);
            int vol = Integer.parseInt(volAsString);

            pair = new Pair(date, time, open, high, low, close, vol);
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }

        return pair;
    }
}
