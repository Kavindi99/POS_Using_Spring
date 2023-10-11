package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
@CrossOrigin // will support to cors requests
public class ItemController {

    @Autowired
    ItemService service;

    @PostMapping
    public ResponseUtil saveItem(ItemDTO item) {
        service.saveItem(item);
        return new ResponseUtil("Ok","Successfully Added",item);
    }
    @DeleteMapping(params = {"code"})
    public ResponseUtil deleteItem(String code){
        service.deleteItem(code);
        return new ResponseUtil("Ok","Successfully Deleted",code);
    }

    @GetMapping
    public ResponseUtil getAllItem(){
        return new ResponseUtil("Ok","Successfully Loaded",service.getAllItem());
    }

    @GetMapping(params = {"id"})
    public ResponseUtil findItem(String id){
        return new ResponseUtil("Ok","Successfull", service.findItem(id));
    }

    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO c){
        service.updateItem(c);
        return new ResponseUtil("Ok","Successfully Updated",c);
    }
}
