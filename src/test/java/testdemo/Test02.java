package testdemo;

import static org.junit.Assert.*;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class Test02 {

	@Test // ��������
	public void test01() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getRepositoryService().createDeployment().name("�������������").addClasspathResource("MyProcess.bpmn")
				.addClasspathResource("MyProcess.png").deploy();
	}

	@Test // ��������
	public void test02() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getRuntimeService().startProcessInstanceByKey("myProcess");
	}

	@Test // ���ݴ����˲�ѯ��ص�����
	public void test03() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		List<Task> tasks = processEngine.getTaskService().createTaskQuery().taskAssignee("��Ԫ��").list();
		for (Task task : tasks) {
			System.out.println("����id"+task.getId());
			System.out.println("����ʵ��"+task.getProcessInstanceId());
		}
	}
	
	@Test // �������
	public void test04() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		List<Task> tasks = processEngine.getTaskService().createTaskQuery().taskAssignee("��Ԫ��").list();
		for (Task task : tasks) {
			System.out.println("����id"+task.getId());
			System.out.println("����ʵ��"+task.getProcessInstanceId());
		}
	}

}
