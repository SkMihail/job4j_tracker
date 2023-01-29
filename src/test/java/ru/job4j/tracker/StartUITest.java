package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[]{"0", "Test", "1"});
        Tracker tracker = new Tracker();
        UserAction[] action = {new CreateAction(), new ExitAction()};
        new StartUI().init(in, tracker, action);
        assertThat(tracker.findById(1).getName()).isEqualTo("Test");
    }

    @Test
    public void myTestWhenEditItem() {
        Input in = new StubInput(new String[]{"0", "Test Name", "1", "1", "New Name", "2"});
        Tracker tracker = new Tracker();
        UserAction[] action = {new CreateAction(), new EditAction(), new ExitAction()};
        new StartUI().init(in, tracker, action);
        assertThat(tracker.findById(1).getName()).isEqualTo("New Name");
    }

    @Test
    public void myTestWhenDeleteItem() {
        Input in = new StubInput(new String[]{"0", "Test", "1", "1", "2"});
        Tracker tracker = new Tracker();
        UserAction[] action = {new CreateAction(), new DeleteAction(), new ExitAction()};
        new StartUI().init(in, tracker, action);
        assertThat(tracker.findById(1)).isNull();
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[]{"0", "1", replacedName, "1"});
        UserAction[] actions = {new EditAction(), new ExitAction()};
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new String[]{"0", "1", "1"});
        UserAction[] actions = {new DeleteAction(), new ExitAction()};
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }
}