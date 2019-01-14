package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Метод ввода/вывода.
     * @param question  вопрос пользователя
     * @return ответ пользователю
     * @range массив параметров
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = Integer.parseInt(this.ask(question));
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                moe.printStackTrace();
                System.out.println("Please, select key from menu!");
            } catch (NumberFormatException nfe) {
                System.out.println("Please, enter validate data again!");
            }
        } while(invalid);
        return value;
    }
}