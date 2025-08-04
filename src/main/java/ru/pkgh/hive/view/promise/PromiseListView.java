package ru.pkgh.hive.view.promise;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import ru.pkgh.hive.entity.promise.Promise;
import ru.pkgh.hive.view.main.MainView;


@Route(value = "promises", layout = MainView.class)
@ViewController(id = "hive_Promise.list")
@ViewDescriptor(path = "promise-list-view.xml")
@LookupComponent("promisesDataGrid")
@DialogMode(width = "64em")
public class PromiseListView extends StandardListView<Promise> {
}