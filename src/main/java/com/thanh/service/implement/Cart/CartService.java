package com.thanh.service.implement.Cart;

import com.thanh.dto.SanPhamDTO;
import com.thanh.entity.SanPhamEntity;
import com.thanh.repository.SanPhamRepository;
import com.thanh.service.interf.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SessionScope
@Service
public class CartService {
    @Autowired
    SanPhamRepository sanPhamRepository;
    Map<Integer, SanPhamEntity> map=new HashMap<>();
    public void add(Integer id){
        SanPhamEntity sp=map.get(id);
        if(sp==null){
            sp=sanPhamRepository.findById(id).get();
            sp.setSoLuong(1);
            map.put(id,sp);
        }
        else{
            sp.setSoLuong(sp.getSoLuong()+1);
        }

    }
    public void remove(Integer id){
        map.remove(id);
        map.size();
    }
    public void update(Integer id,int qty){
        SanPhamEntity p=map.get(id);
        p.setSoLuong(qty);
    }
    public void clear(){
        map.clear();
    }
    public int getCount(){
        Collection<SanPhamEntity>ps=this.getItems();
        int count=0;
        for (SanPhamEntity item:ps
             ) {
            count+=item.getSoLuong();
        }
        return count;
    }
    public Double getAmount(){
        Collection<SanPhamEntity>ps=this.getItems();
        double amount=0;
        for (SanPhamEntity item:ps
        ) {
            amount+=item.getSoLuong()*item.getGiaTien();
        }
        return amount;
    }

    public Collection<SanPhamEntity>getItems(){
        return map.values();
    }
}
