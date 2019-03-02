package ru.job4j.converter;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test методов rubleToEuro, rubleToDollar, euroToRuble, dollarToRuble
 * @author Говорухин Николай
 */
public class ConverterTest {
    /**
     * Конвертация 60 руб в $1
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60);
        assertThat(result, is(1));
    }

    /**
     * Конвертация 70 руб в 1 euro
     */
    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(70);
        assertThat(result, is(1));
    }

    /**
     * Конвертация $1 в 60 руб
     */
    @Test
    public void whenDollar1ToRubleThen60() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(1);
        assertThat(result, is(60));
    }

    /**
     * Конвертация 1 euro в 70 руб
     */
    @Test
    public void whenEuro1ToRubleThen70() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(1);
        assertThat(result, is(70));
    }
}