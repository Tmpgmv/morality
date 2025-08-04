package ru.pkgh.hive.view.typeofmisdemeanor;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.pkgh.hive.entity.misdemeanor.TypeOfMisdemeanor;
import ru.pkgh.hive.view.main.MainView;

@Route(value = "type-of-misdemeanors/:id", layout = MainView.class)
@ViewController(id = "hive_TypeOfMisdemeanor.detail")
@ViewDescriptor(path = "type-of-misdemeanor-detail-view.xml")
@EditedEntityContainer("typeOfMisdemeanorDc")
public class TypeOfMisdemeanorDetailView extends StandardDetailView<TypeOfMisdemeanor> {
}