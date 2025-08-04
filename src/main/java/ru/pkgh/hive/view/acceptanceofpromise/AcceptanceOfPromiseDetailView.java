package ru.pkgh.hive.view.acceptanceofpromise;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.pkgh.hive.entity.promise.AcceptanceOfPromise;
import ru.pkgh.hive.view.main.MainView;

@Route(value = "acceptance-of-promises/:id", layout = MainView.class)
@ViewController(id = "hive_AcceptanceOfPromise.detail")
@ViewDescriptor(path = "acceptance-of-promise-detail-view.xml")
@EditedEntityContainer("acceptanceOfPromiseDc")
public class AcceptanceOfPromiseDetailView extends StandardDetailView<AcceptanceOfPromise> {
}