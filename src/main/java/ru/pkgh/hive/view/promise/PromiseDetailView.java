package ru.pkgh.hive.view.promise;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.pkgh.hive.entity.promise.Promise;
import ru.pkgh.hive.view.main.MainView;

@Route(value = "promises/:id", layout = MainView.class)
@ViewController(id = "hive_Promise.detail")
@ViewDescriptor(path = "promise-detail-view.xml")
@EditedEntityContainer("promiseDc")
public class PromiseDetailView extends StandardDetailView<Promise> {
}