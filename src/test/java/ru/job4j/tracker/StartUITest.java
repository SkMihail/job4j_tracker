package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[]{"0", "Test", "1"});
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        List<UserAction> action = List.of(new CreateAction(out), new ExitAction(out));
        new StartUI(out).init(in, tracker, action);
        assertThat(tracker.findById(1).getName()).isEqualTo("Test");
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), replacedName, "1"});
        Output out = new StubOutput();
        List<UserAction> action = List.of(new EditAction(out), new ExitAction(out));
        new StartUI(out).init(in, tracker, action);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), "1"});
        Output out = new StubOutput();
        List<UserAction> action = List.of(new DeleteAction(out), new ExitAction(out));
        new StartUI(out).init(in, tracker, action);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        List<UserAction> action = List.of(new ExitAction(out));
        new StartUI(out).init(in, tracker, action);
        assertThat(out.toString()).isEqualTo(
                "Menu:" + System.lineSeparator()
                                + "0. Exit Program" + System.lineSeparator()
                                + "=== Exit Program ===" + System.lineSeparator()
        );
    }

    @Test
    public void whenEditItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> action = List.of(new EditAction(out), new ExitAction(out));
        new StartUI(out).init(in, tracker, action);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindAllItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("New Test Name"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        List<UserAction> action = List.of(new ShowAllAction(out), new ExitAction(out));
        new StartUI(out).init(in, tracker, action);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + two + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindByNameItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String findName = "test1";
        Input in = new StubInput(
                new String[] {"0", findName, "1"}
        );
        List<UserAction> action = List.of(new FindByNameAction(out), new ExitAction(out));
        new StartUI(out).init(in, tracker, action);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindByIDItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), "1"}
        );
        List<UserAction> action = List.of(new FindByIDAction(out), new ExitAction(out));
        new StartUI(out).init(in, tracker, action);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenInvalidEnterThenExit() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"3", "0"}
        );
        List<UserAction> action = List.of(new ExitAction(out));
        new StartUI(out).init(in, tracker, action);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }
}