package ru.pkgh.hive.view.student;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.pkgh.hive.entity.general.Student;
import ru.pkgh.hive.view.main.MainView;

@Route(value = "students/:id", layout = MainView.class)
@ViewController(id = "hive_Student.detail")
@ViewDescriptor(path = "student-detail-view.xml")
@EditedEntityContainer("studentDc")
public class StudentDetailView extends StandardDetailView<Student> {
}