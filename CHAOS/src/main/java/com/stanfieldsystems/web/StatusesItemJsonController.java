package com.stanfieldsystems.web;
import com.stanfieldsystems.Status;
import com.stanfieldsystems.service.api.StatusService;
import io.springlets.web.NotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * = StatusesItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = Status.class, pathPrefix = "/api", type = ControllerType.ITEM)
//@RooJSON
@RestController
@RequestMapping(value = "/api/statuses/{status}", name = "StatusesItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class StatusesItemJsonController {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public StatusService statusService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param statusService
     */
    @Autowired
    public StatusesItemJsonController(StatusService statusService) {
        this.statusService = statusService;
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
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Status status) {
        return ResponseEntity.status(HttpStatus.FOUND).body(status);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     * @return UriComponents
     */
    public static UriComponents showURI(Status status) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(StatusesItemJsonController.class).show(status)).buildAndExpand(status.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedStatus
     * @param status
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Status storedStatus, @Valid @RequestBody Status status, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        status.setId(storedStatus.getId());
        statusService.save(status);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Status status) {
        statusService.delete(status);
        return ResponseEntity.ok().build();
    }
}
