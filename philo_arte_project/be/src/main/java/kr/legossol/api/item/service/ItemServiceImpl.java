package kr.legossol.api.item.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kr.legossol.api.common.service.AbstractService;
import kr.legossol.api.item.domain.Item;
import kr.legossol.api.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl extends AbstractService<Item> implements ItemService{

    private final ItemRepository repository;

    @Override
    public Long save(Item t) {
        // TODO Auto-generated method stub
        return (repository.save(t) != null) ? 1L : 0L;
    }

    @Override
    public Optional<Item> findById(long id) {
        
        return repository.findById(id);
    }

    @Override
    public List<Item> findAll() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }

    @Override
    public Long count() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Item> getOne(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long delete(Item item) {
        repository.delete(item);
        return (findById(item.getItemId()).orElse(null)==null) ? 1L: 0L;
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Boolean existsById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteById(long itemNo) {
        repository.deleteById(itemNo);
        
    }

    @Override
    public void updateItem(Long itemId, Item item) {
        Item i = repository.findById(itemId).get();
        i.setTitle(item.getTitle());
        i.setContent(item.getContent());
        i.setGoalPrice(item.getGoalPrice());
        repository.save(i);

    }
    
    // @Override
    // public Optional<Item> updateItem(Long itemNo, Item newItem){
    //     return repository.findById(itemNo)
    //         .map(oldItem ->{
    //             Item updating = oldItem.updateWith(newItem);
    //             return repository.save(updating);
    //         });
    //     }
    // }
    
}
