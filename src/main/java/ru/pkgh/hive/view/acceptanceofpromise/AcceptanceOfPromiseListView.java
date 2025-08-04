package ru.pkgh.hive.view.acceptanceofpromise;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import ru.pkgh.hive.entity.promise.AcceptanceOfPromise;
import ru.pkgh.hive.view.main.MainView;


@Route(value = "acceptance-of-promises", layout = MainView.class)
@ViewController(id = "hive_AcceptanceOfPromise.list")
@ViewDescriptor(path = "acceptance-of-promise-list-view.xml")
@LookupComponent("acceptanceOfPromisesDataGrid")
@DialogMode(width = "64em")
public class AcceptanceOfPromiseListView extends StandardListView<AcceptanceOfPromise> {
}