package ru.pkgh.hive.view.rejectionofpromise;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.pkgh.hive.entity.promise.RejectionOfPromise;
import ru.pkgh.hive.view.main.MainView;

@Route(value = "rejection-of-promises/:id", layout = MainView.class)
@ViewController(id = "hive_RejectionOfPromise.detail")
@ViewDescriptor(path = "rejection-of-promise-detail-view.xml")
@EditedEntityContainer("rejectionOfPromiseDc")
public class RejectionOfPromiseDetailView extends StandardDetailView<RejectionOfPromise> {
}