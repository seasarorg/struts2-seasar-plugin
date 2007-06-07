package org.seasar.struts2.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;

public class AddAction extends ActionSupport {
	private AddService addService;

	private AddDto addDto;

	private Log log = LogFactory.getLog(AddAction.class);

	public String execute() throws Exception {
		log.debug("arg1:" + addDto.getArg1());
		log.debug("arg2:" + addDto.getArg2());
		addDto.setResult(addService.add(addDto.getArg1(), addDto.getArg2()));
		log.debug("result:" + addDto.getResult());

		test();

		return SUCCESS;
	}

	public void setAddService(AddService addService) {
		this.addService = addService;
	}

	public void setAddDto(AddDto addDto) {
		this.addDto = addDto;
	}

	private void test() {
		debug(SingletonS2ContainerFactory.getContainer());

	}

	private void debug(S2Container container) {
		for (int i = 0; i < container.getComponentDefSize(); i++) {
			System.out.println(container.getComponentDef(i).getComponentName());
			System.out.println(container.getComponentDef(i).getComponentClass()
					.getName());
		}
		for (int i = 0; i < container.getChildSize(); i++) {
			debug(container.getChild(i));
		}
	}
}
