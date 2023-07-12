package com.example.application.views.main;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@PageTitle("Main")
@Route(value = "")
public class MainView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    private ComboBox<Person> personComboBox;

    public MainView() {
        name = new TextField("Your name");
        sayHello = new Button("Say hello");
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + (personComboBox.getValue() == null ? "Null" : personComboBox.getValue().getName()));
        });
        sayHello.addClickShortcut(Key.ENTER);

        List<Person> people = generateListOfPeople();
        personComboBox = new ComboBox<>("Select person", people);
        // Why is this triggered by the UI with no action other than a click anywhere in the browser???
        personComboBox.addValueChangeListener(event -> System.out.println("Selected person: " + event.getValue()));
        personComboBox.setItemLabelGenerator(person -> person.getName());

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);

        add(name, sayHello);
        add(personComboBox);
    }

    private List<Person> generateListOfPeople() {
        return List.of(
                new Person("John"),
                new Person("Jane"),
                new Person(""),
                new Person(""));
    }
}
