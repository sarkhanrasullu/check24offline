package de.c24.finacc.klt.web.controller;

import de.c24.finacc.klt.entity.Request;
import de.c24.finacc.klt.form.RequestForm;
import de.c24.finacc.klt.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author Jörn Schricker
 */
@Controller
public class IndexController {

    /**
     * dependency for RequestRepository
     */
    @Qualifier("requestRepository")
    @Autowired
    private RequestRepository repository;

    /**
     * empty request formobject for index.jsp
     */
    @ModelAttribute("form")
    public RequestForm getSearchForm() {
        return new RequestForm();
    }
    /**
     * the index page
     * @return ModelAndView for index page.
     */
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(value = "success", required = false) Boolean success) {
        ModelAndView mav = new ModelAndView("/index");
        if (success != null && success) {
            mav.addObject("msg", "Thank you for your information");
        }
        return mav;
    }

    /**
     * the requests page
     * @return ModelAndView for requests page.
     */
    @RequestMapping(value = { "/requests" }, method = RequestMethod.GET)
    public ModelAndView requestsPage() {
        ModelAndView mav = new ModelAndView("/requests");
        return mav;
    }

    /**
     * the index page
     * @return post method to save request.
     */
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.POST)
    public ModelAndView postIndex(@ModelAttribute("form") RequestForm form) {
        ModelAndView mav = new ModelAndView("/index");
        Map<String, String> validation = form.validate();
        if (form.hasError()) {
            mav.addAllObjects(validation);
            return mav;
        }
        Request r = new Request();
        r.setFirstName(form.getFirstName());
        r.setLastName(form.getLastName());
        r.setAge(form.getAge());

        long id = repository.save(r);
        if (id > 0) {
            mav.setViewName("redirect:/index?success=true"); //redirect it otherwise on each refresh it will insert new row
        }
        return mav;
    }
}
