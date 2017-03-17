package tao.book.sia.contacts.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tao.book.sia.contacts.model.Contact;
import tao.book.sia.contacts.repository.ContactRepository;
/**
 * 
 * @author 江涛
 *ContactController就是一个典型的Spring
MVC控制器。尽管Spring Boot会管理构建依赖并最小化Spring配置，
但是在编写应用逻辑的时候，编程模型是一致的。
在本例中，ContactController遵循了Spring MVC控制器的典型
模式，它会展现表单并处理表单的提交。其中home()方法使用注入
的ContactRepository来获取所有Contact对象的列表，并将它
们放到模型中，然后把请求转交给home视图。这个视图将会展现联
系人的列表以及添加新Contact的表单。submit()方法将会处理表
单提交的POST请求，保存Contact，并重定向到首页。
因为ContactController使用了@Controller注解，所以组件扫
描将会找到它。因此，我们不需要在Spring应用上下文中明确将其声
明为bean。

 */
@Controller
@RequestMapping("/")
public class ContactController {

	private ContactRepository contactRepo;

	@Autowired
	public ContactController(ContactRepository contactRepo) {
		this.contactRepo = contactRepo;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String home(Map<String,Object> model) {
		List<Contact> contacts = contactRepo.findAll();
		model.put("contacts", contacts);
		return "home";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String submit(Contact contact) {
		contactRepo.save(contact);
		return "redirect:/";
	}
}
