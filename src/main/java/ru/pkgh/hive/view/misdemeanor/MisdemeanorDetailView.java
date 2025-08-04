package ru.pkgh.hive.view.misdemeanor;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.pkgh.hive.entity.misdemeanor.Misdemeanor;
import ru.pkgh.hive.view.main.MainView;

@Route(value = "misdemeanors/:id", layout = MainView.class)
@ViewController(id = "hive_Misdemeanor.detail")
@ViewDescriptor(path = "misdemeanor-detail-view.xml")
@EditedEntityContainer("misdemeanorDc")
public class MisdemeanorDetailView extends StandardDetailView<Misdemeanor> {
}