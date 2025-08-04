package ru.pkgh.hive.view.typeofmisdemeanor;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import ru.pkgh.hive.entity.misdemeanor.TypeOfMisdemeanor;
import ru.pkgh.hive.view.main.MainView;


@Route(value = "type-of-misdemeanors", layout = MainView.class)
@ViewController(id = "hive_TypeOfMisdemeanor.list")
@ViewDescriptor(path = "type-of-misdemeanor-list-view.xml")
@LookupComponent("typeOfMisdemeanorsDataGrid")
@DialogMode(width = "64em")
public class TypeOfMisdemeanorListView extends StandardListView<TypeOfMisdemeanor> {
}