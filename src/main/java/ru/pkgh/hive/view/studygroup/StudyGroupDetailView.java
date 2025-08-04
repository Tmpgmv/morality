package ru.pkgh.hive.view.studygroup;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.pkgh.hive.entity.student.StudyGroup;
import ru.pkgh.hive.view.main.MainView;

@Route(value = "study-groups/:id", layout = MainView.class)
@ViewController(id = "hive_StudyGroup.detail")
@ViewDescriptor(path = "study-group-detail-view.xml")
@EditedEntityContainer("studyGroupDc")
public class StudyGroupDetailView extends StandardDetailView<StudyGroup> {
}