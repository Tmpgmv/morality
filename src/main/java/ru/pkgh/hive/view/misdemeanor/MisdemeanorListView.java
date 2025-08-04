package ru.pkgh.hive.view.misdemeanor;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import ru.pkgh.hive.entity.misdemeanor.Misdemeanor;
import ru.pkgh.hive.view.main.MainView;


@Route(value = "misdemeanors", layout = MainView.class)
@ViewController(id = "hive_Misdemeanor.list")
@ViewDescriptor(path = "misdemeanor-list-view.xml")
@LookupComponent("misdemeanorsDataGrid")
@DialogMode(width = "64em")
public class MisdemeanorListView extends StandardListView<Misdemeanor> {
}