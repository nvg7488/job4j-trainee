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
        if (user != null) {
            expenses.remove(user);
        }
    }

    /**   Добавление счёта зарегистрированному пользователю.   */
    public void addAccountToUser(String passport, Account account) {
        List<Account> list = null;
        for (User user : expenses.keySet()) {
            if ((passport.equals(user.setPassport())) && (account != null)) {
                list = expenses.get(user);
                list.add(account);
                break;
            }
        }
    }

    /**   Уладение счёта у зарегистрированного пользователя.   */
    public void deleteAccountFromUser(String passport, Account account) {
        for (User user : expenses.keySet()) {
            if ((passport.equals(user.setPassport())) && (account != null)) {
                List<Account> list = expenses.get(user);
                list.remove(account);
                break;
            }
        }
    }

    /**   Получяет список счетов для пользователя.   */
    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = new ArrayList<>();
        for (User user : expenses.keySet()) {
            if (passport.equals(user.setPassport())) {
                accounts = expenses.get(user);
                break;
            } else {
                accounts = null;
            }
        }
        return accounts;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт:
     * если счёт не найден
     * или не хватает денег на счёте с которого переводят,
     * должен вернуть false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String dstPassport, String dstRequisite,
                                 double amount) {
//        for (User srcUser : expenses.keySet()) {
//            for (User dstUser : expenses.keySet()) {
////                dstList = expenses.get(dstUser);
////                for (Account srcAccount : srcUser) {}
//            }
//        }

        boolean result = false;
        return result;

//        final List<Account> list = bankMap.get(dstUser);
//        if ((list.contains(dstAccount)) && (srcAccount.checkValue(amount))) {
//            srcAccount.withdraw(amount);
//            dstAccount.deposit(amount);
//            result = true;
//        }
    }

    public List<Account> findAccountPassport(String passport) {
        List<Account> result = null;
        for (User user : expenses.keySet()) {
            if (passport.equals(user.setPassport())) {
                result = expenses.get(user);
                break;
            }
        }
        return result;
    }

    public int sizeUser() {
        int result = 0;
        if (expenses != null) {
            result = expenses.size();
        }
        return result;
    }
}