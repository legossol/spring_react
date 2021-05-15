package kr.legossol.api.item.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import kr.legossol.api.item.domain.Item;
import kr.legossol.api.item.service.ItemServiceImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@Api(tags = "item")
@RequestMapping("/item")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {
    private final ItemServiceImpl service;

    @GetMapping("/list")
    public ResponseEntity<List<Item>> list(){
        System.out.println("아이템리스트 진입");
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/list/{itemNo}")
    public ResponseEntity<Item> getOneItem(@PathVariable("itemNo") Long itemNo){
        Optional<Item> it = service.findById(itemNo);
        return ResponseEntity.ok(it.get());
    }
    @PostMapping("/register")
    public ResponseEntity<String> save(@RequestBody Item item){
        System.out.println("아이템 등록진입");
        service.save(item);
        return ResponseEntity.ok("등록을 성공했습니다.");
    }
    @PutMapping("/{itemNo}")
    public ResponseEntity<Item> updateItem(@PathVariable("itemNo") Long itemNo, @RequestBody Item item){
    System.out.println("아이템수정 진입" + itemNo);
    
    service.updateItem(itemNo,item);
    return ResponseEntity.ok(item);
    }   
    @DeleteMapping("/{itemNo}")
    public ResponseEntity<String> deleteItem(@PathVariable("itemNo")Long itemNo){
        service.deleteById(itemNo);
        return ResponseEntity.ok("삭제 성공");
    }
   
    
}

