package ru.pkgh.hive.view.rejectionofpromise;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import ru.pkgh.hive.entity.promise.RejectionOfPromise;
import ru.pkgh.hive.view.main.MainView;


@Route(value = "rejection-of-promises", layout = MainView.class)
@ViewController(id = "hive_RejectionOfPromise.list")
@ViewDescriptor(path = "rejection-of-promise-list-view.xml")
@LookupComponent("rejectionOfPromisesDataGrid")
@DialogMode(width = "64em")
public class RejectionOfPromiseListView extends StandardListView<RejectionOfPromise> {
}