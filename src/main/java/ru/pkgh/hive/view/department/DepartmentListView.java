package ru.pkgh.hive.view.department;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import ru.pkgh.hive.entity.general.Department;
import ru.pkgh.hive.view.main.MainView;


@Route(value = "departments", layout = MainView.class)
@ViewController(id = "hive_Department.list")
@ViewDescriptor(path = "department-list-view.xml")
@LookupComponent("departmentsDataGrid")
@DialogMode(width = "64em")
public class DepartmentListView extends StandardListView<Department> {
}