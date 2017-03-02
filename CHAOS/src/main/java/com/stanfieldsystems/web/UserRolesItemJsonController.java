package com.stanfieldsystems.web;
import com.stanfieldsystems.UserRole;

import com.stanfieldsystems.service.api.UserRoleService;
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
 * = UserRolesItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = UserRole.class, pathPrefix = "/api", type = ControllerType.ITEM)
//@RooJSON
@RestController
@RequestMapping(value = "/api/userroles/{userRole}", name = "UserRolesItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRolesItemJsonController {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public UserRoleService userRoleService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param userRoleService
     */
    @Autowired
    public UserRolesItemJsonController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return UserRole
     */
    @ModelAttribute
    public UserRole getUserRole(@PathVariable("userRole") Long id) {
        UserRole userRole = userRoleService.findOne(id);
        if (userRole == null) {
            throw new NotFoundException(String.format("UserRole with identifier '%s' not found", id));
        }
        return userRole;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute UserRole userRole) {
        return ResponseEntity.status(HttpStatus.FOUND).body(userRole);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     * @return UriComponents
     */
    public static UriComponents showURI(UserRole userRole) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(UserRolesItemJsonController.class).show(userRole)).buildAndExpand(userRole.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedUserRole
     * @param userRole
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute UserRole storedUserRole, @Valid @RequestBody UserRole userRole, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        userRole.setId(storedUserRole.getId());
        userRoleService.save(userRole);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute UserRole userRole) {
        userRoleService.delete(userRole);
        return ResponseEntity.ok().build();
    }
}
