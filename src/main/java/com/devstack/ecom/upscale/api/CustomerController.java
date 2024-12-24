package com.devstack.ecom.upscale.api;
import com.devstack.ecom.upscale.dto.request.RequestCustomerDto;
import com.devstack.ecom.upscale.service.CustomerService;
import com.devstack.ecom.upscale.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor

public class CustomerController {


    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestCustomerDto dto) {
        customerService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201 , "Customer was created.. ", null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> get(@PathVariable String id) {
        return new ResponseEntity<>(
                new StandardResponse(200 , "Customer data!.. ", customerService.findById(id)) ,
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> update(@PathVariable String id, @RequestBody RequestCustomerDto dto) {
        customerService.update(id, dto);
        return new ResponseEntity<>(
                new StandardResponse(201 , "Customer was updated!.. ", null) ,
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id) {
        customerService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(204 , "Customer was delete!.. ", null) ,
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAll(
           @RequestParam String searchText,
           @RequestParam  int page,
           @RequestParam  int size
    ) {

        return new ResponseEntity<>(
                new StandardResponse(200 , "Customer list!.. ",
                        customerService.findAll(searchText, page, size)) ,
                HttpStatus.OK
        );
    }
}
