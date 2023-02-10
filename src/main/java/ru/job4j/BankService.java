package ru.job4j;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает упрощённую модель работы
 * банковского сервиса.
 * @author Mikhail
 * @version 1.0
 */
public class BankService {
    /**
     * Пользователи банка и их счета хранятся в коллекции HashMap
     * ключём в коллекции является User, значением список счетов.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет новго пользователя в список users.
     * @param user пользователь которого добавляют в users.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя из списка users.
     * @param passport испоьлзуется для поиска уникального пользователя
     * @return если пользователь найден и удалён, возвращает true, иначе false.
     */
    public boolean deleteUser(String passport) {
        return null != users.remove(new User(passport, null));
    }

    /**
     * Метод осуществляет поиск пользователя в списке user,
     * и добавляет новый счет
     * @param passport используется для поиска уникального user
     * @param account новый счет который добавляется user в коллекции users.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> temp = users.get(user);
        if (temp != null && !temp.contains(account)) {
            temp.add(account);
        }
    }

    /**
     * Метод позволяет найти пользователя в списке users
     * метод используется в {@link #addAccount(String, Account)} {@link #findByRequisite(String, String)}
     * @param passport используется для поиска уникального user
     * @return возвращает пользователя User с указанным passport
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод используется для поиска счета {@link Account} у пользователя {@link User user}
     * в коллекции  users.
     * @param passport идентификатор для поиска пользователя.
     * @param requisite идентификатор для поиска пользовательского счета.
     * @return возвращает Account account пользователя.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> accs = users.get(user);
        if (accs == null) {
            return null;
        }
        for (Account acc : accs) {
            if (acc.getRequisite().equals(requisite)) {
                return acc;
            }
        }
        return null;
    }

    /**
     * Метод используется для перевода денежных средств со счета пользователя на другой счет.
     * В методе валидируется наличие пользователей отправляющего и принимающего платёж, и налчичие  средств
     * на счету отправителя платежа.
     * @param srcPassport Идентификатор пользователя со счета которого будут списаны деньги.
     * @param srcRequisite Идентификатор пользовательского счета с которого будут списаны деньги.
     * @param destPassport Идентификатор пользователя на счет которого будут зачислены деньги.
     * @param destRequisite Идентификатор пользовательского счета на счет которого будут зачислены деньги.
     * @param amount сумма к переводу/списанию
     * @return возвращает true в случае успещного перевода. false в случае не перевода.
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src == null || dest == null || src.getBalance() < amount) {
            return false;
        }
        src.setBalance(src.getBalance() - amount);
        dest.setBalance((dest.getBalance() + amount));
        return true;
    }

    /**
     * Метод для получения списка счетов пользователя {user}
     * @param user пользователь чьи счета нужно получить
     * @return вовзращает List счетов пользователя {user}
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}