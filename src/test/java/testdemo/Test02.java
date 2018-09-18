package testdemo;

import static org.junit.Assert.*;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class Test02 {

	@Test // 部署流程
	public void test01() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getRepositoryService().createDeployment().name("报销单流程审核").addClasspathResource("MyProcess.bpmn")
				.addClasspathResource("MyProcess.png").deploy();
	}

	@Test // 启动流程
	public void test02() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getRuntimeService().startProcessInstanceByKey("myProcess");
	}

	@Test // 根据处理人查询相关的任务
	public void test03() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		List<Task> tasks = processEngine.getTaskService().createTaskQuery().taskAssignee("李元芳").list();
		for (Task task : tasks) {
			System.out.println("任务id"+task.getId());
			System.out.println("流程实例"+task.getProcessInstanceId());
		}
	}
	
	@Test // 完成任务
	public void test04() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		List<Task> tasks = processEngine.getTaskService().createTaskQuery().taskAssignee("李元芳").list();
		for (Task task : tasks) {
			System.out.println("任务id"+task.getId());
			System.out.println("流程实例"+task.getProcessInstanceId());
		}
	}

}
