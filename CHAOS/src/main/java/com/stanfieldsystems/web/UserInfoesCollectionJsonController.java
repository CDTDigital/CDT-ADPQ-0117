package com.stanfieldsystems.web;
import com.stanfieldsystems.UserInfo;
import com.stanfieldsystems.service.api.UserInfoService;
import io.springlets.data.domain.GlobalSearch;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * = UserInfoesCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = UserInfo.class, pathPrefix = "/api", type = ControllerType.COLLECTION)
//@RooJSON
@RestController
@RequestMapping(value = "/api/userinfoes", name = "UserInfoesCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserInfoesCollectionJsonController {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public UserInfoService userInfoService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param userInfoService
     */
    @Autowired
    public UserInfoesCollectionJsonController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "list")
    public ResponseEntity<Page<UserInfo>> list(GlobalSearch globalSearch, Pageable pageable) {
        Page<UserInfo> userInfoes = userInfoService.findAll(globalSearch, pageable);
        return ResponseEntity.status(HttpStatus.FOUND).body(userInfoes);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return UriComponents
     */
    public static UriComponents listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(UserInfoesCollectionJsonController.class).list(null, null)).build().encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(name = "create")
    public ResponseEntity<?> create(@Valid @RequestBody UserInfo userInfo, BindingResult result) {
        if (userInfo.getId() != null || userInfo.getVersion() != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        UserInfo newUserInfo = userInfoService.save(userInfo);
        UriComponents showURI = UserInfoesItemJsonController.showURI(newUserInfo);
        return ResponseEntity.created(showURI.toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfoes
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(value = "/batch", name = "createBatch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody Collection<UserInfo> userInfoes, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        userInfoService.save(userInfoes);
        return ResponseEntity.created(listURI().toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfoes
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(value = "/batch", name = "updateBatch")
    public ResponseEntity<?> updateBatch(@Valid @RequestBody Collection<UserInfo> userInfoes, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        userInfoService.save(userInfoes);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return ResponseEntity
     */
    @DeleteMapping(value = "/batch/{ids}", name = "deleteBatch")
    public ResponseEntity<?> deleteBatch(@PathVariable("ids") Collection<Long> ids) {
        userInfoService.delete(ids);
        return ResponseEntity.ok().build();
    }
}
