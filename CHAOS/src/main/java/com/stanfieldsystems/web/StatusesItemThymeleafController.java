package com.stanfieldsystems.web;
import com.stanfieldsystems.Status;
import com.stanfieldsystems.service.api.StatusService;
import io.springlets.web.NotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * = StatusesItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = Status.class, type = ControllerType.ITEM)
//@RooThymeleaf
@Controller
@RequestMapping(value = "/statuses/{status}", name = "StatusesItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class StatusesItemThymeleafController {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public StatusService statusService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public MessageSource messageSource;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param statusService
     * @param messageSource
     */
    @Autowired
    public StatusesItemThymeleafController(StatusService statusService, MessageSource messageSource) {
        this.statusService = statusService;
        this.messageSource = messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Status
     */
    @ModelAttribute
    public Status getStatus(@PathVariable("status") Long id) {
        Status status = statusService.findOne(id);
        if (status == null) {
            throw new NotFoundException(String.format("Status with identifier '%s' not found", id));
        }
        return status;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute Status status, Model model) {
        return new ModelAndView("statuses/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     * @return UriComponents
     */
    public static UriComponents showURI(Status status) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(StatusesItemThymeleafController.class).show(status, null)).buildAndExpand(status.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dataBinder
     */
    @InitBinder("status")
    public void initStatusBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateForm(Model model) {
        populateFormats(model);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute Status status, Model model) {
        populateForm(model);
        return new ModelAndView("statuses/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Status status, BindingResult result, Model model) {
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("statuses/edit");
        }
        Status savedStatus = statusService.save(status);
        UriComponents showURI = StatusesItemThymeleafController.showURI(savedStatus);
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Status status) {
        statusService.delete(status);
        return ResponseEntity.ok().build();
    }
}
