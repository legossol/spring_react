package shop.jinwookoh.api.item.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import shop.jinwookoh.api.common.service.AbstractService;
import shop.jinwookoh.api.item.domain.item;
import shop.jinwookoh.api.item.repository.ItemRepository;
@Service
public class ItemServiceImpl extends AbstractService<item> implements ItemService{

    // private final ItemRepository repository;

    @Override
    public Long save(item t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<item> findById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<item> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long count() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<item> getOne(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long delete(item t) {
        // TODO Auto-generated method stub
        return null;
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
    public void deleteById(long id) {
        // TODO Auto-generated method stub
        
    }

}
