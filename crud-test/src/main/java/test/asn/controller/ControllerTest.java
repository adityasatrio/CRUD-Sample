package test.asn.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.asn.entity.Data;
import test.asn.service.ServiceTest;

import com.github.dandelion.datatables.core.ajax.DataSet;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;
import com.github.dandelion.datatables.core.ajax.DatatablesResponse;
import com.github.dandelion.datatables.extras.spring3.ajax.DatatablesParams;

@Controller
@RequestMapping(value = "/")
public class ControllerTest {

	@Autowired
	private ServiceTest serviceTest;

	@RequestMapping(value = "/mainPage", method = RequestMethod.GET)
	public String loadMainPage(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		return "/main";
	}

	@RequestMapping(value = "/submit/form", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String submitForm(@RequestBody Data data,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("executed  = " + data.toString());
		try {
			serviceTest.insert(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "'status':'ok'";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteData(@PathVariable(value = "id") String id,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			Data data = serviceTest.findById(Integer.valueOf(id));
			serviceTest.delete(data);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/mainPage";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable(value = "id") String id, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			Data data = serviceTest.findById(Integer.valueOf(id));

			DataForm dataForm = new DataForm();
			dataForm.setId(data.getId());
			dataForm.setUserName(data.getUserName());
			dataForm.setEmail(data.getEmail());
			dataForm.setPhoneNumber(data.getPhoneNumber());

			model.addAttribute("dataForm", dataForm);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/edit";
	}

	@RequestMapping(value = "/edit/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("dataForm") DataForm dataForm,
			HttpServletRequest request, HttpServletResponse response) {
		try {

			Data data = new Data(dataForm.getId(), dataForm.getUserName(),
					dataForm.getEmail(), dataForm.getPhoneNumber());
			serviceTest.update(data);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/mainPage";
	}

	@RequestMapping(value = "/ajax-datatables")
	public @ResponseBody DatatablesResponse<Data> findAll(
			@DatatablesParams DatatablesCriterias criterias, Model model) {
		System.out.println("criterias " + criterias.toString());

		Map<String, Object> dataParam = new HashMap<String, Object>();
		dataParam.put("criterias", criterias);

		DataSet<Data> dataSet = serviceTest.getDataTable(criterias);

		return DatatablesResponse.build(dataSet, criterias);

	}
}
