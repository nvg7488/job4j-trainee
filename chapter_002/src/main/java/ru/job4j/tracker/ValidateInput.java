package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class ValidateInput implements Input {
    private final Input input;
    public ValidateInput(final Input input) { this.input = input; }

    @Override
    public String ask(String question) { return this.input.ask(question); }

    @Override
    public int ask(String question, int[] range) throws MenuOutException {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
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