package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает упрощённую модель данных
 * пользователя банковскими услугами.
 * @author Mikhail
 * @version 1.0
 */
public class User {
    /**
     * Поле хранит номер паспорта,
     * используется для идентификации пользователя
     */
    private String passport;
    /**
     * Поле хранит имя пользователя
     */
    private String username;

    /**
     * Конструктор объекта используется,
     * при добавлении нового пользователя в систему.
     * @param passport идентификатор пользователя
     * @param username имя пользователя
     */

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод аксессор к полю passport
     * @return возвращает значение поля passport.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод аксессор к полю passport
     * @param passport устанавливает значение поля passport
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод аксессор к полю name
     * @return возвращает поле name объекта
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод аксессор к полю
     * @param username устанавливает соответствующее поле
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
