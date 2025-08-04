package ru.pkgh.hive.view.department;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.pkgh.hive.entity.general.Department;
import ru.pkgh.hive.view.main.MainView;

@Route(value = "departments/:id", layout = MainView.class)
@ViewController(id = "hive_Department.detail")
@ViewDescriptor(path = "department-detail-view.xml")
@EditedEntityContainer("departmentDc")
public class DepartmentDetailView extends StandardDetailView<Department> {
}