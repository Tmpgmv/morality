package ru.pkgh.hive.view.student;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import ru.pkgh.hive.entity.general.Student;
import ru.pkgh.hive.view.main.MainView;


@Route(value = "students", layout = MainView.class)
@ViewController(id = "hive_Student.list")
@ViewDescriptor(path = "student-list-view.xml")
@LookupComponent("studentsDataGrid")
@DialogMode(width = "64em")
public class StudentListView extends StandardListView<Student> {
}