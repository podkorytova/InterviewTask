package com.podkorytova;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest {
    private ByteArrayOutputStream out;

    @BeforeMethod
    public void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterMethod
    public void tearDown() {
        System.setOut(System.out);
    }

    @DataProvider
    public Object[][] testDataSet() {
        return new Object[][]{
                // Проверяем, что приложение запускается и работает
                {new String[]{"1"}, "1.0"},
                // Проверяем все виды вещественных чисел(основной функционал)
                {new String[]{"2.0"}, "0.5"},
                {new String[]{"3"}, "0.3333333333333333"},
                {new String[]{"-1"}, "-1.0"},
                {new String[]{"1000000000"}, "1.0E-9"},
                {new String[]{"1.0E-9"}, "9.999999999999999E8"},
                // Проверяем граничные и недопустимые значения
                {new String[]{"0"}, "Infinity"},
                {new String[]{"1", "2"}, App.ERROR_MANY},
                {new String[]{}, App.ERROR_EMPTY},
                {new String[]{"qwe"}, App.ERROR_NUMBER},
        };
    }

    @Test(dataProvider = "testDataSet")
    public void testCalc(String[] x, String res) throws Exception {
        App.main(x);
        Assert.assertEquals(out.toString(), res);
    }
}
