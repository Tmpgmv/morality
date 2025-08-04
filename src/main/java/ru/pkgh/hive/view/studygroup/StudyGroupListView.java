package ru.pkgh.hive.view.studygroup;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import ru.pkgh.hive.entity.student.StudyGroup;
import ru.pkgh.hive.view.main.MainView;


@Route(value = "study-groups", layout = MainView.class)
@ViewController(id = "hive_StudyGroup.list")
@ViewDescriptor(path = "study-group-list-view.xml")
@LookupComponent("studyGroupsDataGrid")
@DialogMode(width = "64em")
public class StudyGroupListView extends StandardListView<StudyGroup> {
}