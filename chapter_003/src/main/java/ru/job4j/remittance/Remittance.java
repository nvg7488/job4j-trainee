package ru.job4j.remittance;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Remittance {
    private Map<User, List<Account>> expenses = new HashMap<>();

    /**   Добавление нового пользователя.   */
    public void addUser(User user) {
        if (user != null) {
            expenses.putIfAbsent(user, new ArrayList<>());
        }
    }

    /**   Удаление пользователя.   */
    public void deleteUser(User user) {
    }
    /**   Добавление счёта зарегистрированному пользователю.   */
    public void addAccountToUser(String passport, Account account) {
    }
    /**   Уладение счёта у зарегистрированного пользователя.   */
    public void deleteAccountFromUser(String passport, Account account) {
    }
    /**   Получяет список счетов для пользователя.   */
    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = new ArrayList<>();
        return accounts;
    }
    /**
     * Метод для перечисления денег с одного счёта на другой счёт:
     * если счёт не найден
     * или не хватает денег на счёте с которого переводят,
     * должен вернуть false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount) {
        return true;
    }

    public int sizeUser() {
        int result = 0;
        if (expenses != null) {
            result = expenses.size();
        }
        return result;
    }
}